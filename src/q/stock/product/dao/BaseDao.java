package q.stock.product.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import q.stock.product.dto.SearchDto;
import q.stock.product.filter.Utils;

public abstract class BaseDao<T> {

	private Class<T> type;
	@PersistenceContext(unitName = "QStockProductPU")
	protected EntityManager em;

	@Resource
	private UserTransaction userTransaction;

	public BaseDao() {
		super();
	}

	@SuppressWarnings("unchecked")
	public BaseDao(Class<T> entityType) {
		this.type = entityType;
	}

	public long count() {
		String entity = type.getSimpleName();
		final StringBuffer queryString = new StringBuffer("select count(ent) from " + entity + " ent");
		final Query query = this.em.createQuery(queryString.toString());
		return (Long) query.getSingleResult();
	}

	public T create(final T t) throws Exception {
		userTransaction.begin();
		em.persist(t);
		userTransaction.commit();
		return t;
	}

	public void delete(final Object id) throws Exception {
		userTransaction.begin();
		em.remove(em.getReference(type, id));
		userTransaction.commit();
	}

	public T find(final Object id) {
		return em.find(type, id);
	}

	public T update(T t) throws Exception {
		userTransaction.begin();
		t = em.merge(t);
		userTransaction.commit();
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = em.createQuery("from " + type.getName());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(String parameter, String value) {
		Query query = em.createQuery("SELECT e FROM " + type.getName() + " e where e." + parameter + "=" + value);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> filter(List<SearchDto> filters) {
		String filterValue = Utils.getCriteria(filters);
		String sql = "SELECT e FROM " + type.getName() + " e where " + filterValue;
		System.out.println(sql);
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}

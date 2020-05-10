package q.stock.product.service;

import java.util.List;

import q.stock.product.dao.ProdutDao;
import q.stock.product.dto.SearchDto;
import q.stock.product.model.entity.Product;

public class ProductService {

	private ProdutDao produtDao = new ProdutDao();

	public List<Product> filter(List<SearchDto> filters) {
		return produtDao.filter(filters);
	}
}

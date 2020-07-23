package q.stock.product.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import q.stock.product.dto.Dashboard;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class DashboardDao {

	@PersistenceContext(unitName = "QStockProductPU")
	protected EntityManager em;

	public Dashboard getDashboard() {
		Dashboard dashboard = new Dashboard();
		getStockValue(dashboard);
		getMonthlySales(dashboard);
		getTotlalSuppliers(dashboard);
		getTotlalCutomer(dashboard);
		getTotalProducts(dashboard);
		getDailySales(dashboard);
		getDailyPurchase(dashboard);
		getYearlySales(dashboard);
		getYearlyPurchase(dashboard);
		return dashboard;
	}

	private void getStockValue(Dashboard dashboard) {
		Query q = em.createNativeQuery(
				"select sum(a.averageprice*b.totalquantity) as stockValues from (SELECT product_id , avg(p.purchase_price) as averageprice\r\n"
						+ "from inv_purchase_order_products p\r\n" + "group by product_id \r\n"
						+ "order by product_id\r\n" + ") a  , (\r\n"
						+ "SELECT  s.product_id , sum(s.quantity)  as totalquantity\r\n" + "from inv_live_stock s \r\n"
						+ "group by s.product_id \r\n" + "order by s.product_id\r\n"
						+ ") b where a.product_id = b.product_id");
		BigDecimal stockValues = (BigDecimal) q.getResultList().get(0);
		dashboard.setStockValues(stockValues);
	}

	private void getMonthlySales(Dashboard dashboard) {
		Query q = em.createNativeQuery(
				"SELECT sum(p.sales_price*p.quantity) as monthlySales from inv_sales_order_product p\r\n"
						+ " join inv_sales_order o on o.id = p.sales_id\r\n"
						+ " where o.created between  (select  (NOW() - interval '1 month'))\r\n" + "and  NOW()");
		BigDecimal monthlySales = (BigDecimal) q.getResultList().get(0);
		dashboard.setMonthlySales(monthlySales);

	}

	private void getTotlalSuppliers(Dashboard dashboard) {
		Query q = em.createNativeQuery("SELECT count(*) from sup_supplier");
		BigInteger totlalSuppliers = (BigInteger) q.getResultList().get(0);
		dashboard.setTotlalSuppliers(totlalSuppliers);
	}

	private void getTotlalCutomer(Dashboard dashboard) {
		Query q = em.createNativeQuery("SELECT count(*) from cst_customer");
		BigInteger totlalCutomer = (BigInteger) q.getResultList().get(0);
		dashboard.setTotlalCutomer(totlalCutomer);
	}

	private void getTotalProducts(Dashboard dashboard) {
		Query q = em.createNativeQuery("SELECT count(*) from prd_product");
		BigInteger totalProducts = (BigInteger) q.getResultList().get(0);
		dashboard.setTotalProducts(totalProducts);

	}

	private void getDailySales(Dashboard dashboard) {
		List<LocalDate> localDates = LocalDate.now().minusMonths(1).datesUntil(LocalDate.now())
				.collect(Collectors.toList());
		Query q = em.createNativeQuery("SELECT count(*) , to_char(created, 'YYYY-MM-DD') from inv_sales_order o\r\n"
				+ "where o.created between  (select  (NOW() - interval '1 month'))\r\n" + "and  NOW()\r\n"
				+ "group by to_char(created, 'YYYY-MM-DD')\r\n" + "order by 1\r\n" + "");

		List<Object[]> dailySales = q.getResultList();
		Map<String, String> dailySalesMap = new HashMap<String, String>();
		for (Object[] a : dailySales) {
			dailySalesMap.put(a[1].toString(), a[0].toString());
		}

		for (LocalDate day : localDates) {
			if (!dailySalesMap.containsKey(day.toString())) {
				dailySalesMap.put(day.toString(), String.valueOf(0));
			}
		}

		dashboard.setDailySales(dailySalesMap);

	}

	private void getDailyPurchase(Dashboard dashboard) {
		List<LocalDate> localDates = LocalDate.now().minusMonths(1).datesUntil(LocalDate.now())
				.collect(Collectors.toList());
		Query q = em.createNativeQuery("SELECT count(*) , to_char(created, 'YYYY-MM-DD') from inv_purchase_order  o\r\n"
				+ "where o.created between  (select  (NOW() - interval '1 month'))\r\n" + "and  NOW()\r\n"
				+ "group by to_char(created, 'YYYY-MM-DD')\r\n" + "order by 1");

		List<Object[]> dailyPurchase = q.getResultList();
		Map<String, String> dailyPurchaseMap = new HashMap<String, String>();
		for (Object[] a : dailyPurchase) {
			dailyPurchaseMap.put(a[1].toString(), a[0].toString());
		}

		for (LocalDate day : localDates) {
			if (!dailyPurchaseMap.containsKey(day.toString())) {
				dailyPurchaseMap.put(day.toString(), String.valueOf(0));
			}
		}

		dashboard.setDailyPurchase(dailyPurchaseMap);

	}

	private void getYearlySales(Dashboard dashboard) {
		List<String> months = getlastYearMonths();
		Query q = em.createNativeQuery("select to_char(created, 'YYYY-MM') as month, count(*) as salesNumber\r\n"
				+ "from inv_sales_order\r\n" + "where created between  (select  (NOW() - interval '1 year'))\r\n"
				+ "and  NOW()\r\n" + "group by to_char(created, 'YYYY-MM')\r\n" + "order by 1");

		List<Object[]> dailyPurchase = q.getResultList();
		Map<String, String> yearlSalesMap = new HashMap<String, String>();
		for (Object[] a : dailyPurchase) {
			yearlSalesMap.put(a[0].toString(), a[1].toString());
		}

		for (String month : months) {
			if (!yearlSalesMap.containsKey(month)) {
				yearlSalesMap.put(month, String.valueOf(0));
			}
		}

		dashboard.setYearlySales(yearlSalesMap);

	}

	private void getYearlyPurchase(Dashboard dashboard) {
		List<String> months = getlastYearMonths();
		Query q = em.createNativeQuery("select to_char(created, 'YYYY-MM') as month, count(*) as salesNumber\r\n"
				+ "from inv_purchase_order\r\n" + "where created between  (select  (NOW() - interval '1 year'))\r\n"
				+ "and  NOW()\r\n" + "group by to_char(created, 'YYYY-MM')\r\n" + "order by 1");

		List<Object[]> dailyPurchase = q.getResultList();
		Map<String, String> yearlPurchaseMap = new HashMap<String, String>();
		for (Object[] a : dailyPurchase) {
			yearlPurchaseMap.put(a[0].toString(), a[1].toString());
		}

		for (String month : months) {
			if (!yearlPurchaseMap.containsKey(month)) {
				yearlPurchaseMap.put(month, String.valueOf(0));
			}
		}

		dashboard.setYearlyPurchase(yearlPurchaseMap);

	}

	private List<String> getlastYearMonths() {
		List<String> months = new ArrayList<>();
		LocalDate date1 = LocalDate.now().minusYears(1);
		LocalDate date2 = LocalDate.now();
		System.out.println(date1.isBefore(date2));
		while (date1.isBefore(date2)) {
			months.add(date1.format(DateTimeFormatter.ofPattern("YYYY-MM")));
			date1 = date1.plus(Period.ofMonths(1));
		}

		return months;
	}
}

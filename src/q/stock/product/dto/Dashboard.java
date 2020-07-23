package q.stock.product.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public class Dashboard {

	private BigDecimal stockValues;

	private BigDecimal monthlySales;
	
	private BigInteger totlalSuppliers;
	
	private BigInteger totlalCutomer;

	private BigInteger totalProducts;
	
	private Map<String , String> dailySales;

	private Map<String , String> dailyPurchase;
	
	private Map<String , String> yearlySales;

	private Map<String , String> yearlyPurchase;

	public BigDecimal getStockValues() {
		return stockValues;
	}

	public void setStockValues(BigDecimal stockValues) {
		this.stockValues = stockValues;
	}

	public BigDecimal getMonthlySales() {
		return monthlySales;
	}

	public void setMonthlySales(BigDecimal monthlySales) {
		this.monthlySales = monthlySales;
	}

	public BigInteger getTotlalSuppliers() {
		return totlalSuppliers;
	}

	public void setTotlalSuppliers(BigInteger totlalSuppliers) {
		this.totlalSuppliers = totlalSuppliers;
	}

	public BigInteger getTotlalCutomer() {
		return totlalCutomer;
	}

	public void setTotlalCutomer(BigInteger totlalCutomer) {
		this.totlalCutomer = totlalCutomer;
	}

	public BigInteger getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(BigInteger totalProducts) {
		this.totalProducts = totalProducts;
	}

	public Map<String, String> getDailySales() {
		return dailySales;
	}

	public void setDailySales(Map<String, String> dailySales) {
		this.dailySales = dailySales;
	}

	public Map<String, String> getDailyPurchase() {
		return dailyPurchase;
	}

	public void setDailyPurchase(Map<String, String> dailyPurchase) {
		this.dailyPurchase = dailyPurchase;
	}

	public Map<String, String> getYearlySales() {
		return yearlySales;
	}

	public void setYearlySales(Map<String, String> yearlySales) {
		this.yearlySales = yearlySales;
	}

	public Map<String, String> getYearlyPurchase() {
		return yearlyPurchase;
	}

	public void setYearlyPurchase(Map<String, String> yearlyPurchase) {
		this.yearlyPurchase = yearlyPurchase;
	}
	
	
	
	

}

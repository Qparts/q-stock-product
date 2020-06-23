package q.stock.product.dto;

import java.util.List;

import q.stock.product.model.entity.PurchaseOrder;
import q.stock.product.model.entity.SalesOrder;

public class ProductDetialDto {

	private double averagePrice;
	private int qunatityInLiveStock;
	private int previousYearSalesOrders;
	private int previousYearPurchaseOrder;
	private List<PurchaseOrder> lastThreePurchaseOrders;
	private List<SalesOrder> lastThreeSalesOrders;

	public ProductDetialDto() {

	}

	public ProductDetialDto(double averagePrice, int qunatityInLiveStock, int previousYearSalesOrders,
			int previousYearPurchaseOrder, List<PurchaseOrder> lastThreePurchaseOrders,
			List<SalesOrder> lastThreeSalesOrders) {
		super();
		this.averagePrice = averagePrice;
		this.qunatityInLiveStock = qunatityInLiveStock;
		this.previousYearSalesOrders = previousYearSalesOrders;
		this.previousYearPurchaseOrder = previousYearPurchaseOrder;
		this.lastThreePurchaseOrders = lastThreePurchaseOrders;
		this.lastThreeSalesOrders = lastThreeSalesOrders;
	}

	public double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}

	public int getQunatityInLiveStock() {
		return qunatityInLiveStock;
	}

	public void setQunatityInLiveStock(int qunatityInLiveStock) {
		this.qunatityInLiveStock = qunatityInLiveStock;
	}

	public int getPreviousYearSalesOrders() {
		return previousYearSalesOrders;
	}

	public void setPreviousYearSalesOrders(int previousYearSalesOrders) {
		this.previousYearSalesOrders = previousYearSalesOrders;
	}

	public int getPreviousYearPurchaseOrder() {
		return previousYearPurchaseOrder;
	}

	public void setPreviousYearPurchaseOrder(int previousYearPurchaseOrder) {
		this.previousYearPurchaseOrder = previousYearPurchaseOrder;
	}

	public List<PurchaseOrder> getLastThreePurchaseOrders() {
		return lastThreePurchaseOrders;
	}

	public void setLastThreePurchaseOrders(List<PurchaseOrder> lastThreePurchaseOrders) {
		this.lastThreePurchaseOrders = lastThreePurchaseOrders;
	}

	public List<SalesOrder> getLastThreeSalesOrders() {
		return lastThreeSalesOrders;
	}

	public void setLastThreeSalesOrders(List<SalesOrder> lastThreeSalesOrders) {
		this.lastThreeSalesOrders = lastThreeSalesOrders;
	}

	@Override
	public String toString() {
		return "ProductDetialDto [averagePrice=" + averagePrice + ", qunatityInLiveStock=" + qunatityInLiveStock
				+ ", previousYearSalesOrders=" + previousYearSalesOrders + ", previousYearPurchaseOrder="
				+ previousYearPurchaseOrder + ", lastThreePurchaseOrders=" + lastThreePurchaseOrders
				+ ", lastThreeSalesOrders=" + lastThreeSalesOrders + "]";
	}

}

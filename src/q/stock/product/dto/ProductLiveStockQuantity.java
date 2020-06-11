package q.stock.product.dto;

public class ProductLiveStockQuantity {
	private int productId;
	private int totalQuantity;

	public ProductLiveStockQuantity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductLiveStockQuantity(int productId, int totalQuantity) {
		super();
		this.productId = productId;
		this.totalQuantity = totalQuantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	@Override
	public String toString() {
		return "ProductLiveStockQuantity [productId=" + productId + ", totalQuantity=" + totalQuantity + "]";
	}

}

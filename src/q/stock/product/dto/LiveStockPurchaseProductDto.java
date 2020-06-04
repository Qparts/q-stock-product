package q.stock.product.dto;

public class LiveStockPurchaseProductDto {
	private int liveStockId;
	private int liveStockQuantity;
	private int purchaseProductId;
	private int purchaseProductQuantity;
	private int purchaseProductPurchaseId;

	public LiveStockPurchaseProductDto() {
	}

	public LiveStockPurchaseProductDto(int liveStockId, int liveStockQuantity, int purchaseProductId,
			int purchaseProductQuantity, int purchaseProductPurchaseId) {
		this.liveStockId = liveStockId;
		this.liveStockQuantity = liveStockQuantity;
		this.purchaseProductId = purchaseProductId;
		this.purchaseProductQuantity = purchaseProductQuantity;
		this.purchaseProductPurchaseId = purchaseProductPurchaseId;
	}

	public int getLiveStockId() {
		return liveStockId;
	}

	public void setLiveStockId(int liveStockId) {
		this.liveStockId = liveStockId;
	}

	public int getLiveStockQuantity() {
		return liveStockQuantity;
	}

	public void setLiveStockQuantity(int liveStockQuantity) {
		this.liveStockQuantity = liveStockQuantity;
	}

	public int getPurchaseProductId() {
		return purchaseProductId;
	}

	public void setPurchaseProductId(int purchaseProductId) {
		this.purchaseProductId = purchaseProductId;
	}

	public int getPurchaseProductQuantity() {
		return purchaseProductQuantity;
	}

	public void setPurchaseProductQuantity(int purchaseProductQuantity) {
		this.purchaseProductQuantity = purchaseProductQuantity;
	}

	public int getPurchaseProductPurchaseId() {
		return purchaseProductPurchaseId;
	}

	public void setPurchaseProductPurchaseId(int purchaseProductPurchaseId) {
		this.purchaseProductPurchaseId = purchaseProductPurchaseId;
	}

}

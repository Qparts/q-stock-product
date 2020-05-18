package q.stock.product.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "inv_live_stock")
public class LiveStock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "inv_live_stock_id_seq_gen", sequenceName = "inv_live_stock_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "inv_live_stock_id_seq_gen")
	@Column(name = "id")
	private int id;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "purchase_id")
	private int purchaseId;

	@Column(name = "vendor_id")
	private int vendorId;

	@Column(name = "quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "LiveStock [id=" + id + ", productId=" + productId + ", purchaseId=" + purchaseId + ", vendorId="
				+ vendorId + ", quantity=" + quantity + "]";
	}

}

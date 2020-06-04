package q.stock.product.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "inv_sales_order_product")
public class SalesOrderProduct implements Serializable {

	@Id
	@SequenceGenerator(name = "inv_sales_order_product_id_seq_gen", sequenceName = "inv_sales_order_product_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "inv_sales_order_product_id_seq_gen")
	@Column(name = "id")
	private int id;
	@Column(name = "product_id")
	private int productId;
	@Column(name = "purchase_product_id")
	private int purchaseProductId;
	@Column(name = "sales_price")
	private double price;
	@Column(name = "quantity")
	private int quantity;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sales_id")
	private SalesOrder salesOrder;

	public SalesOrderProduct() {
		super();
	}

	public SalesOrderProduct(int id, int productId, int purchaseProductId, double price, int quantity,
			SalesOrder salesOrder) {
		this.id = id;
		this.productId = productId;
		this.purchaseProductId = purchaseProductId;
		this.price = price;
		this.quantity = quantity;
		this.salesOrder = salesOrder;
	}

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

	public int getPurchaseProductId() {
		return purchaseProductId;
	}

	public void setPurchaseProductId(int purchaseProductId) {
		this.purchaseProductId = purchaseProductId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	@Override
	public String toString() {
		return "SalesOrderProduct [id=" + id + ", productId=" + productId + ", purchaseProductId=" + purchaseProductId
				+ ", price=" + price + ", quantity=" + quantity + ", salesOrder=" + salesOrder + "]";
	}

}

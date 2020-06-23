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
@Table(name = "inv_quotation_order_product")
public class QuotationOrderProduct implements Serializable{

	@Id
	@SequenceGenerator(name = "inv_quotation_order_product_id_seq_gen", sequenceName = "inv_quotation_order_product_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "inv_quotation_order_product_id_seq_gen")
	@Column(name = "id")
	private int id;
	@Column(name = "product_id")
	private int productId;
	@Column(name = "sales_price")
	private double price;
	@Column(name = "quantity")
	private int quantity;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "quotation_id")
	private QuotationOrder quotationOrder;

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

	public QuotationOrder getQuotationOrder() {
		return quotationOrder;
	}

	public void setQuotationOrder(QuotationOrder quotationOrder) {
		this.quotationOrder = quotationOrder;
	}

	@Override
	public String toString() {
		return "QuotationOrderProduct [id=" + id + ", productId=" + productId + ", price=" + price + ", quantity="
				+ quantity + ", quotationOrder=" + quotationOrder + "]";
	}

}

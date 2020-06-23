package q.stock.product.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "inv_quotation_order")
public class QuotationOrder implements Serializable{
	@Id
	@SequenceGenerator(name = "inv_quotation_order_id_seq_gen", sequenceName = "inv_quotation_order_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "inv_quotation_order_id_seq_gen")
	@Column(name = "id")
	private int id;
	@Column(name = "vendor_id")
	private int vendorId;
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "invoice_name")
	private String invoiceName;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "vat_number")
	private String vatNumber;

	@Column(name = "vat_percentage")
	private double vatPercentage;

	@Column(name = "quotation_price")
	private double price;

	@Column(name = "created")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date created;
	@Column(name = "created_by")
	private int createdBy;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "quotation_id")
	private Set<QuotationOrderProduct> quotationOrderProducts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public double getVatPercentage() {
		return vatPercentage;
	}

	public void setVatPercentage(double vatPercentage) {
		this.vatPercentage = vatPercentage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Set<QuotationOrderProduct> getQuotationOrderProducts() {
		return quotationOrderProducts;
	}

	public void setQuotationOrderProducts(Set<QuotationOrderProduct> quotationOrderProducts) {
		this.quotationOrderProducts = quotationOrderProducts;
	}

	@Override
	public String toString() {
		return "QuotationOrder [id=" + id + ", vendorId=" + vendorId + ", customerId=" + customerId + ", invoiceName="
				+ invoiceName + ", phoneNumber=" + phoneNumber + ", vatNumber=" + vatNumber + ", vatPercentage="
				+ vatPercentage + ", price=" + price + ", created=" + created + ", createdBy=" + createdBy
				+ ", quotationOrderProducts=" + quotationOrderProducts + "]";
	}

}

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "inv_sales_order")
public class SalesOrder implements Serializable {
	@Id
	@SequenceGenerator(name = "inv_sales_order_id_seq_gen", sequenceName = "inv_sales_order_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "inv_sales_order_id_seq_gen")
	@Column(name = "id")
	private int id;
	@Column(name = "vendor_id")
	private int vendorId;
	@Column(name = "created")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date created;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "invoice_name")
	private String invoiceName;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "sales_type")
	private char salesType;
	@Column(name = "vat_number")
	private String vatNumber;
	@Column(name = "vat_percentage")
	private double vatPercentage;
	@Transient
	private String errorMessage;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "sales_id")
	private Set<SalesOrderProduct> salesOrderProducts;

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

	public char getSalesType() {
		return salesType;
	}

	public void setSalesType(char salesType) {
		this.salesType = salesType;
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

	public Set<SalesOrderProduct> getSalesOrderProducts() {
		return salesOrderProducts;
	}

	public void setSalesOrderProducts(Set<SalesOrderProduct> salesOrderProducts) {
		this.salesOrderProducts = salesOrderProducts;
	}
	
	

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "SalesOrder [id=" + id + ", vendorId=" + vendorId + ", created=" + created + ", createdBy=" + createdBy
				+ ", customerId=" + customerId + ", invoiceName=" + invoiceName + ", phoneNumber=" + phoneNumber
				+ ", salesType=" + salesType + ", vatNumber=" + vatNumber + ", vatPercentage=" + vatPercentage
				+ ", errorMessage=" + errorMessage + ", salesOrderProducts=" + salesOrderProducts + "]";
	}

	

}

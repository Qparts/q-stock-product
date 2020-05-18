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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "inv_purchase_order")
public class PurchaseOrder implements Serializable {

	@Id
	@SequenceGenerator(name = "inv_purchase_order_id_seq_gen", sequenceName = "inv_purchase_order_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "inv_purchase_order_id_seq_gen")
	@Column(name = "id")
	private int id;
	@Column(name = "vendor_id")
	private int vendorId;
	@Column(name = "created")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date created;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "supplier_id")
	private int supplierId;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "purchase_id")
	private Set<PurchaseOrderProducts> purchaseProducts;

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

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public Set<PurchaseOrderProducts> getPurchaseProducts() {
		return purchaseProducts;
	}

	public void setPurchaseProducts(Set<PurchaseOrderProducts> purchaseProducts) {
		this.purchaseProducts = purchaseProducts;
	}

}

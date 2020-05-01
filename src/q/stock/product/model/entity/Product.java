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

@Entity
@Table(name = "prd_product")
public class Product implements Serializable {
	@Id
	@SequenceGenerator(name = "prd_product_id_seq_gen", sequenceName = "prd_product_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "prd_product_id_seq_gen")
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "vendor_id")
	private int vendorId;
	@JoinColumn(name = "brand_id")
	@ManyToOne
	private Brand brand;
//	@JoinColumn(name = "category_id")
//	@ManyToOne
//	private Category category;
	@Column(name = "notes")
	private String notes;
	@Column(name = "created")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date created;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "status")
	private char status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Set<ProductPrice> productPrices;

	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Set<Category> categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public Set<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(Set<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}

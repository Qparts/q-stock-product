package q.stock.product.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity

@Table(name="prd_price",uniqueConstraints= {@UniqueConstraint(columnNames={"product_id","price_type"})})
public class ProductPrice implements Serializable {
    @Id
    @SequenceGenerator(name = "prd_price_id_seq_gen", sequenceName = "prd_price_id_seq", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "prd_price_id_seq_gen")
    @Column(name="id")
    private int id;
//    @Column(name="product_id")
//    private int productId;
    @Column(name="vendor_id")
    private int vendorId;
    @Column(name="price_type")
    private char priceType;//S = sales price, W = whoelsales price, S = special price;
    @Column(name="status")
    private char status;
    @Column(name="price")
    private double price;
    @JsonIgnore
    @Column(name="created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Column(name="created_by")
    @JsonIgnore
    private int createdBy;
    @Column(name="archived")
    private Date archived;
    @JsonIgnore
    @ManyToOne
    private Product product;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//
//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public char getPriceType() {
        return priceType;
    }

    public void setPriceType(char priceType) {
        this.priceType = priceType;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
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

    public Date getArchived() {
        return archived;
    }

    public void setArchived(Date archived) {
        this.archived = archived;
    }

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    
}

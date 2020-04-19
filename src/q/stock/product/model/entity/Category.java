package q.stock.product.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="prd_category")
public class Category implements Serializable {
    @Id
    @SequenceGenerator(name = "prd_category_id_seq_gen", sequenceName = "prd_category_id_seq", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "prd_category_id_seq_gen")
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="vendor_id")
    private int vendorId;
    @Column(name="created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date created;
    @Column(name="status")
    private char status;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}

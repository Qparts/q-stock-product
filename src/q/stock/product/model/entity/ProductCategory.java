package q.stock.product.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="prd_product_category")
@IdClass(ProductCategory.ProductCategoryPK.class)
public class ProductCategory implements Serializable {

    @Id
    @Column(name="category_id")
    private int categoryId;
    @Id
    @Column(name="product_id")
    private int productId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public static class ProductCategoryPK implements Serializable{
        private static final long serialVersionUID = 1L;
        protected int productId;
        protected int categoryId;

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + productId;
            result = prime * result + categoryId;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ProductCategoryPK other = (ProductCategoryPK) obj;
            if (productId != other.productId)
                return false;
            if (categoryId != other.categoryId)
                return false;
            return true;
        }



    }
}

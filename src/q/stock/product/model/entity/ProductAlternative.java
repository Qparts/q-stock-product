package q.stock.product.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="prd_product_alternative")
@IdClass(ProductAlternative.ProductAlternativePK.class)
public class ProductAlternative implements Serializable {

    @Id
    @Column(name="product_id")
    private int productId;
    @Id
    @Column(name="alternative_id")
    private int alternativeId;


    public int getAlternativeId() {
        return alternativeId;
    }

    public void setAlternativeId(int alternativeId) {
        this.alternativeId = alternativeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public static class ProductAlternativePK implements Serializable{
        private static final long serialVersionUID = 1L;
        protected int productId;
        protected int alternativeId;

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + productId;
            result = prime * result + alternativeId;
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
            ProductAlternative other = (ProductAlternative) obj;
            if (productId != other.productId)
                return false;
            if (alternativeId != other.alternativeId)
                return false;
            return true;
        }



    }
}

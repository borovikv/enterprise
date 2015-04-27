package md.varoinform.model.entities.product;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.utils.DB;

import javax.persistence.*;


/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.PRODUCT + "title")
public class ProductTitle extends Title<Product> {
    private Product product;
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
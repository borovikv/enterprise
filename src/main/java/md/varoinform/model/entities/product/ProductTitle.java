package md.varoinform.model.entities.product;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.PRODUCT + "Title")
public class ProductTitle extends Title<Product> {
    @Override
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getContainer() {
        return container;
    }
}
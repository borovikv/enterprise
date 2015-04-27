package md.varoinform.model.entities.product;

import md.varoinform.model.entities.base.TitleContainer;
import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.PRODUCT + "product")
public class Product extends TitleContainer<ProductTitle> {
    @Override
    @JoinColumn(name = "product_id")
    public List<ProductTitle> getTitles() {
        return titles;
    }
}
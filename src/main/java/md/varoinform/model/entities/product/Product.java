package md.varoinform.model.entities.product;

import md.varoinform.model.entities.base.TitleContainer;
import md.varoinform.model.utils.DB;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.PRODUCT + "product")
public class Product extends TitleContainer<ProductTitle> {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @IndexedEmbedded(includePaths = {"title"})
    public List<ProductTitle> getTitles() {
        return titles;
    }
}
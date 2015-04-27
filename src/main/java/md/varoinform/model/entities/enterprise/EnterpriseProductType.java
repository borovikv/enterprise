package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.product.Product;
import md.varoinform.model.entities.product.ProductType;
import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.*;

import javax.persistence.*;


/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.ENTERPRISE + "product_type")
public class EnterpriseProductType {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType type;

}
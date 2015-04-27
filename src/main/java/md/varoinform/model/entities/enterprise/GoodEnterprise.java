package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.product.Product;
import md.varoinform.model.entities.product.ProductType;
import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 4/8/14
 * Time: 9:26 AM
 */
@SuppressWarnings("UnusedDeclaration")
@Entity
@Table(name = DB.SCHEMA + "DB_Good_Enterprise")
public class GoodEnterprise {
    private Long id;
    private Enterprise enterprise;
    private Product product;
    private ProductType productType;

    public GoodEnterprise() {
    }



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    @ContainedIn
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @ManyToOne
    @JoinColumn(name = "good_id")
    @IndexedEmbedded(includePaths = "titles.title")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public int hashCode() {
        return product.getTitles().hashCode();
    }

    @Override
    public String toString() {
        return "GoodEnterprise{" +
                "id=" + id +
                ", enterprise=" + enterprise.getId() +
                ", product=" + product +
                ", type=" + productType +
                '}';
    }
}

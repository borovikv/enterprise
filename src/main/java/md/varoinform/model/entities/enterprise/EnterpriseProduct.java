package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.product.Product;
import md.varoinform.model.entities.product.ProductType;
import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 4/8/14
 * Time: 9:26 AM
 */
@SuppressWarnings("UnusedDeclaration")
@Entity
@Table(name = DB.SCHEMA + DB.ENTERPRISE + "product")
public class EnterpriseProduct {
    private Integer id;
    private Enterprise enterprise;
    private Product product;
    private List<ProductType> productTypes;

    public EnterpriseProduct() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    @JoinColumn(name = "product_id")
    @IndexedEmbedded(includePaths = "titles.title")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToMany
    @JoinTable(name = DB.SCHEMA + DB.ENTERPRISE + "product_type", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
    public List<ProductType> getProductType() {
        return productTypes;
    }

    public void setProductType(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public int hashCode() {
        return product.getTitles().hashCode();
    }

    @Override
    public String toString() {
        return "EnterpriseProduct{" +
                "id=" + id +
                ", enterprise=" + enterprise.getId() +
                ", product=" + product +
                ", type=" + productTypes +
                '}';
    }
}

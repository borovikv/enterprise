package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.address.AddressNode;
import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.*;

import javax.persistence.*;


/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.ENTERPRISE + "location")
public class Location {
    private Integer id;
    private String office;
    private Enterprise enterprise;
    private AddressNode addressNode;

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

    @Column(name = "office")
    @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Analyzer(definition = "customanalyzer")
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @ManyToOne
    @JoinColumn(name = "address_id")
    @IndexedEmbedded(includePaths = {"titles.title", "parent.titles.title", "parent.parent.titles.title", "paarent.parent.parent.titles.title"})
    public AddressNode getAddressNode() {
        return addressNode;
    }

    public void setAddressNode(AddressNode addressNode) {
        this.addressNode = addressNode;
    }

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
package md.varoinform.model.entities.address;

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
@Table(name = DB.SCHEMA + DB.ADDRESS + "node")
public class AddressNode extends TitleContainer<AddressNodeTitle> {
    private AddressNode parent;
    private AddressNodeType type;
    private PostalCode code;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="node_id")
    @IndexedEmbedded(includePaths = {"title"})
    public List<AddressNodeTitle> getTitles() {
        return titles;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public AddressNode getParent() {
        return parent;
    }

    public void setParent(AddressNode parent) {
        this.parent = parent;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    public AddressNodeType getType() {
        return type;
    }

    public void setType(AddressNodeType type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "postal_code_id")
    @IndexedEmbedded(includePaths = {"code"})
    public PostalCode getCode() {
        return code;
    }

    public void setCode(PostalCode code) {
        this.code = code;
    }
}

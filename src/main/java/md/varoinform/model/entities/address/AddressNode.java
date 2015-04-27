package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.TitleContainer;
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
@Table(name = DB.SCHEMA + DB.ADDRESS + "node")
public class AddressNode extends TitleContainer<AddressNodeTitle> {
    private AddressNode parent;
    private AddressNodeType type;

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
}

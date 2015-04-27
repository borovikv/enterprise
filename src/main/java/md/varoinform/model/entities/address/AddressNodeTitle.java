package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.ADDRESS + "nodetitle")
public class AddressNodeTitle extends Title<AddressNode>{
    @Override
    @ManyToOne
    @JoinColumn(name = "container_id")
    public AddressNode getContainer() {
        return container;
    }
}

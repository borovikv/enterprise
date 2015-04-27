package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Created by vladimir on 27.04.15.
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "LastNameI18N")
public class LastNameI18N extends Title<LastName> {
    @Override
    @ManyToOne
    @JoinColumn(name = "last_name_id")
    public LastName getContainer() {
        return container;
    }
}
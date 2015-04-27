package md.varoinform.model.entities.base;

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
@Table(name = DB.SCHEMA + DB.BASE + "FirstNameI18N")
public class FirstNameI18N extends Title<FirstName> {
    @Override
    @ManyToOne
    @JoinColumn(name = "first_name_id")
    public FirstName getContainer() {
        return container;
    }
}
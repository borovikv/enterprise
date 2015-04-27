package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by vladimir on 27.04.15.
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "LastName")
public class LastName extends TitleContainer<LastNameI18N> {
    @Override
    @JoinColumn(name = "last_name_id")
    public List<LastNameI18N> getTitles() {
        return titles;
    }
}
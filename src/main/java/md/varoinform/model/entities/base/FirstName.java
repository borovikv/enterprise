package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "FirstName")
public class FirstName extends TitleContainer<FirstNameI18N> {
    @Override
    @JoinColumn(name = "first_name_id")
    public List<FirstNameI18N> getTitles() {
        return titles;
    }
}
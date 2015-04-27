package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "firstname")
public class FirstName extends TitleContainer<FirstNameI18N> {
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "first_name_id")
    @IndexedEmbedded(includePaths = {"title"})
    public List<FirstNameI18N> getTitles() {
        return titles;
    }
}
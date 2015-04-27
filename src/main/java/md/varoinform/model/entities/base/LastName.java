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
@Table(name = DB.SCHEMA + DB.BASE + "LastName")
public class LastName extends TitleContainer<LastNameI18N> {
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "last_name_id")
    @IndexedEmbedded(includePaths = {"title"})
    public List<LastNameI18N> getTitles() {
        return titles;
    }
}
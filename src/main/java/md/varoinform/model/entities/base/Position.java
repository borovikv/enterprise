package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 4:27 PM
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "position")
public class Position extends TitleContainer<PositionTitle> {

    @OneToMany
    @JoinColumn(name = "position_id", updatable = false)
    @IndexedEmbedded(includePaths = {"title"})
    public List<PositionTitle> getTitles() {
        return titles;
    }
}

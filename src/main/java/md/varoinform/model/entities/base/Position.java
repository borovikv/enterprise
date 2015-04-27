package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
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

    @JoinColumn(name = "position_id")
    public List<PositionTitle> getTitles() {
        return titles;
    }
}

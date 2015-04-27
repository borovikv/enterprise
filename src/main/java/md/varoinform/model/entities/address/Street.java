package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.TitleContainer;
import md.varoinform.model.utils.DB;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 12:34 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_street")
public class Street extends TitleContainer<StreetTitle> {
    public Street() {}
    public Street(List<StreetTitle> titles) {
        setTitles(titles);
    }
}

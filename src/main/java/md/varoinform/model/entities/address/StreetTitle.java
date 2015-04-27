package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.entities.base.Language;
import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 12:34 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_streettitle")
public class StreetTitle extends Title<Street> {
    public StreetTitle() {
    }

    public StreetTitle(Language language, String title, Street street) {
        super(language, title, street);
    }
}


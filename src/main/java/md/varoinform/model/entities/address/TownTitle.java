package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.entities.base.Language;
import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 1:47 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_towntitle")
public class TownTitle extends Title<Town> {
    public TownTitle() {
    }

    public TownTitle(Language language, String title, Town town) {
        super(language, title, town);
    }
}


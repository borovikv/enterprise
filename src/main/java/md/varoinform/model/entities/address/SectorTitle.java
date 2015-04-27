package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.entities.base.Language;
import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 1:43 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_sectortitle")
public class SectorTitle extends Title<Sector> {
    public SectorTitle() {
    }

    public SectorTitle(Language language, String title, Sector sector) {
        super(language, title, sector);
    }
}


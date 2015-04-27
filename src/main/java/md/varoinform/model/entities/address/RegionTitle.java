package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.entities.base.Language;
import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 1:49 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_regiontitle")
public class RegionTitle extends Title<Region> {
    public RegionTitle() {
    }

    public RegionTitle(Language language, String title, Region region) {
        super(language, title, region);
    }
}


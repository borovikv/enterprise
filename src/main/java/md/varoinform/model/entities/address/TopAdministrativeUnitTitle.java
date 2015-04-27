package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.entities.base.Language;
import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 1:51 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_topadministrativeunittitle")
public class TopAdministrativeUnitTitle extends Title<TopAdministrativeUnit> {
    public TopAdministrativeUnitTitle() {
    }

    public TopAdministrativeUnitTitle(Language language, String title, TopAdministrativeUnit topadministrativeunit) {
        super(language, title, topadministrativeunit);
    }
}


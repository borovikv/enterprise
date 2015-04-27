package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.base.Language;
import md.varoinform.model.entities.base.Title;
import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 11:26 AM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_enterprisetitle")
public class EnterpriseTitle extends Title<Enterprise> {
    public EnterpriseTitle() {
    }

    public EnterpriseTitle(Language language, String title, Enterprise enterprise) {
        super(language, title, enterprise);
    }
}

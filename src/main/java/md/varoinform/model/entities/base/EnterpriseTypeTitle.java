package md.varoinform.model.entities.base;


import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 10:54 AM
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "enterprisetypetitle")
public class EnterpriseTypeTitle extends Title<EnterpriseType> {
    private EnterpriseType type;
    public EnterpriseTypeTitle() {
    }

    public EnterpriseTypeTitle(Language language, String title, EnterpriseType enterpriseType) {
        super(language, title, enterpriseType);
    }


    @ManyToOne
    @JoinColumn(name = "enterprise_type_id")
    public EnterpriseType getType() {
        return type;
    }

    public void setType(EnterpriseType type) {
        this.type = type;
    }
}

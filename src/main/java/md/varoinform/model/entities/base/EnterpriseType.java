package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 10:54 AM
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "enterpriseType")
public class EnterpriseType extends TitleContainer<EnterpriseTypeTitle> {

    @Override
    @JoinColumn(name = "enterprise_type_id")
    public List<EnterpriseTypeTitle> getTitles() {
        return titles;
    }
}
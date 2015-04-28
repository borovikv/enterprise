package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 10:54 AM
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "enterprisetype")
public class EnterpriseType extends TitleContainer<EnterpriseTypeTitle> {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_type_id", updatable = false)
    @IndexedEmbedded(includePaths = {"title"})
    public List<EnterpriseTypeTitle> getTitles() {
        return titles;
    }
}

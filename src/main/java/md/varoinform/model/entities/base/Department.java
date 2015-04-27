package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "department")
public class Department extends TitleContainer<DepartmentTitle> {
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    @IndexedEmbedded(includePaths = {"title"})
    public List<DepartmentTitle> getTitles() {
        return titles;
    }
}

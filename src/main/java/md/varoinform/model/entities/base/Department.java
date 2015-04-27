package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by vladimir on 27.04.15.
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "department")
public class Department extends TitleContainer<DepartmentTitle> {
    @Override
    @JoinColumn(name = "department_id")
    public List<DepartmentTitle> getTitles() {
        return titles;
    }
}

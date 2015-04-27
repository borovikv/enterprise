package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "departmentTitle")
public class DepartmentTitle extends Title<Department> {
    @Override
    @ManyToOne
    @JoinColumn(name = "department_id")
    public Department getContainer() {
        return container;
    }
}

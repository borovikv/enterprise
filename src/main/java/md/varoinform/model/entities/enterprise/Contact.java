package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.base.Department;
import md.varoinform.model.entities.base.Phone;
import md.varoinform.model.entities.base.Position;
import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/8/13
 * Time: 10:54 AM
 */
@SuppressWarnings("UnusedDeclaration")
@Entity
@Table(name = DB.SCHEMA + DB.ENTERPRISE + "contact")
public class Contact {
    private Integer id;
    private Enterprise enterprise;
    private Department department;
    private Position position;
    private Phone phone;
//    private List<Phone> allPhones = new ArrayList<>();
//    private List<Phone> fax = new ArrayList<>();
//    private List<Phone> gsm = new ArrayList<>();


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    @ContainedIn
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "position_id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name = "phone_id")
    @IndexedEmbedded(includePaths = {"phone"})
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

//    @ManyToOne
//    @JoinColumn(name = "phone_id")
//    @IndexedEmbedded(includePaths = {"phone"})
//    @Where(clause = "type=" + Phone.FAX + "or type=" + Phone.TELFAX)
//    public List<Phone> getFax() {
//        return fax;
//    }
//
//    public void setFax(List<Phone> fax) {
//        this.fax = fax;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "phone_id")
//    @IndexedEmbedded(includePaths = {"phone"})
//    @Where(clause = "type="+ Phone.GSM)
//    public List<Phone> getGsm() {
//        return gsm;
//    }
//
//    public void setGsm(List<Phone> gsm) {
//        this.gsm = gsm;
//    }

//    @ManyToOne
//    @JoinColumn(name = "phone_id")
//    @Where(clause = "type="+ Phone.GSM +  "or type=" + Phone.TEL + " or type=" + Phone.TELFAX + "or type=" + Phone.FAX)
//    public List<Phone> getAllPhones() {
//        return allPhones;
//    }
//
//    public void setAllPhones(List<Phone> allPhones) {
//        this.allPhones = allPhones;
//    }

}

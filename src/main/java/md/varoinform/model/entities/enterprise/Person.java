package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.base.FirstName;
import md.varoinform.model.entities.base.LastName;
import md.varoinform.model.entities.base.Phone;
import md.varoinform.model.entities.base.Position;
import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.*;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 4:34 PM
 */
@SuppressWarnings("UnusedDeclaration")
@Entity
@Table(name = DB.SCHEMA + DB.ENTERPRISE + "person")
public class Person {
    private Integer id;
    private Enterprise enterprise;
    private FirstName firstName;
    private LastName lastName;
    private Position position;
    private Phone phone;

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
    @JoinColumn(name = "first_name_id")
    @IndexedEmbedded
    public FirstName getFirstName() {
        return firstName;
    }

    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    @ManyToOne
    @JoinColumn(name = "last_name_id")
    @IndexedEmbedded
    public LastName getLastName() {
        return lastName;
    }

    public void setLastName(LastName lastName) {
        this.lastName = lastName;
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
    @IndexedEmbedded
    public Phone getPhones() {
        return phone;
    }

    public void setPhones(Phone phone) {
        this.phone = phone;
    }
}

package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 2:00 PM
 */

@Entity
@Table(name = DB.SCHEMA + DB.BASE + "phone")
public class Phone {
    public static final String FAX = "FAX";
    public static final String TEL = "TEL";
    public static final String TELFAX = "T/F";
    public static final String GSM = "MOB";
    private Integer id;
    private String type;
    private String phone;

    public Phone() {
    }

    public Phone(String phone) {
        setPhone(phone);
    }

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

    @Column(name = "phone")
    @Field
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return phone;
    }

    @Column(name = "phone_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

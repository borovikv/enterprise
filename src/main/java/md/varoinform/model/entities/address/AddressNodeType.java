package md.varoinform.model.entities.address;

import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.ADDRESS + "type")
public class AddressNodeType {
    private Long id;
    private String title;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

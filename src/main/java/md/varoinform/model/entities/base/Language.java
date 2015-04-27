package md.varoinform.model.entities.base;

/**
 * User: vladimir borovic
 * Date: 10/2/13
 * Time: 3:41 PM
 */

import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = DB.SCHEMA + DB.BASE + "language")
public class Language {
    private Integer id;
    private String title;

    public Language() {
    }

    public Language(String title) {
        setTitle(title);
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

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof Language)) && ((Language)obj).id.equals(id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        Integer id = this.id;
        int c = id^(id >>> 32);
        result = 31 * result + c;
        return  result;
    }
}

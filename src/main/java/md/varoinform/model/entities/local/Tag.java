package md.varoinform.model.entities.local;

import md.varoinform.model.entities.enterprise.Enterprise;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 11/29/13
 * Time: 9:45 AM
 */

@Entity
@Table(name = "DB_tag")
public class Tag implements Comparable<Tag>{
    private Long id;
    private String title;
    private Set<Enterprise> enterprises;

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

    @ManyToMany
    @JoinTable(name = "DB_tag_enterprise", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "enterprise_id"))
    public Set<Enterprise> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(Set<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Tag o) {
        if (o == null) return 1;
        return title.compareTo(o.title);
    }
}

package md.varoinform.model.entities.product;

import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 6/6/14
 * Time: 1:44 PM
 */
@SuppressWarnings("UnusedDeclaration")
@Entity
@Table(name = DB.SCHEMA + DB.PRODUCT + "Arcs")
public class Arc {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_node_id")
    private Node fromNode;

    @ManyToOne
    @JoinColumn(name = "to_node_id")
    private Node toNode;

}

package md.varoinform.model.entities.product;

import md.varoinform.model.entities.base.TitleContainer;
import md.varoinform.model.utils.DB;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 4/4/14
 * Time: 9:51 AM
 */
@SuppressWarnings("UnusedDeclaration")
@Entity
@Table(name = DB.SCHEMA + "DB_good")
public class Good extends TitleContainer<GoodTitle> {
    private Set<Node> nodes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = DB.SCHEMA + "DB_good_node", joinColumns = @JoinColumn(name = "good_id"), inverseJoinColumns = @JoinColumn(name = "node_id"))
    @IndexedEmbedded(includePaths = { "titles.title" })
    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

}

package md.varoinform.model.entities.product;

import md.varoinform.model.entities.base.TitleContainer;
import md.varoinform.model.entities.enterprise.Enterprise;
import md.varoinform.model.utils.DB;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 6/6/14
 * Time: 1:38 PM
 */
@SuppressWarnings("UnusedDeclaration")
@Entity
@Table(name = DB.SCHEMA + "DB_Node")
public class Node extends TitleContainer<NodeTitle> implements Serializable{
    private List<Node> children = new ArrayList<>();
    private Set<Enterprise> enterprises = new TreeSet<>();

    @ManyToMany
    @JoinTable(name = DB.SCHEMA + "DB_Arc", joinColumns = @JoinColumn(name = "tail_id"), inverseJoinColumns = @JoinColumn(name = "head_id"))
    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    @ManyToMany
    @JoinTable(name = DB.SCHEMA + "DB_Node_Enterprise", joinColumns = @JoinColumn(name = "node_id"), inverseJoinColumns = @JoinColumn(name = "enterprise_id"))
    public Set<Enterprise> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(Set<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return id.equals(node.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

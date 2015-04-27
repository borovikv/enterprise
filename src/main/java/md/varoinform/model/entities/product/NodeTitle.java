package md.varoinform.model.entities.product;

import md.varoinform.model.entities.base.Title;
import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 4/4/14
 * Time: 9:37 AM
 */

@Entity
@Table(name = DB.SCHEMA + "DB_NodeTitle")
public class NodeTitle extends Title<Node> {
    public NodeTitle() {
    }
}

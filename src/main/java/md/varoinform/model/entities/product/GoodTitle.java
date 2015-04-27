package md.varoinform.model.entities.product;


import md.varoinform.model.entities.base.Title;
import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 4/4/14
 * Time: 1:58 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_GoodTitle")
public class GoodTitle extends Title<Good> {
}

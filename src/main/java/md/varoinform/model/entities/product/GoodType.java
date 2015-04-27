package md.varoinform.model.entities.product;

import md.varoinform.model.entities.base.TitleContainer;
import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 12/5/14
 * Time: 3:07 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_GoodType")
public class GoodType extends TitleContainer<GoodTypeTitle> {
}

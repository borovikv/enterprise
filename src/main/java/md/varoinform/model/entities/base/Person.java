package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 4:29 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_person")
public class Person extends TitleContainer<PersonTitle> {
}

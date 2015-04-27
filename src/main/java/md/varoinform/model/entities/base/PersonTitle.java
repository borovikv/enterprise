package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 4:28 PM
 */
@Entity
@Table(name = DB.SCHEMA + "DB_persontitle")
public class PersonTitle extends Title<Person> {
    public PersonTitle() {
    }

    public PersonTitle(Language language, String title, Person person) {
        super(language, title, person);
    }
}


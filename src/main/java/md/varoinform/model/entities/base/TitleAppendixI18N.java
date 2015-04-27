package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "TitleAppendixI18N")
public class TitleAppendixI18N extends Title<TitleAppendix> {
    @Override
    @ManyToOne
    @JoinColumn(name = "appendix_id")
    public TitleAppendix getContainer() {
        return container;
    }
}
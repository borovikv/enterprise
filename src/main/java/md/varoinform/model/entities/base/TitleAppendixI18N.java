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
@Table(name = DB.SCHEMA + DB.BASE + "titleappendixi18n")
public class TitleAppendixI18N extends Title<TitleAppendix> {
    private TitleAppendix appendix;

    @ManyToOne
    @JoinColumn(name = "appendix_id")
    public TitleAppendix getAppendix() {
        return appendix;
    }

    public void setAppendix(TitleAppendix appendix) {
        this.appendix = appendix;
    }
}
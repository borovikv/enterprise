package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "TitleAppendix")
public class TitleAppendix extends TitleContainer<TitleAppendixI18N> {
    @Override
    @JoinColumn(name = "appendix_id")
    public List<TitleAppendixI18N> getTitles() {
        return titles;
    }
}
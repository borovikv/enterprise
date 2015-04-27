package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.TitleContainer;
import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = DB.SCHEMA + "DB_sector")
public class Sector extends TitleContainer<SectorTitle> {
    public Sector() {
    }

    public Sector(List<SectorTitle> titles) {
        setTitles(titles);
    }
}

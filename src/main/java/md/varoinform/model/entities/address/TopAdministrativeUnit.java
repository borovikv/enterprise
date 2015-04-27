package md.varoinform.model.entities.address;

import md.varoinform.model.entities.base.TitleContainer;
import md.varoinform.model.utils.DB;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = DB.SCHEMA + "DB_topadministrativeunit")
public class TopAdministrativeUnit extends TitleContainer<TopAdministrativeUnitTitle> {
}

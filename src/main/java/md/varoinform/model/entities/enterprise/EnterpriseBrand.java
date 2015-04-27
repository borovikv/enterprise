package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.base.Brand;
import md.varoinform.model.utils.DB;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Created by vladimir on 27.04.15.
 *
 */
@Entity
@Table(name = DB.SCHEMA + DB.ENTERPRISE + "enterprise_brand")
public class EnterpriseBrand {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
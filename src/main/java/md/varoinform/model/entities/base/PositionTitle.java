package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 4:27 PM
 */
@Entity
@Table(name = DB.SCHEMA + DB.BASE + "positiontitle")
public class PositionTitle extends Title<Position> {
    public PositionTitle() {
    }

    public PositionTitle(Language language, String title, Position position) {
        super(language, title, position);
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "position_id")
    public Position getContainer() {
        return container;
    }
}


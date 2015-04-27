package md.varoinform.model.entities.base;

import md.varoinform.model.utils.DB;
import org.jboss.logging.annotations.Pos;

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
    private Position position;
    public PositionTitle() {
    }

    public PositionTitle(Language language, String title, Position position) {
        super(language, title, position);
    }

    @ManyToOne
    @JoinColumn(name = "position_id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}


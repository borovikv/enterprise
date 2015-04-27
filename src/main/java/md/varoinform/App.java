package md.varoinform;

import md.varoinform.model.utils.ClosableSession;
import md.varoinform.model.utils.Configurator;
import md.varoinform.model.utils.SessionManager;
import org.hibernate.cfg.Configuration;

/**
 * Created by vladimir on 24.04.15.
 *
 */
public class App {
    public static void main(String[] args) {
        Configurator configurator = new Configurator("database/db", "test");
        Configuration cfg = configurator.configureWithoutIndex();
        configurator.setAuto(cfg, "update");
        try(ClosableSession session = new ClosableSession(cfg)){

        }
    }
}

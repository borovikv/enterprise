package md.varoinform;

import md.varoinform.model.utils.Configurator;
import md.varoinform.model.utils.Synchronizer;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by vladimir on 24.04.15.
 *
 */
public class App {

    public static void main(String[] args) {
        Configuration fromCfg = getFromConfiguration();
        Configuration toCfg = getToConfiguration();

        Synchronizer synchronizer = new Synchronizer();
        List<Class> classes = Configurator.getAnnotatedClass();
        for (Class aClass : classes) {
            System.out.println(aClass);
            synchronizer.synchronize(fromCfg, toCfg, aClass);
        }
        System.out.println("Synchronized");
    }

    private static Configuration getFromConfiguration() {
        Configurator configurator = new Configurator("root", "vmdb");
        configurator.mySqlConfiguraion();
        return configurator.getCfg();
    }

    private static Configuration getToConfiguration() {
        Configurator configurator = new Configurator("database/db", "admin", "test");
        configurator.configureWithoutIndex();
        configurator.showSql(true);
        configurator.setAuto("create");
        return configurator.getCfg();
    }

}

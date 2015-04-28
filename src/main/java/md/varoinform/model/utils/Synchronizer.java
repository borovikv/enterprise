package md.varoinform.model.utils;

import org.hibernate.ReplicationMode;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by vladimir on 28.04.15.
 *
 */
public class Synchronizer {
    public static void synchronize(){
        Configuration fromCfg = getFromConfiguration();
        Configuration toCfg = getToConfiguration();

        List<Class> classes = Configurator.getAnnotatedClass();
        for (Class aClass : classes) {
            System.out.println(aClass);
            synchronizeClass(fromCfg, toCfg, aClass);
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

    public static void synchronizeClass(Configuration from, Configuration to, Class aClass){
        try (ClosableSession fromSession = new ClosableSession(from); ClosableSession toSession = new ClosableSession(to)) {
            try {
                Transaction fromTransaction = fromSession.beginTransaction();
                Transaction toTransaction = toSession.beginTransaction();
                List table = fromSession.createCriteria(aClass).list();
                System.out.println(table);
                for (Object row: table){
                    fromSession.evict(row);
                    toSession.replicate(row, ReplicationMode.IGNORE);
                    toSession.flush();
                    fromSession.flush();
                }
                toTransaction.commit();
                fromTransaction.commit();
            } catch (RuntimeException e) {
                e.printStackTrace();
                fromSession.getTransaction().rollback();
                toSession.getTransaction().rollback();
            }
        }
    }
}

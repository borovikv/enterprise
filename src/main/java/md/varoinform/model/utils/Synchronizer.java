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
    public void synchronize(Configuration from, Configuration to, Class aClass){
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

package md.varoinform.model.utils;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 8/11/14
 * Time: 3:12 PM
 */
public class ClosableSession implements AutoCloseable {
    private Session session;

    public ClosableSession(Configuration cfg){
        session = SessionManager.instance.getSession(cfg);
    }

    @Override
    public void close() {
        if (session.isOpen()) {
            session.clear();
            session.close();
        }
    }

    public Transaction beginTransaction() {
        return session.beginTransaction();
    }

    public Criteria createCriteria(Class cls) {
        return session.createCriteria(cls);
    }

    public Transaction getTransaction() {
        return session.getTransaction();
    }

    public Query createQuery(String hql) {
        return session.createQuery(hql);
    }

    public void delete(Object o) {
        session.delete(o);
    }

    public void save(Object o) {
        session.save(o);
    }

    public Session getSession() {
        return session;
    }

    public boolean isOpen() {
        return session.isOpen();
    }
}

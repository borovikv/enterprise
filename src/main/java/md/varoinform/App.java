package md.varoinform;

import md.varoinform.model.entities.enterprise.Enterprise;
import md.varoinform.model.utils.ClosableSession;
import md.varoinform.model.utils.Configurator;
import org.hibernate.Criteria;
import org.hibernate.cfg.Configuration;

/**
 * Created by vladimir on 24.04.15.
 *
 */
public class App {
    public static void main(String[] args) {
        Configurator configurator = new Configurator("database/db", "test");
        Configuration cfg = configurator.configureWithoutIndex();
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/edms");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "vmdb");

        configurator.setAuto(cfg, "validate");
        configurator.showSql(cfg, true);
        try(ClosableSession session = new ClosableSession(cfg)){
            Criteria criteria = session.createCriteria(Enterprise.class);
            System.out.println(criteria.list());
            System.out.println("end");
        }
    }
}

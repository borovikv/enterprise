package md.varoinform.model.utils;


import md.varoinform.model.entities.base.*;
import md.varoinform.model.entities.enterprise.*;
import md.varoinform.model.entities.local.Database;
import md.varoinform.model.entities.local.Tag;
import md.varoinform.model.entities.local.TagEnterprise;
import md.varoinform.model.entities.product.*;
import org.hibernate.cfg.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 3/26/14
 * Time: 3:51 PM
 */
@SuppressWarnings("unused")
public class Configurator {
    private static final Class[] entities = {
            Arc.class, Node.class, NodeTitle.class,
            Good.class, GoodTitle.class,  GoodEnterprise.class, GoodType.class, GoodTypeTitle.class,
            Brand.class,
            EnterpriseType.class, EnterpriseTypeTitle.class,
            Contact.class,
            ContactPerson.class,
            Email.class,
            Enterprise.class, EnterpriseTitle.class,
            Language.class,
            Phone.class,
            Position.class, PositionTitle.class,
            Tag.class, TagEnterprise.class,
            Database.class,
            Url.class
    };
    private final String pathToDb;
    private final String password;


    public Configurator(String pathToDb, String password) {
        if (pathToDb == null || pathToDb.isEmpty()) throw new IllegalArgumentException();
        Path path = Paths.get(pathToDb);
        if (Files.notExists(path.getParent()))
            throw new RuntimeException("file " + path.toAbsolutePath().toString() + " not found");
        this.pathToDb = path.toString();
        this.password = password;
    }

    public Configuration configure() {
        Configuration cfg = getConfiguration();
        setIndex(cfg);
        showSql(cfg, false);
        //setAuto(cfg, "update");
        return cfg;
    }

    public Configuration configureWithoutIndex(){
        Configuration cfg = getConfiguration();
        showSql(cfg, false);
        cfg.setProperty("hibernate.search.autoregister_listeners", "false");
        return cfg;
    }

    public Configuration getConfiguration() {
        Configuration cfg = new Configuration();

        for (Class entity : entities) {
            cfg.addAnnotatedClass(entity);
        }

        cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        cfg.setProperty("hibernate.connection.url", "jdbc:h2:file:" + pathToDb);
        cfg.setProperty("hibernate.connection.username", "admin");
        cfg.setProperty("hibernate.connection.password", password);

        cfg.setProperty("hibernate.connection.pool_size", "1");
        cfg.setProperty("hibernate.current_session_context_class", "thread");

        cfg.setProperty("hibernate.generate_statistics", "false");
        cfg.setProperty("hibernate.use_sql_comments", "false");
        cfg.setProperty("hibernate.connection.autocommit", "false");

        return cfg;
    }

    public void setIndex(Configuration cfg) {
        cfg.setProperty("hibernate.search.default.directory_provider", "filesystem");
        cfg.setProperty("hibernate.search.default.indexBase", pathToDb + "/indexes");
    }

    public void setAuto(Configuration cfg, String value) {
        cfg.setProperty("hibernate.hbm2ddl.auto", value);
    }

    public void showSql(Configuration cfg, boolean b) {
        cfg.setProperty("hibernate.show_sql", Boolean.toString(b));

    }

}

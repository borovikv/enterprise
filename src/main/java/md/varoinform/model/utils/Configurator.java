package md.varoinform.model.utils;


import md.varoinform.model.entities.address.AddressNode;
import md.varoinform.model.entities.address.AddressNodeTitle;
import md.varoinform.model.entities.address.AddressNodeType;
import md.varoinform.model.entities.address.PostalCode;
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
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 3/26/14
 * Time: 3:51 PM
 */
@SuppressWarnings("unused")
public class Configurator {
    private static final Class[] entities = {
            Language.class,

            AddressNodeType.class, AddressNode.class, AddressNodeTitle.class, PostalCode.class,

            Node.class, NodeTitle.class, Arc.class, Product.class, ProductTitle.class, ProductType.class, ProductNode.class,

            Brand.class,
            Department.class, DepartmentTitle.class,
            EnterpriseType.class, EnterpriseTypeTitle.class,
            FirstName.class, FirstNameI18N.class,
            LastName.class, LastNameI18N.class,
            Phone.class,
            Position.class, PositionTitle.class,
            TitleAppendix.class, TitleAppendixI18N.class,

            Enterprise.class,
            Contact.class,
            Email.class,
            EnterpriseProduct.class,
            EnterpriseTitle.class,
            Location.class,
            Person.class,
            WWW.class
    };
    
    private String pathToDb = null;
    private final Configuration cfg;


    public Configurator(String pathToDb, String username, String password) {
        this(username, password);

        if (pathToDb == null || pathToDb.isEmpty()) throw new IllegalArgumentException();
        Path path = Paths.get(pathToDb);
        if (Files.notExists(path.getParent()))
            throw new RuntimeException("file " + path.toAbsolutePath().toString() + " not found");
        this.pathToDb = path.toString();
        

        cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        cfg.setProperty("hibernate.connection.url", "jdbc:h2:file:" + pathToDb);

    }
    
    
    public Configurator(String username, String password) {
        cfg = new Configuration();

        for (Class entity : entities) {
            cfg.addAnnotatedClass(entity);
        }
        cfg.setProperty("hibernate.connection.username", username);
        cfg.setProperty("hibernate.connection.password", password);

        cfg.setProperty("hibernate.connection.pool_size", "1");
        cfg.setProperty("hibernate.current_session_context_class", "thread");

        cfg.setProperty("hibernate.generate_statistics", "false");
        cfg.setProperty("hibernate.use_sql_comments", "false");
        cfg.setProperty("hibernate.connection.autocommit", "false");
        
    }
    
    public void turnOnLocal(){
        for (Class<?> entity : Arrays.asList(Tag.class, TagEnterprise.class, Database.class)) {
            cfg.addAnnotatedClass(entity);
        }
    }

    public static List<Class> getAnnotatedClass(){
        return Arrays.asList(entities);
    }
    
    public void setIndex() {
        cfg.setProperty("hibernate.search.default.directory_provider", "filesystem");
        cfg.setProperty("hibernate.search.default.indexBase", pathToDb + "/indexes");
    }

    public void setAuto(String value) {
        cfg.setProperty("hibernate.hbm2ddl.auto", value);
    }

    public void showSql(boolean b) {
        cfg.setProperty("hibernate.show_sql", Boolean.toString(b));

    }

    public Configuration defaultConfiguration() {
        setIndex();
        showSql(false);
        setAuto("validate");
        return cfg;
    }
    
    public Configuration configureWithoutIndex(){
        showSql(false);
        cfg.setProperty("hibernate.search.autoregister_listeners", "false");
        return cfg;
    }
    
    public Configuration mySqlConfiguraion(){
        configureWithoutIndex();
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                                                                                                                                                                                                                                                                                                                                                                                                                cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/edms");
        setAuto("validate");
        return cfg;
    }

    public Configuration getCfg() {
        return cfg;
    }
}

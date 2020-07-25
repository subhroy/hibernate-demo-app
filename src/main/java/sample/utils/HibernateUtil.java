package sample.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import sample.entity.Category;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sFactory;

    public static SessionFactory getSessionFactory(){
        if(sFactory==null){
            Properties props = new Properties();
            props.setProperty("hibernate.connection.driver","com.mysql.jdbc.Driver");
            props.setProperty("hibernate.connection.url","jdbc:mysql://127.0.0.1:3306/coding_schema");
            props.setProperty("hibernate.connection.username","root");
            props.setProperty("hibernate.connection.password","root");

            props.setProperty("hibernate.connection.dialect","org.hibernate.dialect.MySQL5Dialect");
            props.setProperty("hibernate.hbm2ddl.auto","update");

            props.setProperty("hibernate.show_sql","true");
            props.setProperty("hibernate.format_sql","true");

            Configuration config = new Configuration();
            config.addAnnotatedClass(Category.class);

            ServiceRegistry sRegistry = new StandardServiceRegistryBuilder().applySettings(props).build();

            sFactory = config.buildSessionFactory(sRegistry);

        }
        return sFactory;
    }
}

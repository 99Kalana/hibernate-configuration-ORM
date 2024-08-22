package org.example.config;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguaration {

    private static FactoryConfiguaration factoryConfiguaration;

    private SessionFactory sessionFactory;

    private FactoryConfiguaration(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        sessionFactory= configuration.buildSessionFactory();
    }

    public static FactoryConfiguaration getInstance(){
        return (factoryConfiguaration==null)? factoryConfiguaration=new FactoryConfiguaration():factoryConfiguaration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}

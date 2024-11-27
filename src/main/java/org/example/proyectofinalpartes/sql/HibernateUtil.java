package org.example.proyectofinalpartes.sql;


import org.example.proyectofinalpartes.Clases.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    static SessionFactory factory = null;
    static {
        Configuration cfg = new Configuration();
        cfg.configure("configuration/hibernate.cfg.xml");
        // Se registran las clases que hay que MAPEAR con cada tabla de la base de datos
        cfg.addAnnotatedClass(Alumnos.class);
        cfg.addAnnotatedClass(Grupos.class);
        cfg.addAnnotatedClass(Partes_incidencia.class);
        cfg.addAnnotatedClass(Profesores.class);
        cfg.addAnnotatedClass(Puntuacion_partes.class);
        System.out.println("conectado hibernate");
        factory = cfg.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static Session getSession() {
        return factory.openSession();
    }
}
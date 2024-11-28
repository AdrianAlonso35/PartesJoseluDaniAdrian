package org.example.proyectofinalpartes.DAO;

import org.example.proyectofinalpartes.Clases.Profesores;
import org.example.proyectofinalpartes.Utils.Alertas;
import org.example.proyectofinalpartes.sql.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfesoresDAO {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    public ArrayList<Profesores> obtenerProfesores(){
        ArrayList<Profesores> listaProfesores= new ArrayList<>();
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            List<Profesores> profesores = session.createQuery("FROM Profesores", Profesores.class).getResultList();
            listaProfesores.addAll(profesores);
            transaction.commit();
        } catch (Exception e) {
            Alertas.alertaError(e.getMessage());
            System.out.println(e.getMessage());
        }
        return listaProfesores;
    }

    public boolean crearProfesor(Profesores profesores) {
        Transaction transaction = null;
       try (Session session = factory.openSession()) {
           transaction = session.beginTransaction();
           session.save(profesores);
           transaction.commit();
           return true;
       }catch (Exception e){
           Alertas.alertaError(e.getMessage());
       }
       return false;
    }

    public boolean comprobarProfesor(int profesor) {
        ArrayList<Profesores> listaProfesores = obtenerProfesores();
        for (Profesores profesores : listaProfesores) {
            if (profesores.getNumero_asignado() == profesor) {
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean comprobarProfesorContrasena(int profesor,String contrasena) {
        ArrayList<Profesores> listaProfesores = obtenerProfesores();
        for (Profesores profesores : listaProfesores) {
            if (profesores.getNumero_asignado() == profesor && Objects.equals(profesores.getContrasena(), contrasena)){
                return true;
            }
        }
        return false;
    }

    public boolean comprobarProfesorContrasenaNull(int profesor) {
        ArrayList<Profesores> listaProfesores = obtenerProfesores();
        for (Profesores profesores : listaProfesores) {
            if (profesores.getNumero_asignado() == profesor && Objects.equals(profesores.getContrasena(), null)){
                return true;
            }
        }
        return false;
    }

    public int comprobarProfesorJefeDeEstudios(int profesor) {
        ArrayList<Profesores> listaProfesores = obtenerProfesores();
        for (Profesores profesores :listaProfesores){
            if (profesores.getNumero_asignado()==profesor){
                if (Objects.equals(profesores.getTipo(), "profesor")){
                    return 1;
                } else if (Objects.equals(profesores.getTipo(), "jefe_de_estudios")) {
                    return 2;
                }
            }
        }
        return 0;
    }
    public String obtenerNombrePorNumero(int profesor) {
        ArrayList<Profesores> listaProfesores = obtenerProfesores();
        for (Profesores profesores : listaProfesores) {
            if (profesores.getNumero_asignado() == profesor) {
                return profesores.getNombre();
            }
        }
        return null;
    }
    public String obtenerTipo(int profesor) {
        ArrayList<Profesores> listaProfesores = obtenerProfesores();
        for (Profesores profesores : listaProfesores){
            if (profesores.getNumero_asignado()==profesor){
                return profesores.getTipo();
            }
        }
        return null;
    }

}

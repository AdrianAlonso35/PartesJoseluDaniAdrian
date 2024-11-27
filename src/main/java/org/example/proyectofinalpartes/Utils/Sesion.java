package org.example.proyectofinalpartes.Utils;

import org.example.proyectofinalpartes.Clases.Profesores;

public class Sesion {
    private static Profesores profesores;

    public static Profesores getProfesores() {
        return profesores;
    }

    public static void setProfesores(Profesores profesor) {
        profesores = profesor;
    }
}

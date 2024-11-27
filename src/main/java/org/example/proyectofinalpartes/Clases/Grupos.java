package org.example.proyectofinalpartes.Clases;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grupos")
public class Grupos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private int id_group;

    @Column(name = "nombre_grupo")
    private String nombre_grupo;


    //RELACCION GRUPOS A ALUMNOS || un grupo para muchos alumnos
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL /*, orphanRemoval = true*/)
    private Set<Alumnos> alumno = new HashSet<Alumnos>();


    //RELACION GRUPOS A PARTES_INCIDENCIA || muchos grupos para un solo parte de incidencia
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL /*, orphanRemoval = true*/)
    private Set<Partes_incidencia> partes_incidencias = new HashSet<Partes_incidencia>();

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public Set<Alumnos> getAlumno() {
        return alumno;
    }

    public void setAlumno(Set<Alumnos> alumno) {
        this.alumno = alumno;
    }

    public Set<Partes_incidencia> getPartes_incidencias() {
        return partes_incidencias;
    }

    public void setPartes_incidencias(Set<Partes_incidencia> partes_incidencias) {
        this.partes_incidencias = partes_incidencias;
    }

    public Grupos() {
    }

    public Grupos(int id_group, String nombre_grupo, Set<Alumnos> alumno, Set<Partes_incidencia> partes_incidencias) {
        this.id_group = id_group;
        this.nombre_grupo = nombre_grupo;
        this.alumno = alumno;
        this.partes_incidencias = partes_incidencias;
    }
}

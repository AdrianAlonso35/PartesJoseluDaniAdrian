package org.example.proyectofinalpartes.Clases;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partes_incidencia")
public class Partes_incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parte")
    private int id_parte;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "sancion")
    private String sancion;


    //RELACION ENTRE PARTES_INCIDENCIA Y ALUMNOS || muchos partes de incidencia a un alumno
    @ManyToOne
    @JoinColumn(name = "id_alum",nullable = false)
    private Alumnos alumno;

    //RELACION ENTRE PARTES_INCIDENCIA A GRUPOS || muchos partes de incidencia a un grupo
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo", nullable = false)
    private Grupos grupo;

    //RELACION ENTRE PARTES_INCIDENCIA A PROFESOR || muchos partes de incidencia a un profesor
    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesores profesor;

    //RELACION ENTRE PARTES_INCIDENCIA Y PUNTACION_PARTES || muchos partes de incidencia a un puntacion_partes
    @ManyToOne
    @JoinColumn(name = "id_punt_partes", nullable = true)
    private Puntuacion_partes puntacion_partes;

    public Partes_incidencia() {
    }

    public Partes_incidencia(String descripcion, LocalDate fecha, String hora, String sancion, Alumnos alumno, Grupos grupo, Profesores profesor, Puntuacion_partes puntacion_partes) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.sancion = sancion;
        this.alumno = alumno;
        this.grupo = grupo;
        this.profesor = profesor;
        this.puntacion_partes = puntacion_partes;
    }

    public int getId_parte() {
        return id_parte;
    }

    public void setId_parte(int id_parte) {
        this.id_parte = id_parte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSancion() {
        return sancion;
    }

    public void setSancion(String sancion) {
        this.sancion = sancion;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public Puntuacion_partes getPuntacion_partes() {
        return puntacion_partes;
    }

    public void setPuntacion_partes(Puntuacion_partes puntacion_partes) {
        this.puntacion_partes = puntacion_partes;
    }
}

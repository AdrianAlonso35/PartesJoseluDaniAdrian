package org.example.proyectofinalpartes.Clases;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partes_incidencia")
public class Partes_incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alum")
    private int id_alum;

    @Column(name = "id_grupo")
    private int id_grupo;

    @Column(name = "id_parte")
    private int id_parte;

    @Column(name = "id_profesor")
    private int id_profesor;

    @Column(name = "id_punt_partes")
    private int id_punt_partes;

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
    @JoinColumn(name = "id_alum", insertable = false, updatable = false)
    Alumnos alumno;

    //RELACION ENTRE PARTES_INCIDENCIA Y PUNTACION_PARTES || muchos partes de incidencia a un puntacion_partes
    @ManyToOne
    @JoinColumn(name = "id_punt_partes", insertable = false, updatable = false)
    Puntuacion_partes puntacion_partes;

    //RELACION ENTRE PARTES_INCIDENCIA A PROFESOR || muchos partes de incidencia a un profesor
    @ManyToOne
    @JoinColumn(name = "id_profesor", insertable = false, updatable = false)
    private Profesores profesor;

    //RELACION ENTRE PARTES_INCIDENCIA A GRUPOS || muchos partes de incidencia a un grupo
    @ManyToOne
    @JoinColumn(name = "id_grupo", insertable = false, updatable = false)
    private Grupos grupo;

    public int getId_alum() {
        return id_alum;
    }

    public void setId_alum(int id_alum) {
        this.id_alum = id_alum;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_parte() {
        return id_parte;
    }

    public void setId_parte(int id_parte) {
        this.id_parte = id_parte;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getId_punt_partes() {
        return id_punt_partes;
    }

    public void setId_punt_partes(int id_punt_partes) {
        this.id_punt_partes = id_punt_partes;
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

    public Puntuacion_partes getPuntacion_partes() {
        return puntacion_partes;
    }

    public void setPuntacion_partes(Puntuacion_partes puntacion_partes) {
        this.puntacion_partes = puntacion_partes;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public Partes_incidencia() {
    }

    public Partes_incidencia(int id_alum, int id_grupo, int id_parte, int id_profesor, int id_punt_partes, String descripcion, LocalDate fecha, String hora, String sancion, Alumnos alumno, Puntuacion_partes puntacion_partes, Profesores profesor, Grupos grupo) {
        this.id_alum = id_alum;
        this.id_grupo = id_grupo;
        this.id_parte = id_parte;
        this.id_profesor = id_profesor;
        this.id_punt_partes = id_punt_partes;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.sancion = sancion;
        this.alumno = alumno;
        this.puntacion_partes = puntacion_partes;
        this.profesor = profesor;
        this.grupo = grupo;
    }
}

package org.example.proyectofinalpartes.Clases;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "grupos")
public class Grupos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private int id_grupo;

    @Column(name = "nombre_grupo")
    private String nombre_grupo;

    // Relación un grupo para muchos alumnos
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Alumnos> alumnos = new HashSet<>();

    // Relación un grupo para muchos partes_incidencia
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Partes_incidencia> partes_incidencias = new HashSet<>();

    public Grupos() {
    }

    public Grupos(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public Grupos(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public int getId_group() {
        return id_grupo;
    }

    public void setId_group(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public Set<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Partes_incidencia> getPartes_incidencias() {
        return partes_incidencias;
    }

    public void setPartes_incidencias(Set<Partes_incidencia> partes_incidencias) {
        this.partes_incidencias = partes_incidencias;
    }

    @Override
    public String toString() {
        return "Grupos{" +
                "id_group=" + id_grupo +
                ", nombre_grupo='" + nombre_grupo + '\'' +
                '}';
    }
}
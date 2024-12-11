package org.example.proyectofinalpartes.Clases;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alumnos")
public class Alumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alum")
    private int id_alum;

    @Column(name = "puntos_acumulados")
    private int puntos_acumulados;

    @Column(name = "nombre_alum", nullable = false)
    private String nombre_alum;

    @Column(name = "numero_expediente", unique = true, nullable = false)
    private String numero_expediente;

    // Relación muchos alumnos a un grupo
    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    private Grupos grupo;

    // Relación un alumno a muchos partes_incidencia
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Partes_incidencia> partes_incidencia = new HashSet<>();


    public Alumnos() {
    }

    public Alumnos(int puntos_acumulados, String nombre_alum, String numero_expediente, Grupos grupo) {
        this.puntos_acumulados = puntos_acumulados;
        this.nombre_alum = nombre_alum;
        this.numero_expediente = numero_expediente;
        this.grupo = grupo;
    }

    public Alumnos(int id_alum) {
        this.id_alum = id_alum;
    }

    // Getters y Setters
    public int getId_alum() {
        return id_alum;
    }

    public void setId_alum(int id_alum) {
        this.id_alum = id_alum;
    }

    public int getPuntos_acumulados() {
        return puntos_acumulados;
    }

    public void setPuntos_acumulados(int puntos_acumulados) {
        this.puntos_acumulados = puntos_acumulados;
    }

    public String getNombre_alum() {
        return nombre_alum;
    }

    public void setNombre_alum(String nombre_alum) {
        this.nombre_alum = nombre_alum;
    }

    public String getNumero_expediente() {
        return numero_expediente;
    }

    public void setNumero_expediente(String numero_expediente) {
        this.numero_expediente = numero_expediente;
    }

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public Set<Partes_incidencia> getPartes_incidencia() {
        return partes_incidencia;
    }

    public void setPartes_incidencia(Set<Partes_incidencia> partes_incidencia) {
        this.partes_incidencia = partes_incidencia;
    }
}
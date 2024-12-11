package org.example.proyectofinalpartes.Clases;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private int id_profesor;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numero_asignado")
    private int numero_asignado;

    @Column(name = "tipo")
    private String tipo;

    //RELACION PROFESORES Y PARTES_INCIDENCIA || un profesor a muchos partes de incidencia
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL /*, orphanRemoval = true*/)
    private Set<Partes_incidencia> partes_incidencias = new HashSet<Partes_incidencia>();

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_asignado() {
        return numero_asignado;
    }

    public void setNumero_asignado(int numero_asignado) {
        this.numero_asignado = numero_asignado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Partes_incidencia> getPartes_incidencias() {
        return partes_incidencias;
    }

    public void setPartes_incidencias(Set<Partes_incidencia> partes_incidencias) {
        this.partes_incidencias = partes_incidencias;
    }

    public Profesores() {
    }

    public Profesores(int id_profesor, String contrasena, String nombre, int numero_asignado, String tipo, Set<Partes_incidencia> partes_incidencias) {
        this.id_profesor = id_profesor;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
        this.tipo = tipo;
        this.partes_incidencias = partes_incidencias;
    }

    public Profesores(String contrasena, String nombre, int numero_asignado) {
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
    }

    public Profesores(String contrasena, String nombre, int numero_asignado, String tipo) {
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
        this.tipo = tipo;
    }

    public Profesores(String nombre, int numero_asignado, String tipo) {
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
        this.tipo = tipo;
    }

    public Profesores(int id_profesor, String contrasena, String nombre, int numero_asignado, String tipo) {
        this.id_profesor = id_profesor;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
        this.tipo = tipo;
    }

    public Profesores(int id_profesor,String nombre, int numero_asignado, String tipo ) {
        this.id_profesor = id_profesor;
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
        this.tipo = tipo;
    }

    public Profesores(int id_profesor, String nombre, String tipo) {
        this.id_profesor = id_profesor;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Profesores(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    /*public Profesores() {
    }

    public Profesores(int id_profesor, String contrasena, String nombre, int numero_asignado, String tipo, Set<Partes_incidencia> partes_incidencias) {
        this.id_profesor = id_profesor;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
        this.tipo = tipo;
        this.partes_incidencias = partes_incidencias;
    }

    public Profesores(String contrasena, String nombre, int numero_asignado) {
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
    }

    public Profesores(String contrasena, String nombre, int numero_asignado, String tipo) {
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
        this.tipo = tipo;
    }

    public Profesores(String nombre, int numero_asignado, String tipo) {
        this.nombre = nombre;
        this.numero_asignado = numero_asignado;
        this.tipo = tipo;
    }

    public Profesores(int id_profesor) {
        this.id_profesor = id_profesor;
    }*/
}

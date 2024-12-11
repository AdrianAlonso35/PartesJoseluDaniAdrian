package org.example.proyectofinalpartes.Clases;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "puntuacion_partes")
public class Puntuacion_partes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_punt_partes")
    private int id_punt_partes;

    @Column(name = "puntos")
    private int puntos;

    @Column(name = "tipo_parte")
    private String tipo_parte;

    //RELACION ENTRE PUNTUACION PARTES A PARTES DE INCIDENCIA || un puntacion_partes a muchos partes_incidencia
    @OneToMany(mappedBy = "puntacion_partes", cascade = CascadeType.ALL /*, orphanRemoval = true*/)
    private Set<Partes_incidencia> partes_incidencia = new HashSet<Partes_incidencia>();

    public void setId_punt_partes(int id_punt_partes) {
        this.id_punt_partes = id_punt_partes;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setTipo_parte(String tipo_parte) {
        this.tipo_parte = tipo_parte;
    }

    public void setPartes_incidencia(Set<Partes_incidencia> partes_incidencia) {
        this.partes_incidencia = partes_incidencia;
    }

    public Puntuacion_partes(int id_punt_partes) {
        this.id_punt_partes = id_punt_partes;
    }

    public Puntuacion_partes() {
    }

    public Puntuacion_partes(int id_punt_partes, int puntos, String tipo_parte, Set<Partes_incidencia> partes_incidencia) {
        this.id_punt_partes = id_punt_partes;
        this.puntos = puntos;
        this.tipo_parte = tipo_parte;
        this.partes_incidencia = partes_incidencia;
    }
}

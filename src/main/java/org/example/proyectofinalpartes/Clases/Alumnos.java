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

        @Column(name = "id_grupo")
        private int id_grupo;

        @Column(name = "puntos_acumulados")
        private int puntos_acumulados;

        @Column(name = "nombre_alum")
        private String nombre_alum;

        @Column(name = "numero_expediente")
        private int numero_expediente;


        //RELACION ALUMNOS A GRUPOS || muchos alumnos a un grupo
        @ManyToOne
        @JoinColumn(name = "id_grupo", insertable = false, updatable = false)
        Grupos grupo;

        //RELACION ALUMNOS A PARTES_INCIDENCIAS || un alumno a muchos partes_incidencias
        @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL /*, orphanRemoval = true*/)
        private Set<Partes_incidencia> partes_incidencia = new HashSet<Partes_incidencia>();

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

        public int getNumero_expediente() {
            return numero_expediente;
        }

        public void setNumero_expediente(int numero_expediente) {
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

        public Alumnos() {
        }

        public Alumnos(int id_alum, int id_grupo, int puntos_acumulados, String nombre_alum, int numero_expediente, Grupos grupo, Set<Partes_incidencia> partes_incidencia) {
            this.id_alum = id_alum;
            this.id_grupo = id_grupo;
            this.puntos_acumulados = puntos_acumulados;
            this.nombre_alum = nombre_alum;
            this.numero_expediente = numero_expediente;
            this.grupo = grupo;
            this.partes_incidencia = partes_incidencia;
        }
    }

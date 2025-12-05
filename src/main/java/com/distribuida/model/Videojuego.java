package com.distribuida.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "videojuego")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;
    @Column(name = "plataforma")
    private String plataforma;
    @Column(name = "genero")
    private String genero;
    @Column(name = "fecha_lanzamiento")
    private String fechaLanzamiento;
    @Column(name = "estudio")
    private String estudio;
    @Column(name = "clasificacion")
    private String clasificacion;
    @Column(name = "modo_juego")
    private String modoJuego;

    public Videojuego(){}

    public Videojuego(int idProducto, String plataforma, String genero, String fechaLanzamiento, String estudio, String calsificacion, String modoJuego) {
        this.idProducto = idProducto;
        this.plataforma = plataforma;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.estudio = estudio;
        this.clasificacion = calsificacion;
        this.modoJuego = modoJuego;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getCalsificacion() {
        return clasificacion;
    }

    public void setCalsificacion(String calsificacion) {
        this.clasificacion = calsificacion;
    }

    public String getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(String modoJuego) {
        this.modoJuego = modoJuego;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "idProducto=" + idProducto +
                ", plataforma='" + plataforma + '\'' +
                ", genero='" + genero + '\'' +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                ", estudio='" + estudio + '\'' +
                ", calsificacion='" + clasificacion + '\'' +
                ", modoJuego='" + modoJuego + '\'' +
                '}';
    }
}

package com.distribuida.model;

import jakarta.persistence.*;

@Entity
@Table( name = "accesorios" )

public class Accesorios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;
    @Column(name = "conectividad")
    private String conectividad;
    @Column(name = "compatibilidad")
    private String compatibilidad;
    @Column(name = "marca")
    private String marca;
    @Column(name = "color")
    private String color;
    @Column(name = "conexion")
    private String conexion;

    public Accesorios(){}

    public Accesorios(int idProducto, String conectividad, String compatibilidad, String marca, String color, String conexion) {
        this.idProducto = idProducto;
        this.conectividad = conectividad;
        this.compatibilidad = compatibilidad;
        this.marca = marca;
        this.color = color;
        this.conexion = conexion;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(String compatibilidad) {
        this.compatibilidad = compatibilidad;
    }

    public String getConectividad() {
        return conectividad;
    }

    public void setConectividad(String conectividad) {
        this.conectividad = conectividad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Accesorios{" +
                "idProducto=" + idProducto +
                ", conectividad='" + conectividad + '\'' +
                ", compatibilidad='" + compatibilidad + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", conexion='" + conexion + '\'' +
                '}';
    }
}

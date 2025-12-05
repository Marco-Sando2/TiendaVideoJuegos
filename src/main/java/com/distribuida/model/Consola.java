package com.distribuida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "consola")
public class Consola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consola")
    private int idConsola;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "almacenamiento")
    private String almacenamiento;
    @Column(name = "color")
    private String color;

    public Consola(){};

    public Consola(int idConsola, String marca, String modelo, String almacenamiento, String color) {
        this.idConsola = idConsola;
        this.marca = marca;
        this.modelo = modelo;
        this.almacenamiento = almacenamiento;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdConsola() {
        return idConsola;
    }

    public void setIdConsola(int idConsola) {
        this.idConsola = idConsola;
    }

    @Override
    public String toString() {
        return "Consola{" +
                "idConsola=" + idConsola +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", almacenamiento='" + almacenamiento + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

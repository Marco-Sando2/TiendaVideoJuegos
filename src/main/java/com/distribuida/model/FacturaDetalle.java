package com.distribuida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "factura_detalle")
public class FacturaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura_detalle")
    private int idFacturaDetalla;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    public Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    public Producto producto;

    public FacturaDetalle(){}

    public FacturaDetalle(int idFacturaDetalla, int cantidad, Double subtotal, Factura factura, Producto producto) {
        this.idFacturaDetalla = idFacturaDetalla;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.factura = factura;
        this.producto = producto;
    }

    public int getIdFacturaDetalla() {
        return idFacturaDetalla;
    }

    public void setIdFacturaDetalla(int idFacturaDetalla) {
        this.idFacturaDetalla = idFacturaDetalla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "FacturaDetalle{" +
                "idFacturaDetalla=" + idFacturaDetalla +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", factura=" + factura +
                ", producto=" + producto +
                '}';
    }
}

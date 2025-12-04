package com.distribuida.model;

import jakarta.persistence.Id;

public class FacturaDetalle {

    private int idFacturaDetalla;
    private int cantidad;
    private Double subtotal;

    public Factura factura;

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

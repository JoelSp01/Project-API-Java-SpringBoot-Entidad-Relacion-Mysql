package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_productos") // Este es el nombre de la tabla, actualízalo si es necesario
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id") // Mapea al nombre exacto en la base de datos
    private Long prodId;

    @Column(name = "prod_nombre", nullable = false)
    private String prodNombre;

    @Column(name = "prod_descripcion")
    private String prodDescripcion;

    @Column(name = "prod_precio", nullable = false)
    private Double prodPrecio;

    @Column(name = "prod_stock", nullable = false)
    private Integer prodStock;

    @ManyToOne
    @JoinColumn(name = "cli_id", nullable = false)
    @JsonBackReference
    private Cliente cliente;

    // Getters y setters

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    public String getProdDescripcion() {
        return prodDescripcion;
    }

    public void setProdDescripcion(String prodDescripcion) {
        this.prodDescripcion = prodDescripcion;
    }

    public Double getProdPrecio() {
        return prodPrecio;
    }

    public void setProdPrecio(Double prodPrecio) {
        this.prodPrecio = prodPrecio;
    }

    public Integer getProdStock() {
        return prodStock;
    }

    public void setProdStock(Integer prodStock) {
        this.prodStock = prodStock;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

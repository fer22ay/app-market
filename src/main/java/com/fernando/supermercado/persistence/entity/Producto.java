package com.fernando.supermercado.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fernando Ambrosio
 * @since 05/10/2020
 */
@Data
@Entity
@Table(name = "productos", schema = "market")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Long cantidadStock;

    private Boolean estado;

    /**
     * Las anotaciones insertable y updatable se utilizan para que no se puede
     * actualizar desde esta clase, sino que se tenga que hacer directamente de la
     * clase categoria.
     */
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

}

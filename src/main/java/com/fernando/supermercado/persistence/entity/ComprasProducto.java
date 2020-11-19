package com.fernando.supermercado.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase que representa la tabla compras_productos de la base de datos. Donde se almacenara
 * los detalles de los productos.
 *
 * @author Fernando
 * @since 06/10/2020
 */
@Data
@Entity
@Table(name = "compras_productos", schema = "market")
public class ComprasProducto implements Serializable {

    private static final long serialVersionUID = 99508871893973958L;

    @EmbeddedId
    private ComprasProductoPK id;

    private Long cantidad;

    private Double total;

    private Boolean estado;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

}

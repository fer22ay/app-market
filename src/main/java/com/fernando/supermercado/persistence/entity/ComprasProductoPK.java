package com.fernando.supermercado.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Clase que representa la llave compuesta entre compras y compras_prdocutos.
 *
 * @author Fernando
 * @since 06/10/2020
 */
@Data
@Embeddable
public class ComprasProductoPK implements Serializable {

    private static final long serialVersionUID = -4966101256653168649L;

    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_producto")
    private Long idProducto;

}

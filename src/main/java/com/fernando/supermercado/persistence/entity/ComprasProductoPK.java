package com.fernando.supermercado.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Clase que representa una llave compuesta de la base de datos.
 * @author Fernando
 * @since 06/10/2020
 */
@Data
@Embeddable
public class ComprasProductoPK implements Serializable {

    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_producto")
    private Long idProducto;

}

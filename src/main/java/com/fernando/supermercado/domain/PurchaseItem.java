package com.fernando.supermercado.domain;

import lombok.Data;

/**
 * Clase que representa la clase ComprasProducto, que se utilizara para exponer a la API.
 * @author Fernando
 * @since 07/10/2020
 */
@Data
public class PurchaseItem {

    private long productId;

    private long quantity;

    private double total;

    private boolean active;

}

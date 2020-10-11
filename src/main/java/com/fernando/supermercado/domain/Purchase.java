package com.fernando.supermercado.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que representa la clase Compra de la entidad, para exponer en la API.
 * @author Fernando
 * @since 07/10/2020
 */
@Data
public class Purchase {

    private long purchaseId;

    private String clientId;

    private LocalDateTime date;

    private String paymentMethod;

    private String comment;

    private String state;

    private List<PurchaseItem> items;

}

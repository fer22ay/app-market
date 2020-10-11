package com.fernando.supermercado.domain;

import lombok.Data;

/**
 * @author Fernando
 * @since 06/10/2020
 */
@Data
public class Product {

    private long productId;

    private String name;

    private long categoryId;

    private double price;

    private long stock;

    private boolean active;

    private Category category;

}

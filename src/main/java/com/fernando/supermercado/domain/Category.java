package com.fernando.supermercado.domain;

import lombok.Data;

/**
 * @author Fernando
 * @since 06/10/2020
 */
@Data
public class Category {

    private long categoryId;

    private String category;

    private boolean active;

}

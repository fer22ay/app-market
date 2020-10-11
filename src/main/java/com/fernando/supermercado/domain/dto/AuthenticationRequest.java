package com.fernando.supermercado.domain.dto;

import lombok.Data;

/**
 * @author Fernando
 * @since 11/10/2020
 */
@Data
public class AuthenticationRequest {

    private String username;
    private String password;

}

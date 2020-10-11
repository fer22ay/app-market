package com.fernando.supermercado.domain.repository;

import com.fernando.supermercado.domain.Purchase;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define nuestros metodos para al API rest
 *
 * @author Fernando
 * @since 07/10/2020
 */
public interface PurchaseRepository {

    /**
     * Metodo para obtener todas las compras de la base de datos.
     *
     * @return lista de compras
     */
    List<Purchase> getAll();

    /**
     * Metodo para buscar a cliente(s) que han realizado compra(s)
     *
     * @param clientId de tipo Long
     * @return los datos de cliente con sus compras
     */
    Optional<List<Purchase>> getByClient(String clientId);

    /**
     * Metodo para guardar una compra
     * 
     * @param purchase de tipo entity Purchase
     * @return
     */
    Purchase save(Purchase purchase);

}

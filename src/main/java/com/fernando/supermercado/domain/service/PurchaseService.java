package com.fernando.supermercado.domain.service;

import com.fernando.supermercado.domain.Purchase;
import com.fernando.supermercado.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Fernando
 * @since 08/10/2020
 */
@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    /**
     * Metodo para listar las compras.
     *
     * @return Lista de compras
     */
    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    /**
     * Metodo para buscar las compras de un cliente
     *
     * @param clientId Identificador del cliente de tipo String
     * @return las compras del cliente
     */
    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }

    /**
     * Metodo para guardar una compra
     *
     * @param purchase Entity de Purchase
     * @return
     */
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

}

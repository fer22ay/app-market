package com.fernando.supermercado.persistence.crud;

import com.fernando.supermercado.persistence.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Fernando
 * @since 08/10/2020
 */
public interface CompraCrudRepository extends JpaRepository<Compra, Long> {

    /**
     * Metod para listar las compras que ha hecho un cliente
     *
     * @param IdCliente Identificador del cliente de tipo String
     * @return Listado de compras por cliente
     */
    Optional<List<Compra>> findByIdCliente(String IdCliente);

}

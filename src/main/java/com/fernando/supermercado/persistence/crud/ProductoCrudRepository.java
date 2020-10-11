package com.fernando.supermercado.persistence.crud;

import com.fernando.supermercado.persistence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Fernando
 * @since 06/10/2020
 */
public interface ProductoCrudRepository extends JpaRepository<Producto, Long> {

    /**
     * Metodo para buscar productos por medio de su identificador de categoria.
     *
     * @param idCategoria de tipo Long
     * @return Los productos que contengan el identificador buscado
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(long idCategoria);

    /**
     * Metodo para listar los productos escasos en stock y que esten activos.
     *
     * @param cantidadStock de tipo Long
     * @param estado de tipo boolean
     * @return los productos con stock escaso y que su estado sea activo.
     */
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(long cantidadStock, boolean estado);
}

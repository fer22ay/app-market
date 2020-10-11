package com.fernando.supermercado.domain.repository;

import com.fernando.supermercado.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author Fernando
 * @since 06/10/2020
 */
public interface ProductRepository {

    /**
     * Metodo para listar todos los productos.
     * @return lista de productos
     */
    List<Product> getAll();

    Optional<List<Product>> getByCategory(long categoryId);

    /**
     * Metodo para obtener los productos escasos
     * @param quantity de tipo Long
     * @return Los productos escasos en stock
     */
    Optional<List<Product>> getScarseProducts(long quantity);

    Optional<Product> getProduct(long productId);

    /**
     * Metodo para guardar un producto en la base de datos
     * @param product de tipo Product
     * @return
     */
    Product save(Product product);

    /**
     * Metodo para eliminar un producto en la base de datos.
     * @param productId
     */
    void delete(long productId);

    /**
     * Metodo para actualizar un producto de la base de datos.
     * @param product de tipo Long
     * @return
     */
    Product update(Product product);

}

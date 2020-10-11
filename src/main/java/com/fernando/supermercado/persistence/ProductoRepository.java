package com.fernando.supermercado.persistence;

import com.fernando.supermercado.domain.Product;
import com.fernando.supermercado.domain.repository.ProductRepository;
import com.fernando.supermercado.persistence.crud.ProductoCrudRepository;
import com.fernando.supermercado.persistence.entity.Producto;
import com.fernando.supermercado.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Clase encargada de interactuar con la base de datos.
 *
 * @author Fernando
 * @since 06/10/2020
 */
@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    /**
     * Metodo para listar los productos de la base de datos.
     *
     * @return lista de productos.
     */
    public List<Product> getAll(){
        List<Producto> productos = productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    /**
     * Metodo para buscar productos por su identificador de categoria y los ordena por nombre ascendente.
     *
     * @param categoryId de tipo Long
     * @return Lista de productos que se encuentran con el identificador de categoria.
     */
    @Override
    public Optional<List<Product>> getByCategory(long categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    /**
     * Metodo que para listar los productos escasos
     *
     * @param quantity de tipo Long
     * @return Los productos con stock escaso y que actualmente esten activos
     */
    @Override
    public Optional<List<Product>> getScarseProducts(long quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    /**
     * Metodo para buscar un producto por medio de su identificador
     *
     * @param productId de tipo Long
     * @return los datos de un unico producto.
     */
    @Override
    public Optional<Product> getProduct(long productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    /**
     * Metodo para guardar un producto
     *
     * @param product de tipo Product
     * @return
     */
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    /**
     * Metodo para eliminar un producto de la base de datos.
     *
     * @param productId de tipo Long
     */
    @Override
    public void delete(long productId){
        productoCrudRepository.deleteById(productId);
    }

    /**
     * Metodo para actualizar un producto de la base de datos.
     * @param product de tipo Long
     * @return
     */
    @Override
    public Product update(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

}

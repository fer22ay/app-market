package com.fernando.supermercado.persistence.mapper;

import com.fernando.supermercado.domain.Product;
import com.fernando.supermercado.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author Fernando
 * @since 06/10/2020
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({ @Mapping(source = "idProducto", target = "productId"), @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"), @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"), @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"), })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

}

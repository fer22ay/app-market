package com.fernando.supermercado.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa las categorias de los productos
 *
 * @author Fernando
 * @since 05/10/2020
 */
@Data
@Entity
@Table(name = "categorias", schema = "market")
public class Categoria implements Serializable {

    private static final long serialVersionUID = -6036814456901274167L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    private String descripcion;

    private Boolean estado;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Producto> productos;

}

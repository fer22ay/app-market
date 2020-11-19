package com.fernando.supermercado.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa la tabla clientes de la base de datos.
 *
 * @author Fernando
 * @since 06/10/2020
 */
@Data
@Entity
@Table(name = "clientes", schema = "market")
public class Cliente implements Serializable {

    private static final long serialVersionUID = -4922314092723783337L;

    @Id
    @Column(name = "id")
    private String idCliente;

    private String nombre;

    private String apellidos;

    private Long celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Compra> compras;

}

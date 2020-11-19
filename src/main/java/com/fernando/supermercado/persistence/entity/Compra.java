package com.fernando.supermercado.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que tendra los registros de las compras de los clients.
 *
 * @author Fernando
 * @since 06/10/2020
 */
@Data
@Entity
@Table(name = "compras", schema = "market")
public class Compra implements Serializable {

    private static final long serialVersionUID = -6459347932797276798L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ComprasProducto> productos; //productos - compras

}

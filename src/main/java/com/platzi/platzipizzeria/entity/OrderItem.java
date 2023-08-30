package com.platzi.platzipizzeria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)//Le indica a nuestra entidad que posee una clave primaria compuesta
@Getter @Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Id
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Integer quantity;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", updatable = false, insertable = false)
    private Pizza pizza;
    //No es necesario hacer la relación OneToOne dentro de la entidad Pizza, porque no tiene una utilidad práctica.
    //Si en el futuro necesitáramos buscar las órdenes que corresponden a una pizza, podríamos hacerlo con queries.

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", updatable = false, insertable = false)
    private PizzaOrder order;

}

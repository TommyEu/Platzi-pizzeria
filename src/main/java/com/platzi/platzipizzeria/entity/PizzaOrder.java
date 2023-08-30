package com.platzi.platzipizzeria.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private Date date;

    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double total;

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String method;

    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;

    @OneToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", updatable = false, insertable = false)
    private Customer customer;
    //No es necesario hacer la relación OneToOne dentro de la entidad Customer, porque no tiene una utilidad práctica.
    //Si en el futuro necesitáramos buscar las órdenes que corresponden a un determinado customer, podríamos hacerlo con queries

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;



}

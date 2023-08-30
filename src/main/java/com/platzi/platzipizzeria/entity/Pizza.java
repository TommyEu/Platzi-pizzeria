package com.platzi.platzipizzeria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizza")
@Getter @Setter
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @Column(columnDefinition = "TINYINT")
    private boolean vegetarian;

    @Column(columnDefinition = "TINYINT")
    private boolean vegan;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private boolean available;

    //No es necesario hacer la relación OneToOne en la entidad Pizza, porque no tiene una utilidad práctica.
    //Si en el futuro necesitáramos buscar las órdenes que corresponden a una pizza, podríamos hacerlo con queries
}

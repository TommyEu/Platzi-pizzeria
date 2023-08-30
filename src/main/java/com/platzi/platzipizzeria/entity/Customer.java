package com.platzi.platzipizzeria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter @Setter
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "id_customer", nullable = false, length = 15)
    private String IdCustomer;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(length = 100)
    private String address;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(name = "phone_number", length = 20, unique = true)
    private String phoneNumber;
    //No es necesario hacer la relación OneToOne en la entidad Customer, porque no tiene una utilidad práctica.
    //Si en el futuro necesitáramos buscar las órdenes que corresponden a un determinado customer, podríamos hacerlo con queries

}

package com.example.relationship.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class PhysicalPerson extends Person{
    @Id
    private int id;

    private String cpf;
}

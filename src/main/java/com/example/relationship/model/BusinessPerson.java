package com.example.relationship.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class BusinessPerson extends Person{
    @Id
    private int id;

    private String cnpj;
}

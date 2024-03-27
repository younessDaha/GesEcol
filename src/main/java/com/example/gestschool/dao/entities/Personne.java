package com.example.gestschool.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Column(name = "name")
    private String nom;
    @Column(name = "Date_birth")
    private Date dateNaissance;

}

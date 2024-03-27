package com.example.gestschool.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur extends Personne {
    @Column(name = "Date_Assignment")
    private Date daffectation;

    //Association avec la table cours
    @OneToOne(mappedBy = "professeur" , cascade = CascadeType.ALL)
    private Cours cours;

    @Override
    public String toString() {
        return "Professeur{" +
                "nom='" + getNom()+ '\'' +
                "date de naissance='" + getDateNaissance()+ '\'' +
                "daffectation=" + daffectation +
                "cours=" + cours +

                '}';
    }
}

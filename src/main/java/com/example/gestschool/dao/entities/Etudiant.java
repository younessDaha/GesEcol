package com.example.gestschool.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Etudiant extends Personne{
    @Column(name="Register")
    private String matricule;

    //Association avec la table seance
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Collection<Seance> seances = new ArrayList<>();

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + getNom()+ '\'' +
                "date de naissance='" + getDateNaissance()+ '\'' +
                "matricule='" + matricule + '\'' +
                "seance='" + seances + '\'' +

                '}';
    }

}

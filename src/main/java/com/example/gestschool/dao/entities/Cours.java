package com.example.gestschool.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "course")
    private String titre;
    @Column(name = "description")
    private String description;

    //Association avec la table seance
    @OneToMany(mappedBy = "cours",fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Collection<Seance>seances=new ArrayList<>();

    //Association avec la table professeur
    @OneToOne(cascade = CascadeType.ALL)
    private Professeur professeur;

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +


                '}';
    }
}

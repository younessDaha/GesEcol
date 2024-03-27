package com.example.gestschool.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Session")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date")
    private Date date;
    @Column(name = "h_start")
    private Date hdebut;
    @Column(name = "h_end")
    private Date hfin;

    //Association avec la table etudiant
    @ManyToMany(mappedBy = "seances", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Collection<Etudiant>etudiants=new ArrayList<>();

    //Association avec la table cours

    @ManyToOne(cascade = CascadeType.ALL)
    private Cours cours;

    @Override
    public String toString() {

            return "Seance{" +
                    "id=" + id +
                    ", date=" + date +
                    ", hdebut=" + hdebut +
                    ", hfin=" + hfin +
                    ", cours=" + cours +
                    '}';
    }
}

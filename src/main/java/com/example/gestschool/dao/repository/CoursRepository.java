package com.example.gestschool.dao.repository;

import com.example.gestschool.dao.entities.Cours;
import com.example.gestschool.dao.entities.Professeur;
import com.example.gestschool.dao.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Integer> {
//    public List<Cours> findByTitre(String titre);
    public Cours findByTitre(String titre);

    public List<Cours> findByDescription(String description);

    //++++
    public List<Cours> findByProfesseur(Professeur professeur);
    public  List<Cours> findBySeances(Seance seance);


    public List<Cours> deleteByTitre(String titre);
    public List<Cours> deleteByDescription(String description);
}

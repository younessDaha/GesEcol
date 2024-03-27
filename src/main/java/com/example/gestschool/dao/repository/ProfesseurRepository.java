package com.example.gestschool.dao.repository;

import com.example.gestschool.dao.entities.Cours;
import com.example.gestschool.dao.entities.Etudiant;
import com.example.gestschool.dao.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    public List<Professeur> findByDateNaissance(Date date_Naissance);
    public List<Professeur> findByNom(String nom);
    public List<Professeur> findByDaffectation(Date d_affectation);

    //++++
    public List<Professeur> findByCours(Cours cours);

    public Long deleteByDateNaissance(Date date_Naissance);
    public Long deleteByNom(String nom);
    public List<Professeur> deleteByDaffectation(Date d_affectation);
}

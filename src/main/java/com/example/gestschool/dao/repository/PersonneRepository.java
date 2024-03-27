package com.example.gestschool.dao.repository;

import com.example.gestschool.dao.entities.Etudiant;
import com.example.gestschool.dao.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
    public List<Personne> findByDateNaissance(Date date_Naissance);
    public List<Personne> findByNom(String nom);

    public Long deleteByDateNaissance(Date date_Naissance);
     public Long deleteByNom(String nom);
}

package com.example.gestschool.dao.repository;

import com.example.gestschool.dao.entities.Etudiant;
import com.example.gestschool.dao.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    public List<Etudiant> findByDateNaissance(Date date_Naissance);
    public List<Etudiant> findByNom(String nom);
    public List<Etudiant> findByMatricule(String matricule);

    //++++
    public List<Etudiant> findBySeances(Seance seance);


    public Long deleteByDateNaissance(Date date_Naissance);
    public Long deleteByNom(String nom);
    public List<Etudiant> deleteByMatricule(String matricule);
}

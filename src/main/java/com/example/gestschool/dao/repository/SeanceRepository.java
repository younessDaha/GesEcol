package com.example.gestschool.dao.repository;

import com.example.gestschool.dao.entities.Cours;
import com.example.gestschool.dao.entities.Etudiant;
import com.example.gestschool.dao.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance,Integer> {
    public List<Seance> findByDate(Date date);
    public List<Seance> findByHdebut(Date h_debut);
    public List<Seance> findByHfin(Date hfin);

    public List<Seance> findByEtudiants(Etudiant etudiant);
    public  List<Seance> findByCours(Cours cours);


    public Long deleteByDate(Date date);
    public Long deleteByHdebut(Date hdebut);
    public Long deleteByHfin(Date hfin);
}

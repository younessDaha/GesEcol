package com.example.gestschool;

import com.example.gestschool.dao.entities.*;
import com.example.gestschool.dao.repository.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GestschoolApplication implements CommandLineRunner {
    @Autowired
    public CoursRepository coursRepository;
    @Autowired
    public PersonneRepository personneRepository;
    @Autowired
    public SeanceRepository seanceRepository;
    @Autowired
    public ProfesseurRepository professeurRepository;
    @Autowired
    public EtudiantRepository etudiantRepository;



    public static void main(String[] args) {
        SpringApplication.run(GestschoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
  //CRUD
    // Create
        Professeur professeur = new Professeur();
        professeur.setNom("badr");
        professeur.setDateNaissance(new Date(1999,01,01));
        professeur.setDaffectation(new Date(2023,01,01));
        personneRepository.save(professeur);


        Cours cours = new Cours();
        cours.setTitre("jee");
        cours.setDescription("java edition entreprise");
        coursRepository.save(cours);


        Seance seance = new Seance();
        seance.setDate(new Date(2024,01,01));
        seance.setHfin(new Date(2025,01,01));
        seance.setHdebut(new Date(2023,01,01));
        seanceRepository.save(seance);




        Seance seance1 = new Seance();
        seance1.setDate(new Date(2024,01,01));
        seance1.setHfin(new Date(2025,01,01));
        seance1.setHdebut(new Date(2023,01,01));
        seanceRepository.save(seance1);


        Etudiant etudiant = new Etudiant();
        etudiant.setDateNaissance(new Date(2002,07,28));
        etudiant.setMatricule("AJ-0615");
        etudiant.setNom("Aya");
        personneRepository.save(etudiant);

        Etudiant etudiant1 = new Etudiant();
        etudiant1.setDateNaissance(new Date(2002,06,13));
        etudiant1.setMatricule("Yd-1312");
        etudiant1.setNom("Younes");
        personneRepository.save(etudiant1);


        Etudiant etudiant2 = new Etudiant();
        etudiant2.setDateNaissance(new Date(2022,02,02));
         etudiant2.setMatricule("El-0202");
        etudiant2.setNom("Elias");
        personneRepository.save(etudiant2);



        //liaison des classea
        List<Seance> seances = new ArrayList<>();
        seances.add(seance);
        seances.add(seance1);
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(etudiant);
        etudiants.add(etudiant1);
        etudiants.add(etudiant2);

        cours.setProfesseur(professeur);
        professeur.setCours(cours);
        cours.setSeances(seances);
        seance.setCours(cours);
        seance1.setCours(cours);
        seance.setEtudiants(etudiants);
        seance1.setEtudiants(etudiants);
        etudiant.setSeances(seances);
        etudiant1.setSeances(seances);
        etudiant2.setSeances(seances);
        //sauvegarde avec liaison
        personneRepository.save(professeur);
        coursRepository.save(cours);
        personneRepository.save(etudiant);
        personneRepository.save(etudiant1);
        personneRepository.save(etudiant2);
        seanceRepository.save(seance);
        seanceRepository.save(seance1);
//
    //Read
        List<Professeur> professeurList=professeurRepository.findAll();
        professeurList.forEach(p->{
            System.out.println(p.toString());
        });

        List<Etudiant> etudiantList=etudiantRepository.findAll();
        etudiantList.forEach(e->{System.out.println(e.toString());});

        List<Cours> coursList=coursRepository.findAll();
        coursList.forEach(c->{
            System.out.println(c.toString());
        });

        List<Seance> seanceList=seanceRepository.findAll();
        seanceList.forEach(s->{
            System.out.println(s.toString());
        });

        //UpDate

            etudiant2.setMatricule("ES-02022022");
        personneRepository.save(etudiant2);
        System.out.println(etudiant2.toString());


            cours.setDescription("spring boot");
        coursRepository.save(cours);
        System.out.println(cours.toString());


            ((Professeur) professeur).setDaffectation(new Date(2019,02,02));
        personneRepository.save(professeur);
        System.out.println(professeur.toString());


             seance1.setHdebut(new Date(2024,03,03));
        seanceRepository.save(seance1);
        System.out.println(seance1.toString());

    //delete

        personneRepository.deleteById(1L);
            try {
                personneRepository.findById(1L).get();
            }catch (Exception exception){
                System.out.println("personne supprimer");
            }

        coursRepository.deleteByTitre("jee");
            try {
                Cours coursTest = coursRepository.findByTitre("jee");
                System.out.println(coursTest.toString());
            }catch (Exception exception){
                System.out.println("cours jee est suprimer");
            }

        seanceRepository.deleteById(1);
            try {
                personneRepository.findById(1L).get();
            }catch (Exception exception){
                System.out.println("seance supprimer");
            }


    }
    }

package com.example.recyclerview_mvvm.model;

import java.util.ArrayList;
import java.util.List;

public class Pays {
    private String nom,capital;
    public static ArrayList<Pays> listPays = new ArrayList<>(
            List.of(
                    new Pays("Palestine","Al-Qods"),
                    new Pays("Palestine01","Al-Qods"),
                    new Pays("Palestine02","Al-Qods"),
                    new Pays("Palestin03","Al-Qods"),
                    new Pays("Palestine04","Al-Qods"),
                    new Pays("Palestine05","Al-Qods"),
                    new Pays("Palestine06","Al-Qods"),
                    new Pays("Palestine07","Al-Qods")
            )
    );

    public Pays(String nom , String capital){
        this.nom = nom ;
        this.capital  = capital;

    }

    public String getNom() {
        return nom;
    }

    public String getCapital() {
        return capital;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}

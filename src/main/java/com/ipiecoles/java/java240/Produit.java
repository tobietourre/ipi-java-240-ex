package com.ipiecoles.java.java240;

import javax.persistence.*;

@Entity
@Table(name = "produit")
public class Produit {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String intitule;

    @Column
    private Double prixEuro;

    public Produit(String intitule, Double prixEuro) {
        this.intitule = intitule;
        this.prixEuro = prixEuro;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Double getPrixEuro() {
        return prixEuro;
    }

    public void setPrixEuro(Double prixEuro) {
        this.prixEuro = prixEuro;
    }

    @Override
    public String toString() {
        return "Produit : " +
                "'" + intitule + '\'' +
                ", prix : " + prixEuro +
                '€';
    }
}

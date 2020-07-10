package com.doruvarga.springpostgresql.Model;


import javax.persistence.*;
import java.util.List;

//asa configurezi o entitate jpa
@Entity
@Table(name = "Outfits")
public class Outfit {

    @Id
    private int id;
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "tshirt_name")
    private String tshirt;

//    @Column(name = "outfit_id")
//    private int outfitId;

//    @OneToMany(mappedBy = "outfit")
//    private List<Shoe>shoes;

    public Outfit(String tshirt) {
        this.tshirt = tshirt;

    }

    public Outfit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTshirt() {
        return tshirt;
    }

    public void setTshirt(String tshirt) {
        this.tshirt = tshirt;
    }



}

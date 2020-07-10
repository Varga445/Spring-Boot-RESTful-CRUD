package com.doruvarga.springpostgresql.Model;


import javax.persistence.*;

//asa configurezi o entitate jpa
@Entity
@Table(name = "shoes")
public class Shoe {

    @Id//asa faci sa ai primary key-ul
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY) !!! nu mere asa iti da eroaraea asta
    //ConstraintViolationException
    //asa faci a primary key-ul sa sea auto incrementeze cand adaugi un element
    //Pentru POSTGRES
    private int id;

    ///////////////////////////////////////////////////////
//   @ManyToOne
//    private Outfit outfit;
//
//    public Outfit getOutfit() {
//        return outfit;
//    }
//
//    public void setOutfit(Outfit outfit) {
//        this.outfit = outfit;
//    }
    //
//
//    public Outfit getOutfit() {
//        return outfit;
//    }
//
//    public void setOutfit(Outfit outfit) {
//        this.outfit = outfit;
//    }

    //////////////////////////////////////////////////////////////
    @Column(name = "model_name")
    private String modelName;
    //asa creezi in tabel o coloana denumita model_name


    @Column(name = "brand_name")
    private String brandName;
    //asa creezi in tabel o coloana denumita brand_name


    @Column(name = "type_name")
    private String typeName;

    public Shoe() {
    }


    public Shoe(String modelName, String brandName, String typeName) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.typeName = typeName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

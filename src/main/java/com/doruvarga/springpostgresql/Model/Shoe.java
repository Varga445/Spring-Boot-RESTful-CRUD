package com.doruvarga.springpostgresql.Model;


import javax.persistence.*;


@Entity
@Table(name = "shoes")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

 
    @Column(name = "model_name")
    private String modelName;
  


    @Column(name = "brand_name")
    private String brandName;
 


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

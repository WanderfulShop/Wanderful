package com.codeup.adlister.models;

import java.io.Serializable;

public class Wand implements Serializable {
    private int id;
    private String wandName;
    private String coreMaterial;
    private String woodType;
    private String useCategory;
    private int age;
    private String imageUri;
    private int userId;

    public Wand(int id, String wandName, String coreMaterial, String woodType, String useCategory, int age, String imageUri, int userId){
        this.id = id;
        this.wandName = wandName;
        this.coreMaterial = coreMaterial;
        this.woodType = woodType;
        this.useCategory = useCategory;
        this.age = age;
        this.imageUri = imageUri;
        this.userId = userId;
    }

    // getters and setters...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWandName() {
        return wandName;
    }

    public void setWandName(String wandName) {
        this.wandName = wandName;
    }

    public String getCoreMaterial() {
        return coreMaterial;
    }

    public void setCoreMaterial(String coreMaterial) {
        this.coreMaterial = coreMaterial;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public String getUseCategory() {
        return useCategory;
    }

    public void setUseCategory(String useCategory) {
        this.useCategory = useCategory;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

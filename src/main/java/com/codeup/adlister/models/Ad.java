package com.codeup.adlister.models;

import java.io.Serializable;
import java.util.Date;

// This is a BEAN!
public class Ad implements Serializable {
    private long id;
    private Date creationDate;
    private String adTitle;
    private String adDescription;

    public Ad(long id, Date creationDate, String adTitle, String adDescription) {
        this.id = id;
        this.creationDate = creationDate;
        this.adTitle = adTitle;
        this.adDescription = adDescription;
    }

    public Ad(long id, String adTitle, String adDescription) {
        this.id = id;
        this.adTitle = adTitle;
        this.adDescription = adDescription;
    }

    // getters and setters...
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdDescription() {
        return adDescription;
    }

    public void setAdDescription(String adDescription) {
        this.adDescription = adDescription;
    }
}

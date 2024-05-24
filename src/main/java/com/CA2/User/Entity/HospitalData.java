package com.CA2.User.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
@Entity
@Table(name = "hospital")
public class HospitalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long year;
    private String county;
    private String hospital;
    private String surgery;
    private long cases;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_foreign_id", nullable = false)
    private User user;

    // Constructors, getters, and setters

    public HospitalData() {
    }

    public HospitalData(long year, String county, String hospital, String surgery, long cases) {
        super();
        this.year = year;
        this.county = county;
        this.hospital = hospital;
        this.surgery = surgery;
        this.cases = cases;
    }


    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
   
    @Override
    public String toString() {
    	return "HospitalDataGettersAndSetters [year=" + year + ", county=" + county + ", hospital=" + hospital + ", surgery=" + surgery + ", cases=" + cases + "]";

    }

}

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
@Table(name = "hospitaldata")
public class HospitalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="hospital_data_ID")
    private Long id;

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Column (name="year", nullable=false)
    private Long year;
    
    
    
    
    
    
    
    
    
    
    
    @Column (name="county", nullable=false)
    private String county;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Column (name="hospital", nullable=false)
    private String hospital;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Column (name="surgery", nullable=false)
    private String surgery;
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Column (name="cases", nullable=false)
    private Long cases;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_foreign_id", nullable = false)
    
    //IT REFERENCES THE USER
    
    //private User user;

    // Constructors, getters, and setters

    public HospitalData() {
    }

    public HospitalData(Long year, String county, String hospital, String surgery, Long cases) {
        super();
        this.year = year;
        this.county = county;
        this.hospital = hospital;
        this.surgery = surgery;
        this.cases = cases;
    }



    
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getYear() {
        return year;
    }

    public void setYear(Long year) {
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

    public void setCases(Long cases) {
        this.cases = cases;
    }

    
    // THE USER REFERENCES THE LOGGED IN USER AS FOREIGN KEY ETC
    
   // public User getUser() {
   //     return user;
   // }

   // public void setUser(User user) {
  //      this.user = user;
  //  }
    
   
    @Override
    public String toString() {
    	return "HospitalDataGettersAndSetters [year=" + year + ", county=" + county + ", hospital=" + hospital + ", surgery=" + surgery + ", cases=" + cases + "]";

    }

}

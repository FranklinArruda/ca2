package com.CA2.GettersAndSetters;
import jakarta.validation.constraints.NotNull;

public class HospitalDataGettersAndSetters {

	@NotNull(message = "Year is required")
	private long year;
    
	@NotNull(message = "Year is required")
	private String county;
	@NotNull(message = "Year is required")
    private String hospital;
	@NotNull(message = "Year is required")
    private String surgery;
	@NotNull(message = "Year is required")
    private long cases;
    
   
 // Constructor
    public HospitalDataGettersAndSetters(long year, String county, String hospital, String surgery, long cases) {
    	super();
    	this.year = year;
        this.county = county;
        this.hospital = hospital;
        this.surgery = surgery;
        this.cases = cases;
    }
 
    public long getYear() {
        return year;
    }

    public void setYear(Integer year) {
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
    
    @Override
    public String toString() {
    	return "HospitalDataGettersAndSetters [year=" + year + ", county=" + county + ", hospital=" + hospital + ", surgery=" + surgery + ", cases=" + cases + "]";

    }

}


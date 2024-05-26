

package com.CA2.GettersAndSetters;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HospitalDataGettersAndSetters {

    @NotNull(message = "Year is required")
    private Long year;

    @NotEmpty(message = "County is required")
    private String county;

    @NotBlank(message = "Hospital is required")
    private String hospital;

    @NotBlank(message = "Surgery is required")
    private String surgery;

    @NotNull(message = "Cases is required")
    private Long cases = 0L; // Initialize to 0 or any default value
 // Constructor
    public HospitalDataGettersAndSetters(Long year, String county, String hospital, String surgery, Long cases) {
    	super();
    	this.year = year;
        this.county = county;
        this.hospital = hospital;
        this.surgery = surgery;
        this.cases = cases;
    }
 
    public Long getYear() {
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

    public Long getCases() {
        return cases;
    }

    public void setCases(Long cases) {
        this.cases = cases;
    }
    
    @Override
    public String toString() {
    	return "HospitalDataGettersAndSetters [year=" + year + ", county=" + county + ", hospital=" + hospital + ", surgery=" + surgery + ", cases=" + cases + "]";

    }

}


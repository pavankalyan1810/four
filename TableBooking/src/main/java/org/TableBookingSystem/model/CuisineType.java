package org.TableBookingSystem.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CuisineType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuisineTypeId;
    
   
    private String cuisineTypeName;
    
    @OneToMany(mappedBy = "cuisineType")
    private List<Cuisine> cuisines;

	public Long getCuisineTypeId() {
		return cuisineTypeId;
	}

	public void setCuisineTypeId(Long cuisineTypeId) {
		this.cuisineTypeId = cuisineTypeId;
	}

	public String getCuisineTypeName() {
		return cuisineTypeName;
	}

	public void setCuisineTypeName(String cuisineTypeName) {
		this.cuisineTypeName = cuisineTypeName;
	}

	public List<Cuisine> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}

	public CuisineType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuisineType(Long cuisineTypeId, String cuisineTypeName, List<Cuisine> cuisines) {
		super();
		this.cuisineTypeId = cuisineTypeId;
		this.cuisineTypeName = cuisineTypeName;
		this.cuisines = cuisines;
	}

   
}
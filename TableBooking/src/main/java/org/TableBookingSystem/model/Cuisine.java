package org.TableBookingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cuisine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuisineId;
    
    private String cuisineName;
    
    private Long itemPrice;
    
    @ManyToOne
    @JoinColumn(name = "cuisine_type_id")
    private CuisineType cuisineType;

	public Long getCuisineId() {
		return cuisineId;
	}

	public void setCuisineId(Long cuisineId) {
		this.cuisineId = cuisineId;
	}

	public String getCuisineName() {
		return cuisineName;
	}

	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	public Long getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Long itemPrice) {
		this.itemPrice = itemPrice;
	}

	public CuisineType getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}

	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cuisine(Long cuisineId, String cuisineName, Long itemPrice, CuisineType cuisineType) {
		super();
		this.cuisineId = cuisineId;
		this.cuisineName = cuisineName;
		this.itemPrice = itemPrice;
		this.cuisineType = cuisineType;
	}

   
}
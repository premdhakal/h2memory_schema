package com.data.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlowerEntity extends PlantEntity {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) private Long Id;
	 */
	private String color;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	/*
	 * public Long getId() { return Id; } public void setId(Long id) { Id = id; }
	 */
	public FlowerEntity() {
	}
	public FlowerEntity( String color) {
		this.color = color;
	}
	
	
}

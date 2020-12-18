package com.data.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShrubEntity extends PlantEntity{
	
	private int height;
	private int width;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public ShrubEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShrubEntity(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}
	
	
	
}

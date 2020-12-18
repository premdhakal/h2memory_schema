package com.data.data.services;

import org.springframework.stereotype.Service;

import com.data.data.entities.PlantEntity;

@Service
public class PlantService {
	public PlantEntity getPlantByName(String name){
	       return new PlantEntity();
	   }
}

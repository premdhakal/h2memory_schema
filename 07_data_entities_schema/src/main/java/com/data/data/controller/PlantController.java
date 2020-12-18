package com.data.data.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.data.dto.PlantDTO;
import com.data.data.entities.PlantEntity;
import com.data.data.services.PlantService;
import com.data.data.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/plant")
public class PlantController {
	@Autowired
	private PlantService plantService;
	
	 //@GetMapping
	    public PlantDTO getPlantDto(String name){
		 	PlantEntity plantList = plantService.getPlantByName(name);
	        return convertPlantToPlantDTO(plantList);
	    }
	    
	    //@GetMapping
	    @JsonView(Views.Public.class)
	    public PlantEntity getFilteredPlant(String name){
	    	PlantEntity plantList = plantService.getPlantByName(name);
	        return plantList;
	    }
	    
	    private PlantDTO convertPlantToPlantDTO(PlantEntity plantEntity){
	        PlantDTO plantDTO = new PlantDTO();
	        BeanUtils.copyProperties(plantEntity, plantDTO);
	        return plantDTO;
	    }
}

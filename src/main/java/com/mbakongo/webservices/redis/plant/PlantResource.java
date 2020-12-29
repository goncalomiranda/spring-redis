package com.mbakongo.webservices.redis.plant;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PlantResource {
	

	@Autowired
	private PlantDaoService service;
	
	//retrieve all plants
	@GetMapping("/plants")
	public List<Plant> retrieveAllPlants(){
		return service.findAll();
	}	
	
	
	 //retrieve a plant by id
	 
	 @GetMapping("/plants/{id}") 
	 public Plant retrievePlant(@PathVariable int id){
		 Plant plant = service.findPlant(id);
		 
		 if(plant == null) {
			 throw new PlantNotFoundException("id-" + id);
		 }
		 else
			 return plant;
	 }
	 
	@PostMapping("/plants") 
	public ResponseEntity<Object> createPlant(@Valid @RequestBody Plant plant) {
		Plant savedPlant = service.save(plant);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPlant.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	 @DeleteMapping("/plants/{id}") 
	 public ResponseEntity<Object>  deletePlant(@PathVariable int id){
		 Plant plant = service.deletePlant(id);
		 
		 if(plant == null) {
			 throw new PlantNotFoundException("id-" + id);
		 }
		 else{
				return ResponseEntity.noContent().build();
			 }
	 }
	
}

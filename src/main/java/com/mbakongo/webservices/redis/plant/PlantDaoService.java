package com.mbakongo.webservices.redis.plant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PlantDaoService {

	private static List<Plant> plants = new ArrayList<>();
	private static Integer plantsCounter = 3;
	
	static {
		plants.add(new Plant(1,"Juniper Bonsai","indirect","bright","every 1 week", new BigDecimal(15.00)));
		plants.add(new Plant(2,"Fiddle Leaf Fig","indirect & direct","bright","every 2 weeks", new BigDecimal(12.00)));
		plants.add(new Plant(3,"Haworthia Succulent Mystery Box","indirect","low","every 2 weeks", new BigDecimal(10.00)));
	}
	
	
	public List<Plant> findAll(){
		return plants;
	}
	
	public Plant save(Plant plant) {
		
		if(plant.getId() == null) {
			plant.setId(++plantsCounter);
		}
		
		plants.add(plant);
		
		return plant;
	}
	
	public Plant findPlant(int id) {
		
		for (Plant plant : plants) {
			if(plant.getId() == id)
				return plant;
		}
		
		return null;
		
	}
	
	public Plant deletePlant(int id) {
		Iterator<Plant> iterator = plants.iterator();
		
		while (iterator.hasNext()) {
			Plant p = iterator.next();
			if(p.getId() == id) {
				iterator.remove();
				return p;
			}
		}
		
		return null;
		
	}
}

package com.example.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customexception.FieldRequiredException;
import com.example.model.AssimentBuildingDTO;
import com.example.model.BuildingDTO;
import com.example.model.response.BuildingSearchResponse;
import com.example.service.BuildingService;

@RestController
@RequestMapping(value = "/api/building")
public class BuildingApi {
	@Autowired 
	private BuildingService buildingService;
	
	@GetMapping
	public  List<BuildingSearchResponse> findAll(@RequestParam( name = "name",required = false) String name,@RequestParam(name = "numberofbasement" ,required = false) Integer numberofbasement) {
		List<BuildingSearchResponse> results = buildingService.findAll();
		return results;
	}
	@GetMapping(value = "/{buildingId}")
	public  BuildingSearchResponse getBuilding(@PathVariable("buildingId") Long buildingId) {
		System.out.println(buildingId);
		return null;
	}
	
	@PostMapping
	public  BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
		validateData(newBuilding);
		return newBuilding;
	}
	private void validateData(BuildingDTO newBuilding) {
		if(newBuilding.getName() == null || newBuilding.getName().equals("") || newBuilding.getNumberOfBasement() == null) {
			throw new FieldRequiredException("name or numberofbasement is null");
		}
		
	}
	@PutMapping
	public  BuildingApi updateBuilding(@RequestBody BuildingDTO updateBuilding) {
		System.out.println(updateBuilding.getId());
		System.out.println(updateBuilding.getName());
		return null;
	}
	@DeleteMapping
	public  BuildingApi deleteBuilding(@RequestBody Long[] ids) {
		for(Long id:ids) {
			System.out.println(id);
		}
		return null;
	}
	
	@PostMapping("/assignment")
	public  void assignmentBuildingBean(@RequestBody AssimentBuildingDTO assignmentBuildingBean) {
		System.out.println("hello");
	}
	
	
}

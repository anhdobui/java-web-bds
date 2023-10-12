package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.converter.RentAreaConverter;
import com.example.model.BuildingDTO;
import com.example.model.RentAreaDTO;
import com.example.model.response.BuildingSearchResponse;
import com.example.repository.BuildingRepository;
import com.example.repository.RentAreaRepository;
import com.example.repository.custom.BuildingRepositoryCustom;
import com.example.repository.custom.RentAreaRepositoryCustom;
import com.example.repository.entity.BuildingEntity;
import com.example.repository.entity.RentAreaEntity;
import com.example.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
//	@Autowired
//	private BuildingJdbc buildingJdbc;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	@Autowired
	private RentAreaConverter rentAreaConverter;
	

	@Override
	public List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> types) {
		List<BuildingSearchResponse> results = new ArrayList<>();
		List<BuildingEntity> buildingEntitis = buildingRepository.findAll(params,types);
//		List<BuildingEntity> buildingEntitis = buildingJdbc.findAll();
//		List<BuildingEntity> buildingEntitis = buildingRepository.findAll();
		for(BuildingEntity item: buildingEntitis) {
			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
			buildingSearchResponse.setName(item.getName());
			buildingSearchResponse.setAddress(item.getStreet() + " - " + item.getWard());
			results.add(buildingSearchResponse);
		}
		return results;
	}

	@Override
	public List<RentAreaDTO> findRentAreaByBuilding(Long buildingId) {
//		BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();
//		List<RentAreaEntity> rentAreaEntities = buildingEntity.getRentAreas();
		List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findByBuilding_Id(buildingId);
		List<RentAreaDTO> results = rentAreaEntities.stream().map(rentAreaConverter::converterEntityToDto).collect(Collectors.toList());
		return results;
	}

	@Override
	@Transactional
	public void save(BuildingDTO newBuilding) {
		BuildingEntity buildingEntity = null;
		buildingRepository.save(buildingEntity);
		
	}
	
	
}

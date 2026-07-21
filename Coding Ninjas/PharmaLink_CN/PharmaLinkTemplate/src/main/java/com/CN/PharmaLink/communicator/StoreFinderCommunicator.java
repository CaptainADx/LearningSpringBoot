package com.CN.PharmaLink.communicator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CN.PharmaLink.dto.MedicalStoreDto;

@Service
public class StoreFinderCommunicator {
	
	
	private final RestTemplate restTemplate;
	
	public StoreFinderCommunicator(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	String baseUrl = "http://localhost:8081/store";

	public List<MedicalStoreDto> getNearestMedicalStores(Long userId, Long distance, String token) {
		String url = baseUrl +
                "/getNearestStores/" +
                userId + "/" +
                distance + "/" +
                token;
		
		ResponseEntity<List<MedicalStoreDto>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<MedicalStoreDto>>() {}); 
		
		return response.getBody();
	}

	public List<MedicalStoreDto> getMedicalStoresWithMedicine(String medicine, String token) {
		String url = baseUrl + 
					"/getStoresWithMedicine/" +
					medicine +
					"/" + token;
		
		
		ResponseEntity<List<MedicalStoreDto>> response = restTemplate.exchange(url, HttpMethod.GET , null, new ParameterizedTypeReference<List<MedicalStoreDto>>() {} );
		
		return response.getBody();
	}
	
	
}

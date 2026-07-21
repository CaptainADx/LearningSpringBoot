package com.CN.CarQuest.communicator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CN.CarQuest.dto.ReviewRequest;
import com.CN.CarQuest.dto.ReviewResponse;


@Service
public class ReviewServiceCommunicator {
	
	@Autowired
	RestTemplate restTemplate;
	
	private final String baseUrl = "http://localhost:8081/review";
	
	public void addReview(ReviewRequest reviewRequest, String jwtToken) {
		String url = baseUrl + "/add" ;
		
		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", "Bearer "+jwtToken);
		
		HttpEntity<ReviewRequest> requestEntity = new HttpEntity<>(reviewRequest, header);
		
		
		restTemplate.exchange(url, HttpMethod.POST, requestEntity, ReviewRequest.class);
		
	}
	
	 public List<ReviewResponse> getReview(String carName, String jwtToken){
		 String url = baseUrl + "/" + carName ;
			
		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", "Bearer "+jwtToken);
		
		HttpEntity<Void> requestEntity = new HttpEntity<>(header);

		
		ResponseEntity<List<ReviewResponse>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<ReviewResponse>>() {});
		
		return responseEntity.getBody();
	 }
	
	
}

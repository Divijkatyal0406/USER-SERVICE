package com.sp.micro.user_s.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.micro.user_s.entities.Hotel;
import com.sp.micro.user_s.entities.Rating;
import com.sp.micro.user_s.entities.User;
import com.sp.micro.user_s.exceptions.ResourceNotFoundExc;
import com.sp.micro.user_s.external.services.HotelService;
import com.sp.micro.user_s.repositories.UserRepo;
import com.sp.micro.user_s.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public User saveUser(User u) {
		String random=UUID.randomUUID().toString();
		u.setId(random);
		return userRepo.save(u);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(String id) {
		User u=userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundExc("User"+id+"not found"));
		
		//this gives Linkedhash map can't cast to Rating so we can't use map below 
//		ArrayList<Rating> forObj=restTemplate.getForObject("http://localhost:8083/ratings/users/"+u.getId(), ArrayList.class);
				
		//soln->>
		Rating[] forObj=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+u.getId(), Rating[].class);
		Arrays.stream(forObj).toList();
	
		
		List<Rating> ratingList=Arrays.stream(forObj).map(rating -> {
			
			
		//USING REST TEMPLATE
//		ResponseEntity<Hotel> responseEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class );
//		Hotel h=responseEntity.getBody();
		
		//USING FEIGN CLIENT
		Hotel h=hotelService.getHotel(rating.getHotelId());
			
			
		rating.setHotel(h);
		return rating;
			
		}).collect(Collectors.toList());
		
		
		u.setRatings(ratingList);
		return u;
	}

}

package com.sp.micro.user_s.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sp.micro.user_s.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	
	@PostMapping("/ratings")
	public Rating createRating(Rating newRating);
	
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId,Rating rating);
	
	@DeleteMapping("/ratings/{ratingId}")
	public Rating deleteRating(@PathVariable String ratingId);
}

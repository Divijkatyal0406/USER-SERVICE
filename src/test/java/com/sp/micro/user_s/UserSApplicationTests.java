package com.sp.micro.user_s;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.sp.micro.user_s.entities.Rating;
import com.sp.micro.user_s.external.services.RatingService;

@SpringBootTest
@Service
class UserSApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	RatingService ratingService;
	
	@Test
	void createTesting() {
		Rating r=Rating.builder().rating(10).hotelId("").userId("").remark("test feign").hotel(null).build();
		ratingService.createRating(r);
		System.out.println("New rating created");
	}

}

package com.sp.micro.user_s.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
	private String hotelId;
	private String ratingId;
	private String userId;
	private int rating;
	private String remark;
	
	private Hotel hotel;
}

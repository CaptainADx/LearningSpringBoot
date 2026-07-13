package com.CodingNinjas.LeaveXpress.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveDto {
	String type;
	String startDate;

	String endDate;

	String description;
}

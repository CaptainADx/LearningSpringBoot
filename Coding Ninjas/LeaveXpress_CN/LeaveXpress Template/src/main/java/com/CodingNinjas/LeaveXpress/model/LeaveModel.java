package com.CodingNinjas.LeaveXpress.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "leave_model")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String type;
	String startDate;

	String endDate;

	String description;

	boolean isAccepted;
}

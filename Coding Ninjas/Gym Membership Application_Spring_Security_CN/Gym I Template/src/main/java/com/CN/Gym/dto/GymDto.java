package com.CN.Gym.dto;



import com.CN.Gym.model.User;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GymDto {

    /* This is the Gym Dto class, and you need to complete the class by doing the following:
     a. Add the following attributes:
       1. String name
       2. String address
       3. Long contactNo
       4. String membershipPlans
       5. String facilities
       6. List<User> members = new ArrayList<>()
     b. Use lombok annotations for getter, setters and constructors
     */
	String name;
    String address;
    Long contactNo;
    String membershipPlans;
    String facilities;
    List<User> members = new ArrayList<>();

}

package com.CodingNinjas.TaxEase.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxRecordDto {

    /* This is the taxRecord Dto class, and you need to complete the class by doing the following:

     a. Add the following attributes:

        1. String userName
        2. String taxYear
        3. int Income
        4. int deductions

     b. Use lombok annotations for getter, setters and constructors
     */
	String userName;
	String taxYear;
	int income;
	int deductions;
	

}

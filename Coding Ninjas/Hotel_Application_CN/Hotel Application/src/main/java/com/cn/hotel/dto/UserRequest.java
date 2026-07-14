package com.cn.hotel.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	String username;
	String password;
}

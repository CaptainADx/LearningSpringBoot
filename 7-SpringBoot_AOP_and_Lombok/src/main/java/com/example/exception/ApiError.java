package com.example.exception;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiError {
	private String msg;
	private String errorCode;
}

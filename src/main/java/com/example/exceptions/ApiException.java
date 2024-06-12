package com.example.exceptions;

import com.example.enums.ErrorEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ApiException extends RuntimeException{

	 private ErrorEnum error;
     private String message;


}


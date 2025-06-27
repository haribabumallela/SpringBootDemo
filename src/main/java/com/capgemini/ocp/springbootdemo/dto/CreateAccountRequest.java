package com.capgemini.ocp.springbootdemo.dto;

import lombok.Data;

@Data
public class CreateAccountRequest {
	private String accountHolderName;
	private double initialBalance;
}
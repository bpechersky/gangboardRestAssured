package org.example.pojos.herokuapp;

import lombok.Data;

public @Data class UserResponse {
	private String firstName;
	private String lastName;
	private String password;
	private int userStatus;
	private String phone;
	private int id;
	private String email;
	private String username;
}
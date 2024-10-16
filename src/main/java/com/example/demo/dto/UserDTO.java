package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//유효성 검사 객체
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	@NotNull(message = "username은 null이면 안됩니다.")
	@NotBlank(message = "username은 반드시 입력하셔야 합니다.")
	@Size(min=3,max=20,message="username은 3~20글자로 입력해야 합니다.")
	private String username;
	
	@Size(min=4,max=100,message="password는 4~20글자로 입력해야 합니다.")

	private String password;
	
	@NotNull(message = "email은 null이면 안됩니다.")
	@NotBlank(message = "email은 반드시 입력하셔야 합니다.")
	@Email(message="email형식으로 입력하셔야 합니다.")
	private String email;
	
}

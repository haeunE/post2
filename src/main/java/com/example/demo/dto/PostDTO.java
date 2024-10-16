package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
	
	@NotNull(message="제목은 null이면 안됩니다.")
	@NotBlank(message="제목은 반드시 입력해야 합니다.")
	@Size(min=1,max=50,message="제목은 1~50자까지 가능합니다.")
	private String title;
	
	@NotNull(message="내용이 null이면 안됩니다.")
	@NotBlank(message="내용을 반드시 입력해야 합니다.")
	private String content;
}

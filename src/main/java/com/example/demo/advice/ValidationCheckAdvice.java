package com.example.demo.advice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.domain.ResponseDTO;

@Component //클래스 자체를 bean으로 등록
@Aspect
public class ValidationCheckAdvice {
	//예외 떠넘기기 
	//try-chatch : 해당 영역에서 발생된 예외를 처리함
	//throws: 예외를 떠넘기기
	//특정 메서드에 throw를 이용해 예외 발생시 메서드흫 호출한 곳에 예외값을 넘겨버림
	@Around("execution(* com.example..controller.*Controller.*(..))")
	public Object validationCheck(ProceedingJoinPoint jp) throws Throwable{
		Object[] args = jp.getArgs();
		for(Object arg :args) {
			if(arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				if(bindingResult.hasErrors()) {
					Map<String, String> errors = new HashMap<>();
					for(FieldError error:bindingResult.getFieldErrors()) {
						errors.put(error.getField(), error.getDefaultMessage());
					}
					return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),errors);
				}
			}
		}//반복문 끝
		return jp.proceed();
	}
}

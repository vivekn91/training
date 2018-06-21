package com.training.spring;
//class is managed by spring (cross-cutting concern)

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudienceAspect {
	@Pointcut("execution(* com.training.spring.Singer.perform(..))")
	private void pointCut(){}
	
	@Before("pointCut()")
	public void takeSeat(){
		System.out.println("Audience Takes respective seats");
	}
	
	@Before("pointCut()")
	public void WelcomeDrink(){
		System.out.println("Audience served WelcomeDrink");
	}
	@AfterReturning("pointCut()")
	public void claps(){
		System.out.println("Audience claps!....");
	}
}

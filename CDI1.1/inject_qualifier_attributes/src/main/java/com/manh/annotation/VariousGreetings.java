package com.manh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import com.manh.enm.GreetingType;
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.TYPE})
public @interface VariousGreetings 
{
	GreetingType type() default GreetingType.FORMAL;
	String name() default "formal";
}

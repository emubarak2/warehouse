package com.progressoft.warehouse.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is aspect class for calculating the time consumed by a method
 *
 * @author eyadm@amazon.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface LogMethodExecutionTime {
}

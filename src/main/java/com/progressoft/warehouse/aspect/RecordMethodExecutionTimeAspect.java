package com.progressoft.warehouse.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * this is the aspect class that calculate the time consumed by a mehtod to execute
 *
 * @author eyadm@amazon.com
 */
@Component
@Aspect
@Slf4j
public class RecordMethodExecutionTimeAspect {

    long startTime = 0L;
    long endTime = 0L;

    /**
     * this aspect method record the start time of the method before returning
     *
     * @throws Throwable
     */
    @Around(value = "@annotation(com.progressoft.warehouse.annotation.LogMethodExecutionTime)")
    public void logExecutionStartTIme(ProceedingJoinPoint jointPoint) throws Throwable {
        this.startTime = System.nanoTime();
        jointPoint.proceed();
        this.endTime = System.nanoTime();

        log.info("The method (" + jointPoint.getSignature().getName() + ") execution time in seconds was : " + Precision.round(((System.nanoTime() - startTime) / (double) 1000000000L), 4));
    }

}


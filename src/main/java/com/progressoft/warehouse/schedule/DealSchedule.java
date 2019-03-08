/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progressoft.warehouse.schedule;

import com.progressoft.warehouse.Service.DealService;
import com.progressoft.warehouse.annotation.LogMethodExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this schedule class for the running the Dolon service
 *
 * @author eyadm@amazon.com
 */
@Service
@Slf4j
public class DealSchedule {


    long startTime = 0L;
    @Autowired
    private DealService dealService;

    /**
     * this is cron method that run the recovery process for dolon method  each 8 hours
     */
//    @Scheduled(fixedDelay = 1 * 1 * 1000) // every 3 hours
    @LogMethodExecutionTime
    public void dealImportCron(String fileName) {
        long startT = System.nanoTime();
        this.startTime = System.nanoTime();


        dealService.importRecords(fileName);

        this.startTime = System.nanoTime();
        log.info("The method (dealImportCron) execution time in seconds was : " + Precision.round(((System.nanoTime() - startTime) / (double) 1000000000L), 2));
    }


}

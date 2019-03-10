package com.progressoft.warehouse.controller;

import com.progressoft.warehouse.Service.DealService;
import com.progressoft.warehouse.schedule.DealSchedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by EYAD on 3/7/2019.
 */
@RestController
@RequestMapping("/dealService")
@Slf4j
public class DealServiceControler {


    @Autowired
    DealService dealService;

    @Autowired
    private DealSchedule dealSchedule;

    @RequestMapping(path = "/start/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void dolonSyncSchedule(@RequestParam("fileName") String fileName) {
        try {
            dealService.importRecords(fileName);
        } catch (Exception e) { log.info(e.getMessage());
        }
    }
}

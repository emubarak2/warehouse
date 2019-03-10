//package com.progressoft.warehouse.config;
//
//import com.progressoft.warehouse.bean.CsvDealRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
///**
// * Created by EYAD on 3/9/2019.
// */
//
//@Component
//public class ValiatorFactory {
//
//    @Autowired
//    ApplicationContext applicationContext;
//
//    public CsvDealRecord.Validator getValidator(Class<? extends CsvDealRecord.Validator > validator){
//        return applicationContext.getBean(validator);
//
//    }
//
//}

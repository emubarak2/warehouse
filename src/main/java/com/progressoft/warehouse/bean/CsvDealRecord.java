package com.progressoft.warehouse.bean;

import com.progressoft.warehouse.entity.Violation;
import com.univocity.parsers.annotations.LowerCase;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EYAD on 3/7/2019.
 */
@Data
public class CsvDealRecord {

    public Long fileIndex;

    @Trim
    @LowerCase
    @Parsed(index = 0)
    private String fromCurrency;

    @Trim
    @LowerCase
    @Parsed(index = 1)
    private String toCurrency;

    @Trim
    @LowerCase
    @Parsed(index = 2)
    private String timeStamp;

//    @Validate(DoubleValidator.class)
    @Trim
    @LowerCase
    @Parsed(index = 3)
    private String amount;

    private List<Violation> violationsList = new ArrayList<>();
    private long fileId;


//    public @interface Validate {
//        Class<? extends Validator> value();
//    }
//
//    public interface  Validator {
//
//        public boolean isValid(String value);
//    }
//
//    @Component
//    public class DoubleValidator implements Validator{
//
//
//
//        @Override
//        public boolean isValid(String value) {
//            if(value == null || value.isEmpty()) {
//                return false;
//            }
//            try {
//                Double.parseDouble(value);
//            }catch(NumberFormatException e){
//                return false;
//            }
//            return  true;
//        }
//    }





}
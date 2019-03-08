package com.progressoft.warehouse.utility;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by EYAD on 3/8/2019.
 */
@Slf4j
public class DateUtility {

    public static String stringToDate(String dateString) {
//2008-07-07 00:00:00
        try {

            Date date = new SimpleDateFormat("dd/MM/yyyy HH:MM").parse(dateString);
            String dateS = new SimpleDateFormat("yyyy-mm-dd HH:MM").format(date);
            return dateS;
        } catch (ParseException e) {
            log.info(e.getMessage());
        }
        return null;
    }

}

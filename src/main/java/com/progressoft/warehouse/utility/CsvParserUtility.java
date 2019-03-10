package com.progressoft.warehouse.utility;

import com.progressoft.warehouse.bean.CsvDealRecord;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;

import java.io.Reader;
import java.util.List;

/**
 * Created by EYAD on 3/7/2019.
 */
@Slf4j
public class CsvParserUtility {


    public static List<CsvDealRecord> getDealsRecordsFromFile(String fileName, String lineSeparator) {
        long start2 = System.nanoTime();

        BeanListProcessor<CsvDealRecord> rowProcessor = new BeanListProcessor<>(CsvDealRecord.class);
        Reader inputStreamReader = FileUtility.getFileInputStreamByName(fileName);
        CsvParserSettings settings = new CsvParserSettings();
        settings.setRowProcessor(rowProcessor);
        settings.getFormat().setLineSeparator(lineSeparator);
        CsvParser csvParser = new CsvParser(settings);
        csvParser.parse(inputStreamReader);
        List<CsvDealRecord> csvDealRecords = rowProcessor.getBeans();

        System.out.println(
                "getDealsRecordsFromFile took  : " +
                        Precision.round((System.nanoTime() - start2) / 1000000000L, 6));

        return csvDealRecords;
    }


}

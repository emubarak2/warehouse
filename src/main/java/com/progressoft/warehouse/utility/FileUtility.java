package com.progressoft.warehouse.utility;

import lombok.extern.java.Log;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by EYAD on 2/18/2019.
 */
@Log
public class FileUtility {

    public static List<File> getFiles() {
        List<File> transactionFiles;
        File folder = new File(System.getProperty("user.dir") + "/files");
        File[] listOfFiles = folder.listFiles();
        transactionFiles = Arrays.asList(listOfFiles);
        return transactionFiles;
    }


    public static Reader getFileInputStreamByName(String fileName) {

        File file = new File(System.getProperty("user.dir") + "/files/" + fileName);
        try {
            return new InputStreamReader(new FileInputStream(file), "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            log.info(e.getMessage());
        }
        return null;//TODO: throw exception
    }

}

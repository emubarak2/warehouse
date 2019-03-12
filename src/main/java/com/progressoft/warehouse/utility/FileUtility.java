package com.progressoft.warehouse.utility;

import lombok.extern.java.Log;
import org.springframework.web.multipart.MultipartFile;

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

    public static File convertMultiToFile(MultipartFile file)
    {
        File convFile = new File(file.getOriginalFilename());

        try {
            convFile.createNewFile();
            FileOutputStream fos = null;
            fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
        } catch ( IOException e) {
            e.printStackTrace();
             return null;
        }

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

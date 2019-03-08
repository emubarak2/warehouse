package com.progressoft.warehouse.Service;

import com.progressoft.warehouse.repository.FileRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by EYAD on 3/6/2019.
 */
@Service
public class FileService {

    @Autowired
    FileRecordRepository fileRecordRepository;

    public long validateFileNotImported(String fileName) {
        if (fileRecordRepository.getFileRecordByFileName(fileName) != null) {
            return -1;
        } else {
            fileRecordRepository.addFileName(fileName);
            return fileRecordRepository.getMaxFileId();
        }
    }

}

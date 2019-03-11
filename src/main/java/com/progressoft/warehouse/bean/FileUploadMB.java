package com.progressoft.warehouse.bean;

import com.progressoft.warehouse.exception.FileExitsException;
import com.progressoft.warehouse.Service.DealService;
import com.progressoft.warehouse.Service.FileService;
import com.progressoft.warehouse.entity.Violation;
import com.progressoft.warehouse.utility.ReportUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by EYAD on 3/10/2019.
 */
//@SessionScoped
//@Component("fileUploadMB")
//@ManagedBean("fileUploadMB")
@Named
@ViewScoped
@Data
public class FileUploadMB implements Serializable {
    private boolean useFlash = true;
    FileUploadMB(){
        System.out.println("in FileUploadMB constructor");
    }
    private List<Violation> violationList = new ArrayList();
    private String fileName = new String();
    private InputStream uploadedFileStream;

    public String getFileName() {
        return fileName;
    }
    public void fileUploadAction(FileUploadEvent event) throws IOException {
        UploadedFile uploadedFile = event.getFile();

        try {
            this.uploadedFileStream = uploadedFile.getInputstream();
            this.fileName = "Uploaded Sheet: " + uploadedFile.getFileName();
        } catch (IOException e) {

        }

    }

    public UploadedFile file;
    private boolean uploadHasErrors;
    private int uploadErrorsCount = 0;

    @Autowired
    private FileService fileService;
    private FileUpload fileUpload;

    @Autowired
    private DealService dealService;


    public UploadedFile upload;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }


    public UploadedFile getUpload() {
        return upload;
    }



    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }


    public void upload(FileUploadEvent event) {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public void processFile() {
//         List<Violation> violationList = new ArrayList();
//         String fileName;
//         InputStream uploadedFileStream;
//        UploadedFile upf = event.getFile();
        try {
//           fileName = event.getFile().getFileName();
//            uploadedFileStream = upf.getInputstream();
            fileName = this.file.getFileName();
            long fileIndex = fileService.getNextFileId(fileName);
//            violationList = dealService.importRecords(new InputStreamReader(uploadedFileStream), fileIndex);
            violationList = dealService.importRecords(new InputStreamReader(file.getInputstream()), fileIndex);
            generateReport(violationList);
//            processFile();
        } catch (IOException | FileExitsException ex) {
            Logger.getLogger(FileUploadMB.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

//    public FileUploadMB() {
//        this.fileName = this.file.getFileName();
//    }

//    public void processFile() throws FileExitsException {
//
//        try {
//            long fileIndex = fileService.getNextFileId(fileName);
//            violationList = dealService.importRecords(new InputStreamReader(uploadedFileStream), fileIndex);
//            generateReport(violationList);
//        } catch (FileExitsException ex) {
//
//            Logger.getLogger(FileUploadMB.class.getName()).log(Level.SEVERE, violationList.toString(), ex);
//        }
//
//    }

    public void generateReport(List<Violation> violationList) {
        if (violationList != null && violationList.size() > 0) {
            String violationString = violationList.toString();
            ReportUtil.showMessage(FacesMessage.SEVERITY_INFO, "Invalid Record", violationString);
        }
    }

}

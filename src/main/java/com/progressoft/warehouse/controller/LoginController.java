package com.progressoft.warehouse.controller;


import com.google.protobuf.ServiceException;
import com.progressoft.warehouse.Service.DealService;
import com.progressoft.warehouse.Service.FileService;
import com.progressoft.warehouse.bean.CsvDealRecord;
import com.progressoft.warehouse.bean.FileUploadMB;
import com.progressoft.warehouse.exception.FileExitsException;
import com.progressoft.warehouse.utility.FileUtility;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by EYAD on 3/10/2019.
 */
@Controller()
@RequestMapping("/dealService")
@RequestScope
public class LoginController {

    private static String UPLOADED_FOLDER = System.
            getProperty("HOME");

    @Autowired
    DealService dealService;
    @Autowired
    FileService fileService;
//
//    @Autowired
//    TemplateResolver templateResolver;
//
//    //    @RequestMapping(path = "/req/", method = RequestMethod.GET)
//    @GetMapping("/")
//    public String requestPage() {
//        return "upload";
//    }
//
//
//    @PostMapping(path = "/upload")
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }
//
//        List<CsvDealRecord> dealRecords = new ArrayList();
//        try {
//
//            long start2 = System.nanoTime();
//
//            String fileName = file.getName();
//            long fileIndex = fileService.getNextFileId(fileName);
//            dealRecords = dealService.importRecords(new InputStreamReader(new FileInputStream(FileUtility.convertMultiToFile(file))), fileIndex);
//            long invalidRecords = dealService.getViolationRecords(dealRecords).size();
//            long validrecords = dealRecords.size() - invalidRecords;
//            float timeConsumed = Precision.round((System.nanoTime() - start2) / 1000000000L, 6);
//            redirectAttributes.addFlashAttribute("message",
//                    "Your sheet has been imported successfully  '" + file.getOriginalFilename() + " \n" +
//                            "And the  following files has been imported : " + "<br> importing time was : " + timeConsumed +
//                            "\n number of valid records was : " + validrecords +
//                            "\n number of invalid records was : " + invalidRecords);
//            Context context = new Context();
//            htmlContext = templateResolver.emailTemplateEngine().process("email/metrics-email-competitorServers", context);
//
//            return "redirect:/uploadStatus";
//        } catch (IOException | FileExitsException ex) {
//
//            ex.printStackTrace();
//            Logger.getLogger(FileUploadMB.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            redirectAttributes.addFlashAttribute("message", "Your uploaded sheet is already imported  '" + file.getOriginalFilename());
//            return "redirect:/uploadStatus";
//        }
//
//}

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }


    @RequestMapping(path = "/ean/", method = RequestMethod.GET)
    public String loginPage(String error) {
        return "/FileUpload.xhtml";
    }

    @RequestMapping(path = "/login1/", method = RequestMethod.GET)
    public String query(String error) {
        return "/login.xhtml";
    }


    @RequestMapping(path = "/upload/", method = RequestMethod.GET)
    public String upload(String error) {
        return "/eanUpload.xhtml";
    }


    @RequestMapping(path = "/uploadForm/", method = RequestMethod.GET)
    public String getFile(String error) {
        return "uploadForm";
    }

    @RequestMapping(path = "/uploadForm/handelUpload/", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @RequestMapping(value = "/uploadForm2", method = RequestMethod.POST)
    public String uploadForm1(
            @ModelAttribute("admin")
                    BindingResult result,
            Principal principal,
            HttpSession session) throws ServiceException, IllegalStateException, IOException {
        //do file save here
        return "some-view-name";
    }


}

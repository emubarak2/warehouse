package com.progressoft.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created by EYAD on 3/10/2019.
 */
@Controller()
@RequestMapping("/dealService")
@RequestScope
public class LoginController {

    @RequestMapping(path = "/ean/", method = RequestMethod.GET)
    public String loginPage(String error)
    {
        return "/FileUpload.xhtml";
    }

        @RequestMapping(path = "/login1/", method = RequestMethod.GET)
        public String query(String error)
        {
            return "/login.xhtml";
        }


    @RequestMapping(path = "/upload/", method = RequestMethod.GET)
    public String upload(String error)
    {
        return "/eanUpload.xhtml";
    }

}

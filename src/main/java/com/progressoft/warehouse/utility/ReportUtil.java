package com.progressoft.warehouse.utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by EYAD on 3/11/2019.
 */
public class ReportUtil {

    public static void showMessage(FacesMessage.Severity severity, String head, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, head, message));

    }
}

/*
 * Copyright 2017 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.progressoft.warehouse.bean;


import lombok.Data;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author absaleh
 */
@Named()
@javax.enterprise.context.SessionScoped
@Data
public class EanUploadMB implements Serializable {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(EanUploadMB.class);
    private int skipFirstRows = 1;
    private int eanColumnIndex = 0;
    private int titleColumnIndex = 1;
    private int categoryColumnIndex = 2;

    private int noonUaeSkuColumnIndex = 3;
    private int wadiUaeSkucolumnIndex = 4;
    private int carrefourUaeSkuColumnIndex = 5;
    private int sharafdgUaeSkuColumnIndex = 6;

    private int jarirKsaSkuColumnIndex = 7;
    private int extraStoresKsaSkuColumnIndex = 8;
    private int wadiKsaSkucolumnIndex = 9;
    private int noonKsaSkuColumnIndex = 10;

    private int jumiaSkuColumnIndex = 11;
    private int carrefouregyptSkuColumnIndex = 12;
    private int mumworldUaeSkuColumnIndex = 13;
    private int jollychicUaeSkuColumnIndex = 14;
    private int jollychicKsaSkuColumnIndex = 15;

    private boolean setAsValidated = true;


    private boolean uploadHasErrors;
    private int uploadErrorsCount = 0;

    private InputStream uploadedFileStream;
    private String fileName;


    public void upload(FileUploadEvent event) {
        UploadedFile upf = event.getFile();
        try {
            this.uploadedFileStream = upf.getInputstream();
            fileName = upf.getFileName();
        } catch (IOException ex) {
            Logger.getLogger(EanUploadMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}

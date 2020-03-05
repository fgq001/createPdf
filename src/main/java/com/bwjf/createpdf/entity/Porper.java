package com.bwjf.createpdf.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value={"classpath:application.properties"})

public class Porper {

    @Value("${crm.fpPdfPath}")
    private String fpPdfPath;

    @Value("${crm.fpImgPath}")
    private String fpImgPath;

    public String getFpImgPath() {
        return fpImgPath;
    }

    public void setFpImgPath(String fpImgPath) {
        this.fpImgPath = fpImgPath;
    }

    public String getFpPdfPath() {
        return fpPdfPath;
    }

    public void setFpPdfPath(String fpPdfPath) {
        this.fpPdfPath = fpPdfPath;
    }
}

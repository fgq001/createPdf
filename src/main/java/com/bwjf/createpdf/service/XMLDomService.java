package com.bwjf.createpdf.service;

import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public interface XMLDomService {

    void XmlJx(String xmlContent, Xxfp xxfp, List<Xxfpmx> xxfpmxList) throws IOException, DocumentException;
}

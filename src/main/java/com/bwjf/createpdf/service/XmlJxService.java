package com.bwjf.createpdf.service;

import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2019/7/19.
 */
public interface XmlJxService {
    void XmlJx(String xmlContent, String tmpPath, String temPath, String endPath, Xxfp xxfp, List<Xxfpmx> xxfpmxList, String pfx, String gif, String password) throws IOException, DocumentException;
}

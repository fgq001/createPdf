package com.bwjf.createpdf.service;

import com.bwjf.createpdf.entity.KpCacersubInfo;
import com.bwjf.createpdf.entity.TcrmPdftemplateBean;
import com.bwjf.createpdf.entity.Xxfp;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2019/7/22.
 */
public interface GetPathService {

    Map<String, Object> getPfxPath(String xhdwsbh);

    Map<String, Object> getGifPath1(String xhdwsbh);

    Map<String, Object> getTemPath(String xhdwsbh);

    Xxfp getFpqqlsh(String fphm);
}

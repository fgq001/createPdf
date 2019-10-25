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

    //获取签名
    Map<String, Object> getPfxPath(String xhdwsbh);
    //获取印章
    Map<String, Object> getGifPath1(String xhdwsbh);
    //获取模板PDF
    Map<String, Object> getTemPath(String xhdwsbh);
    //获取发票流水号 作为保存文件名
    Xxfp getFpqqlsh(String fphm);
}

package com.bwjf.createpdf.dao;

import com.bwjf.createpdf.entity.KpCacersubInfo;
import com.bwjf.createpdf.entity.TcrmPdftemplateBean;
import com.bwjf.createpdf.entity.Xxfp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by admin on 2019/7/22.
 */
@Mapper
public interface GetPathDao {

    List<KpCacersubInfo> getPfxPath(String xhdwsbh);

    KpCacersubInfo getGifPath(String xhdwsbh);

    TcrmPdftemplateBean getTemPath(String xhdwsbh);

    Xxfp getFpqqlsh(String fphm);
}

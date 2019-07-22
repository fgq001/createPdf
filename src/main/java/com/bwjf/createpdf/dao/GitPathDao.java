package com.bwjf.createpdf.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by admin on 2019/7/22.
 */
@Mapper
public interface GitPathDao {

    String getPfxPath(String xhdwsbh);
    String getGifPath(String xhdwsbh);
    String getTmpPath(String xhdwsbh);


}

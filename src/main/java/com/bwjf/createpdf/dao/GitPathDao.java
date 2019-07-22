package com.bwjf.createpdf.dao;

import com.bwjf.createpdf.entity.KpCacersubInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by admin on 2019/7/22.
 */
@Mapper
public interface GitPathDao {

    KpCacersubInfo getPfxPath(String xhdwsbh);



}

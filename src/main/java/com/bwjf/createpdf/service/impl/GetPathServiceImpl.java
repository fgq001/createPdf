package com.bwjf.createpdf.service.impl;

import com.bwjf.createpdf.dao.GitPathDao;
import com.bwjf.createpdf.entity.KpCacersubInfo;
import com.bwjf.createpdf.service.GetPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/7/22.
 */
@Service("getPathService")
public class GetPathServiceImpl implements GetPathService {
    @Autowired
    private GitPathDao gitPathDao;


    @Override
    public KpCacersubInfo getPfxPath1(String xhdwsbh) {

        return gitPathDao.getPfxPath(xhdwsbh);
    }

}

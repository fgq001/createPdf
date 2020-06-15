package com.bwjf.createpdf.service.impl;


import com.bwjf.createpdf.dao.BwjfKpOutsideInteFyxmDao;
import com.bwjf.createpdf.entity.BwjfKpOutsideInteFyxmBean;
import com.bwjf.createpdf.service.BwjfKpOutsideInteFyxmService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("BwjfKpOutsideInteFyxmService")
@Transactional
public class BwjfKpOutsideInteFyxmServiceImpl implements BwjfKpOutsideInteFyxmService {

	@Resource
    private BwjfKpOutsideInteFyxmDao KpOutsideInteFyxmDao;


    @Override
    public int insertKpFYXMInfo(BwjfKpOutsideInteFyxmBean kpOutsideInteFyxmBean) {
        return KpOutsideInteFyxmDao.insertKpFYXMInfo(kpOutsideInteFyxmBean);
    }

    @Override
    public List<BwjfKpOutsideInteFyxmBean> getkpFyxmInfoByKoibId(BwjfKpOutsideInteFyxmBean kpOutsideInteFyxmBean) {
        return KpOutsideInteFyxmDao.getkpFyxmInfoByKoibId(kpOutsideInteFyxmBean);
    }

    @Override
    public int insertKpFYXMInfoList(List<BwjfKpOutsideInteFyxmBean> kpOutsideInteFyxmBean) {
        return KpOutsideInteFyxmDao.insertKpFYXMInfoList(kpOutsideInteFyxmBean);
    }
}

package com.bwjf.createpdf.service.impl;

import com.bwjf.createpdf.dao.KpOutsideInteBaseinfoDao;
import com.bwjf.createpdf.entity.KpOutsideInteBaseinfo;
import com.bwjf.createpdf.service.KpOutsideInteBaseinfoService;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//import xin.cymall.dao.BwjfKpResultInfoDao;
//import xin.cymall.dao.KpOutsideInteBaseinfoDao;
//import xin.cymall.entity.BwjfKpResultInfoBean;
//import xin.cymall.entity.EchartsBean;
//import xin.cymall.entity.KpOutsideInteBaseinfo;
//import xin.cymall.service.KpOutsideInteBaseinfoService;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.util.*;


@Service("kpOutsideInteBaseinfoService")
@Transactional
public class KpOutsideInteBaseinfoServiceImpl implements KpOutsideInteBaseinfoService {
    @Resource
    private KpOutsideInteBaseinfoDao kpOutsideInteBaseinfoDao;

    @Override
    public KpOutsideInteBaseinfo get(String id) {
        return kpOutsideInteBaseinfoDao.get(id);
    }

    @Override
    public List<KpOutsideInteBaseinfo> getList(Map<String, Object> map) {
        return kpOutsideInteBaseinfoDao.getList(map);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return kpOutsideInteBaseinfoDao.getCount(map);
    }

    @Override
    public void save(KpOutsideInteBaseinfo kpOutsideInteBaseinfo) {

        kpOutsideInteBaseinfoDao.save(kpOutsideInteBaseinfo);
    }

    @Override
    public void update(KpOutsideInteBaseinfo kpOutsideInteBaseinfo) {

        kpOutsideInteBaseinfoDao.update(kpOutsideInteBaseinfo);
    }

    @Override
    public void delete(String id) {
        kpOutsideInteBaseinfoDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        kpOutsideInteBaseinfoDao.deleteBatch(ids);
    }

    @Override
    public void updateState(String[] ids, String stateValue) {
        for (String id : ids) {
            KpOutsideInteBaseinfo kpOutsideInteBaseinfo = get(id);
            update(kpOutsideInteBaseinfo);
        }
    }


    @Override
    public KpOutsideInteBaseinfo getKpBaseInfoById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo) {
        return kpOutsideInteBaseinfoDao.getKpBaseInfoById(kpOutsideInteBaseinfo);
    }

    @Override
    public KpOutsideInteBaseinfo getKpPDFInfoById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo) {
        return kpOutsideInteBaseinfoDao.getPdfInfoById(kpOutsideInteBaseinfo);
    }

    @Override
    public List<KpOutsideInteBaseinfo> getInvoiceInfoByVnuitedcode(Map<String, Object> map) {
        return kpOutsideInteBaseinfoDao.getInvoiceInfoByVnuitedcode(map);
    }

    @Override
    public int getInvoiceCountByVnuitedcode(Map<String, Object> map) {
        return kpOutsideInteBaseinfoDao.getInvoiceCountByVnuitedcode(map);
    }

    @Override
    public List<KpOutsideInteBaseinfo> get7DayskpCount(KpOutsideInteBaseinfo kpOutsideInteBaseinfo) {
        return kpOutsideInteBaseinfoDao.get7DayskpCount(kpOutsideInteBaseinfo);
    }

    @Override
    public List<KpOutsideInteBaseinfo> getfpLxCount(KpOutsideInteBaseinfo kpOutsideInteBaseinfo) {
        return kpOutsideInteBaseinfoDao.getfpLxCount(kpOutsideInteBaseinfo);
    }

    @Override
    public List<KpOutsideInteBaseinfo> getInvoiceById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo) {
        return kpOutsideInteBaseinfoDao.getInvoiceById(kpOutsideInteBaseinfo);
    }


    /**
     * 修改发票相关状态
     * @param baseInfo
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.SERIALIZABLE)
    public int updateStatusById(KpOutsideInteBaseinfo baseInfo) {
        return kpOutsideInteBaseinfoDao.updateStatusById(baseInfo);
    }

    /**
     * 根据原发票号码和代码获取发票信息
     * @param baseInfo
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public List<KpOutsideInteBaseinfo> getBaseInfoByYfpdmAndhm(KpOutsideInteBaseinfo baseInfo) {
        return kpOutsideInteBaseinfoDao.getBaseInfoByYfpdmAndhm(baseInfo);
    }


}

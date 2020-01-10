package com.bwjf.createpdf.service.impl;

import com.bwjf.createpdf.dao.IcaCertpathDao;
import com.bwjf.createpdf.entity.KpOutsideInteBaseinfo;
import com.bwjf.createpdf.service.TestServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("TestServer")
@Transactional
public class TestServerImpl implements TestServer {
    @Resource
    private IcaCertpathDao certpathDao;

    @Override
    public List<String> countBig() {
        return certpathDao.countBig();
    }

    @Override
    public int queryNumber(String sbh) {
        return certpathDao.queryNumber(sbh);
    }

    @Override
    public List<KpOutsideInteBaseinfo> kpList(String sbh) {
        return certpathDao.kpList(sbh);
    }

    @Override
    public void updataFpqqlsh(KpOutsideInteBaseinfo baseinfo) {
        certpathDao.updataFpqqlsh(baseinfo);
    }
}

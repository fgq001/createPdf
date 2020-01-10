package com.bwjf.createpdf.service.impl;


//import com.bwjf.fp365.dao.KpFileInfoDao;
//import com.bwjf.fp365.entity.KpFileInfo;
//import com.bwjf.fp365.service.KpFileInfoService;
import com.bwjf.createpdf.dao.KpFileInfoDao;
import com.bwjf.createpdf.entity.BackupBwjfKpOutsideInteBaseInfoBean;
import com.bwjf.createpdf.entity.KpFileInfo;
import com.bwjf.createpdf.service.KpFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("KpFileInfoService")
@Transactional
public class KpFileInfoServiceImpl implements KpFileInfoService {
	@Autowired
	private KpFileInfoDao kpFileInfoDao;


	@Override
	public KpFileInfo kpFileInfo(String koibId) {
		return kpFileInfoDao.getFileInfoById(koibId);
	}

	@Override
	public List<KpFileInfo> kpFileInfoAll(int limNum) {
		return kpFileInfoDao.getFileInfoAll(limNum);
	}

	@Override
	public int saveBackupBaseInfo(BackupBwjfKpOutsideInteBaseInfoBean baseInfoBean) {
		return kpFileInfoDao.saveBackupBaseInfo(baseInfoBean);
	}
}

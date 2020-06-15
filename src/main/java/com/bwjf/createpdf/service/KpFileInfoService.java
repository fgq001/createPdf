package com.bwjf.createpdf.service;

import com.bwjf.createpdf.entity.BackupBwjfKpOutsideInteBaseInfoBean;
import com.bwjf.createpdf.entity.KpCustomerInfo;
import com.bwjf.createpdf.entity.KpFileInfo;

import java.util.List;

/**
 * 电票文件信息相关表
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-06-27 09:06:07
 */
public interface KpFileInfoService {
	
	KpFileInfo kpFileInfo(String koibId);

	List<KpFileInfo> kpFileInfoAll(int limNum);


	//解析PDF 拿到需要的值  保存到新发票表里面
	int saveBackupBaseInfo(BackupBwjfKpOutsideInteBaseInfoBean baseInfoBean);

	//解析PDF 拿到需要的值  保存到新客户表里面
	int saveBackupCustInfo(KpCustomerInfo customerInfo);

	//查询所有乱码的数据
	List<KpFileInfo> kpFileInfoErrorAll(int limNum);
}

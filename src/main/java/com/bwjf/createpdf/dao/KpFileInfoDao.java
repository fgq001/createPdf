package com.bwjf.createpdf.dao;

import com.bwjf.createpdf.entity.BackupBwjfKpOutsideInteBaseInfoBean;
import com.bwjf.createpdf.entity.KpCustomerInfo;
import com.bwjf.createpdf.entity.KpFileInfo;
import com.bwjf.createpdf.test.BwjfKpFileBean;
import org.apache.ibatis.annotations.Mapper;
//import com.bwjf.fp365.entity.BwjfKpFileBean;
//import com.bwjf.fp365.entity.KpFileInfo;

import java.util.List;

/**
 * 电票文件信息相关表
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-06-27 09:06:07
 */
@Mapper
public interface KpFileInfoDao {
    KpFileInfo getFileInfoById(String koibID);


   //保存文件
    int insertFileInfo(BwjfKpFileBean bwjfKpFileBean);

    //根据主表ID获取pdf
      BwjfKpFileBean getFileByKoibId(String koibId);

    //修改文件表文件的状态，作废掉
    int updateFileStatus(BwjfKpFileBean bwjfKpFileBean);


    //根据发票ID判断是否生成发票图片
    int getFileNumber(String koibId);

    //根据发票请求流水号和取票码获取发票PDF相关信息
//    List<BwjfKpFileBean> getBaseFileInfoByFpqqlshAndQpm(BwjfKpFileBean bwjfKpFileBean);

    List<KpFileInfo> getFileInfoAll(int limNum);

    //解析PDF 拿到需要的值  保存到新发票表里面
    int saveBackupBaseInfo(BackupBwjfKpOutsideInteBaseInfoBean baseInfoBean);

    //解析PDF 拿到需要的值  保存到新客户表里面
    int saveBackupCustInfo(KpCustomerInfo customerInfo);

    //查询所有乱码的数据
    List<KpFileInfo> kpFileInfoErrorAll(int limNum);
}

package com.bwjf.createpdf.dao;


import com.bwjf.createpdf.entity.KpOutsideInteBaseinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author cuilaoban
 * @email 799106876@qq.com
 * @date 2019-04-19 11:13:07
 */

@Mapper
public interface KpOutsideInteBaseinfoDao extends BaseDao<KpOutsideInteBaseinfo> {


	KpOutsideInteBaseinfo getKpBaseInfoById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

	KpOutsideInteBaseinfo getPdfInfoById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

	List<KpOutsideInteBaseinfo> getInvoiceInfoByVnuitedcode(Map<String, Object> map);

	int getInvoiceCountByVnuitedcode(Map<String, Object> map);

	//获取7天中，每天的开票数量
	List<KpOutsideInteBaseinfo> get7DayskpCount(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);
	//获取各种类型的发票开票数量
	List<KpOutsideInteBaseinfo> getfpLxCount(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);
	//根据发票ID获取发票信息
	List<KpOutsideInteBaseinfo> getInvoiceById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

	//根据请求流水号修改发票信息
	int updateKpBaseInfoByFpqqlsh(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);
	//根据发票请求的流水号获取发票信息
	List<KpOutsideInteBaseinfo> getBaseInfoByFpqqlsh(KpOutsideInteBaseinfo baseInfo);
	//根据发票Id修改发票开具的状态
	int updateStatusById(KpOutsideInteBaseinfo baseInfo);
	//根据原发票号码和代码获取发票信息
	List<KpOutsideInteBaseinfo> getBaseInfoByYfpdmAndhm(KpOutsideInteBaseinfo baseInfo);




}

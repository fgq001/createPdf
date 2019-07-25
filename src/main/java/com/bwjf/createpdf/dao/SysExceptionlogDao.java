package com.bwjf.createpdf.dao;


import com.bwjf.createpdf.entity.SysExceptionlog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zht
 * @email 437401261@qq.com
 * @date 2019-05-17 09:40:01
 */
/*@Component
@Repository("sysExceptionlogDao")*/
@Mapper
public interface SysExceptionlogDao {
	
	int saveExceptionLogInfo(SysExceptionlog sysExceptionlog);
	
	
}

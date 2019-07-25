package com.bwjf.createpdf.dao;


import com.bwjf.createpdf.entity.BwjfKpOutsideInteMailinfoBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮箱推送信息表
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-07-02 14:51:24
 */
/*@Component
@Repository("kpOutsideInteMailinfoDao")*/
@Mapper
public interface BwjfKpOutsideInteMailinfoDao {

    /**
     * 保存邮箱推送信息
     * @param bwjfKpOutsideInteMailinfoBean
     * @return
     */
    public int saveMailInfo(BwjfKpOutsideInteMailinfoBean bwjfKpOutsideInteMailinfoBean);

}

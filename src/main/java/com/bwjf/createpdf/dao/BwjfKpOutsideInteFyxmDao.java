package com.bwjf.createpdf.dao;


import com.bwjf.createpdf.entity.BwjfKpOutsideInteFyxmBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BwjfKpOutsideInteFyxmDao {

	/**
     * 新增信息
     * @param kpOutsideInteFyxmBean
     * @return
     */
    public int insertKpFYXMInfo(BwjfKpOutsideInteFyxmBean kpOutsideInteFyxmBean);

    /**
     * 批量新增商品信息
     * @param kpOutsideInteFyxmBean
     * @return
     */
    public int insertKpFYXMInfoList(List<BwjfKpOutsideInteFyxmBean> kpOutsideInteFyxmBean);


    /**
     * 根据发票id 获取发票商品相关信息
     * @param kpOutsideInteFyxmBean
     * @return
     */
    public List<BwjfKpOutsideInteFyxmBean> getkpFyxmInfoByKoibId(BwjfKpOutsideInteFyxmBean kpOutsideInteFyxmBean);


}

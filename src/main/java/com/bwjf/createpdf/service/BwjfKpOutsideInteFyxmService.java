package com.bwjf.createpdf.service;



import com.bwjf.createpdf.entity.BwjfKpOutsideInteFyxmBean;

import java.util.List;


public interface BwjfKpOutsideInteFyxmService {

	/**
     * 新增信息
     * @param
     * @return
     */
    public int insertKpFYXMInfo(BwjfKpOutsideInteFyxmBean kpOutsideInteFyxmBean);

    /**
     * 根据发票id 获取发票商品相关信息
     * @param kpOutsideInteFyxmBean
     * @return
     */
    public List<BwjfKpOutsideInteFyxmBean> getkpFyxmInfoByKoibId(BwjfKpOutsideInteFyxmBean kpOutsideInteFyxmBean);

    /**
     * 新增商品信息信息
     * @param kpOutsideInteFyxmBean
     * @return
     */
    public int insertKpFYXMInfoList(List<BwjfKpOutsideInteFyxmBean> kpOutsideInteFyxmBean);

}

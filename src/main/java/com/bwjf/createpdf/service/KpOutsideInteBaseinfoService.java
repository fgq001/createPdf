package com.bwjf.createpdf.service;


import com.bwjf.createpdf.entity.KpOutsideInteBaseinfo;

import java.util.List;
import java.util.Map;

/**
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-04-19 11:13:07
 */
public interface KpOutsideInteBaseinfoService {

    KpOutsideInteBaseinfo get(String id);

    List<KpOutsideInteBaseinfo> getList(Map<String, Object> map);

    int getCount(Map<String, Object> map);

    void save(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

    void update(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

    void delete(String id);

    void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);

    KpOutsideInteBaseinfo getKpBaseInfoById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

    KpOutsideInteBaseinfo getKpPDFInfoById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

    List<KpOutsideInteBaseinfo> getInvoiceInfoByVnuitedcode(Map<String, Object> map);

    int getInvoiceCountByVnuitedcode(Map<String, Object> map);

    List<KpOutsideInteBaseinfo> get7DayskpCount(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

    List<KpOutsideInteBaseinfo> getfpLxCount(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);

    //根据发票ID获取发票信息
    List<KpOutsideInteBaseinfo> getInvoiceById(KpOutsideInteBaseinfo kpOutsideInteBaseinfo);


    //根据发票Id修改发票开具的状态
    int updateStatusById(KpOutsideInteBaseinfo baseInfo);

    //根据原发票号码和代码获取发票信息
    List<KpOutsideInteBaseinfo> getBaseInfoByYfpdmAndhm(KpOutsideInteBaseinfo baseInfo);
}

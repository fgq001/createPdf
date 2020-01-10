package com.bwjf.createpdf.dao;

import com.bwjf.createpdf.entity.KpOutsideInteBaseinfo;
import com.bwjf.createpdf.entity.TcaCertpathBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 证书路径Dao
 */
@Mapper
public interface IcaCertpathDao {


    /**
     *  查询count>1的记录，通过流水号去查询AB两条发票信息
     * @return
     */
    List<String> countBig();

    /**
     *  查询是否有重复的流水号
     * @param sbh   流水号
     * @return
     */
    int queryNumber(String sbh);

    /**
     *    根据 流水号查询 开票信息
     * @param sbh
     * @return
     */
    List<KpOutsideInteBaseinfo> kpList(String sbh);

    /**
     *  根据新的流水号  修改原来的流水号
     * @param baseinfo
     * @return
     */
    void updataFpqqlsh(KpOutsideInteBaseinfo baseinfo);
}

package com.bwjf.createpdf.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019年3月18日 上午9:31:36
 */
@Mapper
public interface BaseDao<T> {
	
	void save(T t);
	
	void save(Map<String, Object> map);
	
	void saveBatch(List<T> list);
	
	int update(T t);
	
	int update(Map<String, Object> map);
	
	int delete(Object id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);

	T queryObject(Object id);

	T get(Object id);
	
	List<T> queryList(Map<String, Object> map);

	List<T> getListAdmin(Map<String, Object> map);

	List<T> getList(Map<String, Object> map);

	List<T> getListOn(Map<String, Object> map);

	List<T> queryList(Object id);
	
	int queryTotal(Map<String, Object> map);

	int getCount(Map<String, Object> map);

	int getCounton(Map<String, Object> map);

	int getCountAdmin(Map<String, Object> map);

	int queryTotal();


	
}

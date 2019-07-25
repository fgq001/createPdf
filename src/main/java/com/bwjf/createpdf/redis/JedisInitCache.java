package com.bwjf.createpdf.redis;

import org.springframework.stereotype.Component;

@Component
public class JedisInitCache {

	//注入
//    @Autowired
//    private static JedisClient JedisClient;
	
	/**
	 * 
	* @Title: init 
	* @Description: 程序启动时执行该方法,目前用户清理redis缓存 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	/*@PostConstruct
	public void init(){
		System.out.println("----------清理redis缓存----------");
		JedisClient.clear();
	}*/
	
	
	/*public static void main(String[] args) {
		JedisClient.clear();
		System.out.println("end");
	}*/
	
}

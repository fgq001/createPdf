package com.bwjf.createpdf.redis.key;

public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}

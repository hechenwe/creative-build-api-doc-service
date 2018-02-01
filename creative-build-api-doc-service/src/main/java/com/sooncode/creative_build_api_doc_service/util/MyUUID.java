package com.sooncode.creative_build_api_doc_service.util;

 

import java.util.UUID;

public class  MyUUID  {
	
	/**
	 * 生成主键id.
	 * 
	 * @return uuid
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "").toUpperCase();
	}
	 
	

}

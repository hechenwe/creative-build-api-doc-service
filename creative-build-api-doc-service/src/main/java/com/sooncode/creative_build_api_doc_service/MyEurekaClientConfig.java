package com.sooncode.creative_build_api_doc_service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

//@Service
public class MyEurekaClientConfig   {

	 
	public List<String> getEurekaServerServiceUrls(String arg0) {
		List<String> urls = new ArrayList<>();

		String url2 = "http://api.sooncode.com:9999/ipAddressService/getPhysicsServiceMassages4key?key=creative-build-api-doc-service";
		//HttpRequest.getRequest(url2);
		
		
		String url = "http://api.sooncode.com:9999/ipAddressService/getPhysicsServiceMassages4key?key=creative-build-registration-service";
		//String json = HttpRequest.getRequest(url);
		JsonParser parser = new JsonParser();

		//JsonArray jsonArray = parser.parse(json).getAsJsonArray();

		Gson gson = new Gson();
		//for (JsonElement jsonElement : jsonArray) {

			//String s = jsonElement.toString();
			//PhysicsServiceMassage p = gson.fromJson(s, PhysicsServiceMassage.class);
			//String ip = p.getNowIp();

			String u = "http://" + "192.168.1.18" + ":9001/eureka/";
			urls.add(u);

		//}

		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(urls);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		return urls;

	}

	/**
	 * 读文件
	 * 
	 * @param filePath
	 *            文件所在的路径
	 * @return 文件的内容
	 * @throws IOException
	 */
	public static String readFile(String filePath) throws IOException {
		File file = new File(filePath);
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}

		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();
		while (temp != null) {
			sb.append(temp + " ");
			temp = br.readLine();
		}
		br.close();
		return sb.toString();
	}

}

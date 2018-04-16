package com.sooncode.creative_build_api_doc_service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooncode.creative_build_api_doc_service.model.KeyAndValue;
import com.sooncode.creative_build_api_doc_service.model.request.GetKeyAndValue;

import net.sf.json.JSONObject;

/**
 * 签名测试controller
 * 
 * @author chenhe9
 *
 */
@Controller
@RequestMapping("/signTestController")
public class SignTestController {

	@RequestMapping(value = "getKeyAndValues", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getKeyAndValues(@RequestBody GetKeyAndValue gkav) {

		List<KeyAndValue> list = new ArrayList<>();
		String jsonData = gkav.getJsonData();
		JSONObject json = null;
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			json = JSONObject.fromObject(jsonData);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("keyAndValues", list);
			return map;
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> data = json;

		for (Entry<String, Object> en : data.entrySet()) {
			String key = en.getKey();
			String val = en.getValue().toString();
			KeyAndValue kv = new KeyAndValue();
			kv.setKey(key);
			kv.setValue(val);
			list.add(kv);
		}

		 
		map.put("keyAndValues", list);

		return map;

	}

}

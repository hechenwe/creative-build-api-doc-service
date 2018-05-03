package com.sooncode.creative_build_api_doc_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooncode.creative_build_api_doc_service.entity.ApiNode;
import com.sooncode.creative_build_api_doc_service.model.request.AddApiNodesModel;
import com.sooncode.creative_build_api_doc_service.model.request.GetApiNodesModel;
import com.sooncode.soonjdbc.service.JdbcService;

@Controller
@RequestMapping("/apiNodeController")
public class ApiNodeController {

	@Autowired
	private JdbcService jdbcService;

	@RequestMapping(value = "addApiNodes", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addApiNodes(@RequestBody AddApiNodesModel aanm) {

		ApiNode an = new ApiNode();
		an.setProjectId(aanm.getProjectId());

		jdbcService.deletes(an);

		int[] n = jdbcService.saves(aanm.getApiNodes());
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("addApiNodes", n.length);
		return map;

	}
	
	
	
	@RequestMapping(value = "getApiNodes", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getApiNodes(@RequestBody GetApiNodesModel ganm) {
		
		ApiNode an = new ApiNode();
		an.setProjectId(ganm.getProjectId());
		//an.setId(ganm.getId());
		
		List<ApiNode> list = jdbcService.gets(an);
		
		
		
		
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("allNodes", list);
		map.put("starts", list);
		map.put("ends", list);
		return map;
		
	}
}

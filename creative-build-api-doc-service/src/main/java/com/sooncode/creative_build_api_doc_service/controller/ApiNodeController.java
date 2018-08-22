package com.sooncode.creative_build_api_doc_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooncode.creative_build_api_doc_service.entity.ApiNode;
import com.sooncode.creative_build_api_doc_service.entity.ApiNodeUrl;
import com.sooncode.creative_build_api_doc_service.model.request.AddApiNodesModel;
import com.sooncode.creative_build_api_doc_service.model.request.ApiNode4Controler;
import com.sooncode.creative_build_api_doc_service.model.request.GetApiNodesModel;
import com.sooncode.creative_build_api_doc_service.service.ApiNodeService;
import com.sooncode.creative_build_api_doc_service.service.model.StartAndEndNode;
import com.sooncode.soonjdbc.service.JdbcService;

@Controller
@RequestMapping("/apiNodeController")
public class ApiNodeController {

	@Autowired
	private JdbcService jdbcService;
	
	@Autowired
	private ApiNodeService apiNodeService;

	@RequestMapping(value = "addApiNodes", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addApiNodes(@RequestBody AddApiNodesModel aanm) {

		ApiNode an = new ApiNode();
		an.setProjectId(aanm.getProjectId());

		jdbcService.deletes(an);
		ApiNodeUrl anu = new ApiNodeUrl();
		anu.setProjectId(aanm.getProjectId());
		jdbcService.deletes(anu);
		
		for (ApiNode4Controler anc : aanm.getApiNodes()) {
			
			ApiNode a = new ApiNode();
			
			a.setExplain(anc.getExplain());
			a.setKey(anc.getKey());
			a.setName(anc.getName());
			a.setNextNodeNames(anc.getNextNodeNames());
			a.setProjectId(anc.getProjectId());
			a.setType(anc.getType());
			
			if("CONTROLLER".equals(anc.getType())) {
				
				ApiNodeUrl apiNodeUrl = new ApiNodeUrl();
				apiNodeUrl.setApiNodeName(anc.getName());
				apiNodeUrl.setApiNodeUrl(anc.getApiUrl());
				apiNodeUrl.setProjectId(aanm.getProjectId());
				jdbcService.save(apiNodeUrl);
				
			}
			
			jdbcService.save(a);
			
		}
		
 
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("addApiNodes", aanm.getApiNodes().size());
		return map;

	}
	
	
	
	@RequestMapping(value = "getApiNodes", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getApiNodes(@RequestBody GetApiNodesModel ganm) {
		
		StartAndEndNode  startAndEndNode  = apiNodeService.getApiNode4Service(ganm.getProjectId(), ganm.getApiUrl());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allNodes", startAndEndNode.getAllNodes());
		map.put("starts", startAndEndNode.getStartNodes());
		map.put("ends", startAndEndNode.getEndNodes());
		return map;
		
	}
}

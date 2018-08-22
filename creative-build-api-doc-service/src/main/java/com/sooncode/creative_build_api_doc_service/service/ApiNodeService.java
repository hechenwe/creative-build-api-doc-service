package com.sooncode.creative_build_api_doc_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooncode.creative_build_api_doc_service.entity.ApiNode;
import com.sooncode.creative_build_api_doc_service.entity.ApiNodeUrl;
import com.sooncode.creative_build_api_doc_service.service.model.ApiNode4Service;
import com.sooncode.creative_build_api_doc_service.service.model.StartAndEndNode;
import com.sooncode.soonjdbc.dao.JdbcDao;

@Service
public class ApiNodeService {

	@Autowired
	private JdbcDao jdbcDao;

	public StartAndEndNode getApiNode4Service(String projectId, String apiUrl) {

		ApiNodeUrl anu = new ApiNodeUrl();

		anu.setProjectId(projectId);
		List<ApiNodeUrl> list = jdbcDao.gets(anu);
		String apiName = null;
		for (ApiNodeUrl apiNodeUrl : list) {
			if (apiUrl.contains(apiNodeUrl.getApiNodeUrl())) {
				apiName = apiNodeUrl.getApiNodeName();
				break;
			}
		}

		if (apiName != null) {
			ApiNode4Service apiNode4Service = getApiNode4Service(apiName);

			return getStartAndEndNode(apiNode4Service);

		}

		return null;

	}

	private ApiNode4Service getApiNode4Service(String apiName) {
		ApiNode4Service apiNode4Service = new ApiNode4Service();
		ApiNode an = new ApiNode();
		an.setName(apiName);
		an = jdbcDao.get(an);
		apiNode4Service.setExplain(an.getExplain());
		apiNode4Service.setKey(an.getKey());
		apiNode4Service.setName(an.getName());
		apiNode4Service.setType(an.getType());
		if (an.getNextNodeNames() != null && !an.getNextNodeNames().trim().equals("")) {

			String[] nextNodeNames = an.getNextNodeNames().split(";");

			List<ApiNode4Service> list = new ArrayList<>();

			for (String nextNodeName : nextNodeNames) {

				list.add(getApiNode4Service(nextNodeName));

			}
			apiNode4Service.setNextNodes(list);

		}
		return apiNode4Service;

	}

	private StartAndEndNode getStartAndEndNode(ApiNode4Service apiNode4Service) {

		StartAndEndNode startAndEndNode = new StartAndEndNode();
		List<ApiNode> allList = new ArrayList<>();
		List<ApiNode> startList = new ArrayList<>();
		List<ApiNode> endList = new ArrayList<>();
		foreach(allList, startList, endList, apiNode4Service);
		startAndEndNode.setAllNodes(allList);
		startAndEndNode.setStartNodes(startList);
		startAndEndNode.setEndNodes(endList);
		return startAndEndNode;

	}

	private void foreach(List<ApiNode> allList, List<ApiNode> starts, List<ApiNode> ends, ApiNode4Service apiNode4Service) {
		ApiNode start = new ApiNode();

		String explain = apiNode4Service.getExplain();
		String key = apiNode4Service.getKey();
		String name = apiNode4Service.getName();
		String type = apiNode4Service.getType();
		start.setExplain(explain);
		start.setKey(key);
		start.setType(type);
		start.setName(name);
		allList.add(start);
		List<ApiNode4Service> list = apiNode4Service.getNextNodes();
		if (list != null && list.size() > 0) {
			for (ApiNode4Service ans : list) {
				ApiNode end = new ApiNode();
				end.setExplain(ans.getExplain());
				end.setKey(ans.getKey());
				end.setName(ans.getName());
				end.setType(ans.getType());
				starts.add(start);
				ends.add(end);

				if (ans.getNextNodes() != null && ans.getNextNodes().size() > 0) {
					foreach(allList, starts, ends, ans);
				} else {
					allList.add(end);
					continue;
				}

			}
			;
		}
	}

}

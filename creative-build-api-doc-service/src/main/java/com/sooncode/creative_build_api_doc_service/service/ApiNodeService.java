package com.sooncode.creative_build_api_doc_service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sooncode.creative_build_api_doc_service.entity.ApiNode;
import com.sooncode.creative_build_api_doc_service.service.model.StartAndEndNode;

@Service
public class ApiNodeService {

	public StartAndEndNode getStartAndEndNode(List<ApiNode> list) {

		Map<Integer, List<ApiNode>> map = sortApiNode(list);
		ApiNode headApiNode = map.get(0).get(0);
		if (map.size() > 1) {
			for (int i = 1; i < map.size(); i++) {
				List<ApiNode> indexList = map.get(i);
			}
		}

		return null;

	}

	private Map<Integer, List<ApiNode>> sortApiNode(List<ApiNode> list) {
		Map<Integer, List<ApiNode>> map = new HashMap<>();

		for (ApiNode apiNode : list) {

			//String index = apiNode.getNodeIndex();
			//String[] indexs = index.split(",");

			//int in = Integer.parseInt(indexs[0]) - 1;
			//List<ApiNode> indexList = map.get(in);
			//if (indexList == null) {
				//indexList = new ArrayList<>();
			//}
			//indexList.add(apiNode);
			//map.put(in, indexList);
		}

		return map;

	}

}

package com.sooncode.creative_build_api_doc_service.service.model;

import java.util.List;

import com.sooncode.creative_build_api_doc_service.entity.ApiNode;

public class StartAndEndNode {

	private List<ApiNode> startNodes;
	private List<ApiNode> endNodes;

	public List<ApiNode> getStartNodes() {
		return startNodes;
	}

	public void setStartNodes(List<ApiNode> startNodes) {
		this.startNodes = startNodes;
	}

	public List<ApiNode> getEndNodes() {
		return endNodes;
	}

	public void setEndNodes(List<ApiNode> endNodes) {
		this.endNodes = endNodes;
	}

}

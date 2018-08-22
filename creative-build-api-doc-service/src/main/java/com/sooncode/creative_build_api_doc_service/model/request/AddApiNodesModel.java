package com.sooncode.creative_build_api_doc_service.model.request;

import java.util.List;

public class AddApiNodesModel {

	 private String projectId ;
	 
	 private List<ApiNode4Controler> apiNodes ;

	 
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<ApiNode4Controler> getApiNodes() {
		return apiNodes;
	}

	public void setApiNodes(List<ApiNode4Controler> apiNodes) {
		this.apiNodes = apiNodes;
	}
	 
	 
	 
	
}

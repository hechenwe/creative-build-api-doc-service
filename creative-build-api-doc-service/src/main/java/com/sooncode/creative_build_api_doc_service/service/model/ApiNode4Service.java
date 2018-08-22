
package com.sooncode.creative_build_api_doc_service.service.model;
import java.util.List;
/**
*
* @author hechen 
* 
*/ 
public class ApiNode4Service  { 
	 
	 
	 
	 private String name ;
	 
	 
	 private String type;
	 
	 private String explain ;
	  
	 
	 private String key ;
	 
	 
	 private List<ApiNode4Service> nextNodes ;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getExplain() {
		return explain;
	}


	public void setExplain(String explain) {
		this.explain = explain;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public List<ApiNode4Service> getNextNodes() {
		return nextNodes;
	}


	public void setNextNodes(List<ApiNode4Service> nextNodes) {
		this.nextNodes = nextNodes;
	}
	 
	 
	 
	 
	 
	 
}

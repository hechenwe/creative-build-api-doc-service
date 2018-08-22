
package com.sooncode.creative_build_api_doc_service.entity;
import java.io.Serializable;
/**
*
* @author hechen 
* 
*/ 
public class ApiNodeUrl implements Serializable{ 
	 private static final long serialVersionUID = 1L;
	 /** 编号 */ 
	 private Integer id; 
	 /**  */
	 private String apiNodeUrl ;
	 /**  */
	 private String projectId ;
	 /**  */
	 private String apiNodeName ;

	 /**  */
	 public String getApiNodeUrl() { 
	 	 return apiNodeUrl;
	 }
	 /**  */
	 public void setApiNodeUrl(String apiNodeUrl) {
	 	 this.apiNodeUrl = apiNodeUrl;
	 }

	 /** 编号 */
	 public Integer getId() { 
	 	 return id;
	 }
	 /** 编号 */
	 public void setId(Integer id) {
	 	 this.id = id;
	 }

	 /**  */
	 public String getProjectId() { 
	 	 return projectId;
	 }
	 /**  */
	 public void setProjectId(String projectId) {
	 	 this.projectId = projectId;
	 }

	 /**  */
	 public String getApiNodeName() { 
	 	 return apiNodeName;
	 }
	 /**  */
	 public void setApiNodeName(String apiNodeName) {
	 	 this.apiNodeName = apiNodeName;
	 }

}

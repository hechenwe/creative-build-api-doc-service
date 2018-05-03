
package com.sooncode.creative_build_api_doc_service.entity;
import java.io.Serializable;
/**
*
* @author hechen 
* 
*/ 
public class ApiNode implements Serializable{ 
	 private static final long serialVersionUID = 1L;
	 /**  */ 
	 private Integer systemId; 
	 /** 节点索引 */
	 private String nextNodeNames ;
	 /** 节点扼要说明 */
	 private String explain ;
	 /** 节点类型 */
	 private String type ;
	 /** 节点关键信息 */
	 private String key ;
	 /** 项目编号 */
	 private String projectId ;
	 /** 节点对应的方法签名 */
	 private String name ;

	 /** 节点索引 */
	 public String getNextNodeNames() { 
	 	 return nextNodeNames;
	 }
	 /** 节点索引 */
	 public void setNextNodeNames(String nextNodeNames) {
	 	 this.nextNodeNames = nextNodeNames;
	 }

	 /** 节点扼要说明 */
	 public String getExplain() { 
	 	 return explain;
	 }
	 /** 节点扼要说明 */
	 public void setExplain(String explain) {
	 	 this.explain = explain;
	 }

	 /** 节点类型 */
	 public String getType() { 
	 	 return type;
	 }
	 /** 节点类型 */
	 public void setType(String type) {
	 	 this.type = type;
	 }

	 /**  */
	 public Integer getSystemId() { 
	 	 return systemId;
	 }
	 /**  */
	 public void setSystemId(Integer systemId) {
	 	 this.systemId = systemId;
	 }

	 /** 节点关键信息 */
	 public String getKey() { 
	 	 return key;
	 }
	 /** 节点关键信息 */
	 public void setKey(String key) {
	 	 this.key = key;
	 }

	 /** 项目编号 */
	 public String getProjectId() { 
	 	 return projectId;
	 }
	 /** 项目编号 */
	 public void setProjectId(String projectId) {
	 	 this.projectId = projectId;
	 }

	 /** 节点对应的方法签名 */
	 public String getName() { 
	 	 return name;
	 }
	 /** 节点对应的方法签名 */
	 public void setName(String name) {
	 	 this.name = name;
	 }

}

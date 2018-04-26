package com.sooncode.creative_build_api_doc_service.service.wordoutput.model;
public class ApiDocHead  { 
	  
	 
	 /** 创建时间 */
	 private java.util.Date creatDate ;
	  
	 /** 作者姓名 */
	 private String authorName ;
	 
	 /** 项目名称 */
	 private String projectName ;
	 /** 项目简介 */
	 private String projectIntro ;
	 
	 /** 版本号 */
	 private String versions ;

	public java.util.Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(java.util.Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIntro() {
		return projectIntro;
	}

	public void setProjectIntro(String projectIntro) {
		this.projectIntro = projectIntro;
	}

	public String getVersions() {
		return versions;
	}

	public void setVersions(String versions) {
		this.versions = versions;
	}

	 

}

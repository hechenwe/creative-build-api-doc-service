package com.sooncode.creative_build_api_doc_service.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooncode.creative_build_api_doc_service.entity.Project;
import com.sooncode.creative_build_api_doc_service.model.AddProjectModel;
import com.sooncode.creative_build_api_doc_service.model.GetApiDoc4Html;
import com.sooncode.creative_build_api_doc_service.model.freemarker.ProjectModel;
import com.sooncode.creative_build_api_doc_service.model.request.GetProjectsModel;
import com.sooncode.creative_build_api_doc_service.service.FreemarkerService;
import com.sooncode.creative_build_api_doc_service.service.ProjectService;
import com.sooncode.creative_build_api_doc_service.util.FileUtil;
import com.sooncode.creative_build_api_doc_service.util.MyUUID;
import com.sooncode.soonjdbc.ModelTransform;
import com.sooncode.soonjdbc.constant.Sort;
import com.sooncode.soonjdbc.page.Page;
import com.sooncode.soonjdbc.service.JdbcService;
import com.sooncode.soonjdbc.sql.condition.Conditions;
import com.sooncode.soonjdbc.sql.condition.ConditionsBuilderProcess;

@Controller
@RequestMapping("/projectController")
public class ProjectController {

	@Autowired
	private JdbcService jdbcService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "addProject", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addProject(@RequestBody AddProjectModel apm) {
		Project p = ModelTransform.to(apm, Project.class);
		Project deleteP = new Project();
		deleteP.setProjectCode(apm.getProjectCode());
		jdbcService.deletes(deleteP);
		String projectId = MyUUID.getUUID();
		p.setProjectId(projectId);
		p.setAuthorName(apm.getAuthorName());
		p.setCreatDate(new Date());
		p.setIsIssue("FALSE");
		p.setVersions("1.0");
		long n = jdbcService.save(p);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isAdd = (n == 1L) ;
		map.put("projectId", isAdd ? projectId : null);
		return map;

	}
	@RequestMapping(value = "getProjects", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getProjects(@RequestBody GetProjectsModel gpm) {
		 
		Project p = new Project();
		p.setCompanyId(gpm.getCompanyId());
		
		Conditions c = ConditionsBuilderProcess.getConditions(p);
		c.setOderBy("projectCode", Sort.ASC);
		Page page = jdbcService.getPage(gpm.getPageNum(), gpm.getPageSize(), c);
		
		Map<String, Object> map = new HashMap<String, Object>();
		 
		map.put("projects", page.getOnes() );
		map.put("total", page.getTotal() );
		map.put("pageNum", page.getPageNumber() );
		map.put("pageSize", page.getPageSize() );
		return map;
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "getApiDoc4Html", method = RequestMethod.POST)
	@ResponseBody
	public String getApiDoc4Html(@RequestBody GetApiDoc4Html gadh) {
		
		Project p = new Project();
		p.setProjectCode(gadh.getProjectCode());
		p = jdbcService.get(p);
		ProjectModel pm = projectService.getProjectAllInfo(p.getProjectId());
		String templateFilePath = System.getProperty("API_DOC_ROOT"); 
		FreemarkerService fs = new FreemarkerService(templateFilePath+"WEB-INF\\classes\\freemarker");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("project" ,pm);
		String str = fs.getString(map, "index.html");
		
		FileUtil fu = new FileUtil();
		fu.writeFile("D:\\index.html", str, "utf-8");
		return str;
	}
	
	
	
}

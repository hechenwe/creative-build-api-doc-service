package com.sooncode.creative_build_api_doc_service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooncode.creative_build_api_doc_service.entity.Parameter;
import com.sooncode.creative_build_api_doc_service.entity.ParameterConstraint;
import com.sooncode.creative_build_api_doc_service.model.AddParameterModel;
import com.sooncode.creative_build_api_doc_service.util.MyUUID;
import com.sooncode.soonjdbc.ModelTransform;
import com.sooncode.soonjdbc.service.JdbcService;

@Controller
@RequestMapping("/parameterController")
public class ParameterController {

	@Autowired
	private JdbcService jdbcService;

	@RequestMapping(value = "addParameter", method = RequestMethod.POST)
	@ResponseBody
	public void addParameter(@RequestBody List<AddParameterModel> apms) {
		List<Parameter> ps = ModelTransform.tos(apms, Parameter.class);
		for (Parameter p : ps) {
			String parameterId = MyUUID.getUUID();
			p.setParameterId(parameterId); 
			p.setCreatDate(new Date());
			p.setWeight(1);
			this.addParameterConstraint(parameterId,p.getEnumeration(),p.getEnumerationExplain());
		}
		jdbcService.saves(ps);
		 

	}
	
	 
	private void addParameterConstraint(String parameterId ,  String enumeration, String enumerationExplain) {
		
		if(enumeration !=null && enumerationExplain != null && !enumeration.equals("") &&  !enumerationExplain.equals("")) {
			
			String [] enumerations = enumeration.split(";");
			String [] enumerationExplains = enumerationExplain.split(";");
			List<ParameterConstraint> list = new ArrayList<>();
			for (int i = 0 ; i < enumerations.length ; i ++) {
				ParameterConstraint pc = new ParameterConstraint();
				pc.setParameterConstraintId(MyUUID.getUUID());
				pc.setParameterConstraintCode(enumerations[i]);
				pc.setParameterConstraintExplain(enumerationExplains[i]);
				pc.setCreatDate(new Date());
				pc.setParameterId(parameterId);
				list.add(pc);
				
			}
			jdbcService.saves(list);
			
			
		}
		
		
		
		
	}
}

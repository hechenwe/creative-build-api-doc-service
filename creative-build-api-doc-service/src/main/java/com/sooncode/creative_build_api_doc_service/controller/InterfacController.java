package com.sooncode.creative_build_api_doc_service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooncode.creative_build_api_doc_service.entity.Interfac;
import com.sooncode.creative_build_api_doc_service.entity.Module;
import com.sooncode.creative_build_api_doc_service.entity.Parameter;
import com.sooncode.creative_build_api_doc_service.entity.ParameterConstraint;
import com.sooncode.creative_build_api_doc_service.entity.ParameterRetur;
import com.sooncode.creative_build_api_doc_service.model.AddInterfacModel;
import com.sooncode.creative_build_api_doc_service.model.GetAllInterfacesModel;
import com.sooncode.creative_build_api_doc_service.model.GetAllModulesModel;
import com.sooncode.creative_build_api_doc_service.model.request.GetInterfaceByInterfacNumberModel;
import com.sooncode.creative_build_api_doc_service.model.response.GetAllInterfacesResponseModel;
import com.sooncode.creative_build_api_doc_service.model.response.ParameterConstraintModel;
import com.sooncode.creative_build_api_doc_service.util.MyUUID;
import com.sooncode.soonjdbc.ModelTransform;
import com.sooncode.soonjdbc.constant.Sort;
import com.sooncode.soonjdbc.service.JdbcService;
import com.sooncode.soonjdbc.sql.condition.Conditions;
import com.sooncode.soonjdbc.sql.condition.ConditionsBuilderProcess;
 

@Controller
@RequestMapping("/interfacController")
public class InterfacController {

	@Autowired
	private JdbcService jdbcService;

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private DefaultListableBeanFactory beanFactory;

	@RequestMapping(value = "addInterfac", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addInterfac(@RequestBody AddInterfacModel aim) {
		Interfac i = ModelTransform.to(aim, Interfac.class);

		String interfacId = MyUUID.getUUID();
		i.setInterfacId(interfacId);
		i.setInterfacNumber(aim.getInterfacNumber());
		i.setCreatDate(new Date());
		i.setParameterFormat("JSON");
		i.setRequestType("POST");
		i.setReturnDataType("JSON");
		i.setStyle("GENERAL");
		i.setWeight(1);
		long n = jdbcService.save(i);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isAdd = (n == 1L);
		map.put("interfacId", isAdd ? interfacId : null);
		return map;

	}

	@RequestMapping(value = "getAllInterfaces", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAllInterfaces(@RequestBody GetAllInterfacesModel gaim) {
		Interfac i = new Interfac();
		i.setModuleId(gaim.getModuleId());
		Conditions c = ConditionsBuilderProcess.getConditions(i);
		c.setOderBy("interfacCode", Sort.ASC);
		List<Interfac> interfaces = jdbcService.gets(c);
		List<GetAllInterfacesResponseModel> gairms = new LinkedList<>();

		for (Interfac interfac : interfaces) {

			Parameter p = new Parameter();
			p.setInterfacId(interfac.getInterfacId());
			Conditions con = ConditionsBuilderProcess.getConditions(p);
			con.setOderBy("isMust", Sort.DESC);
			List<Parameter> parameters = jdbcService.gets(con);
			ParameterRetur pr = new ParameterRetur();
			pr.setInterfacId(interfac.getInterfacId());
			List<ParameterRetur> parameterReturs = jdbcService.gets(pr);
			List<ParameterConstraintModel> parameterConstraintModels = new ArrayList<>();
			for (Parameter para : parameters) {

				ParameterConstraint pc = new ParameterConstraint();
				pc.setParameterId(para.getParameterId());
				List<ParameterConstraint> parameterConstraints = jdbcService.gets(pc);
				if (parameterConstraints != null && parameterConstraints.size() > 0) {
					ParameterConstraintModel pcm = new ParameterConstraintModel();
					pcm.setParameterCode(para.getParameterCode());
					pcm.setParameterConstraints(parameterConstraints);
					parameterConstraintModels.add(pcm);

				}

			}

			GetAllInterfacesResponseModel garm = new GetAllInterfacesResponseModel();
			garm.setInterfac(interfac);
			garm.setParameters(parameters);
			garm.setParameterReturns(parameterReturs);
			garm.setParameterConstraintModels(parameterConstraintModels);
			gairms.add(garm);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("interfacesResponseModels", gairms);

		return map;

	}

	@RequestMapping(value = "getInterfaceByInterfacNumber", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getInterfaceByInterfacNumber(@RequestBody GetInterfaceByInterfacNumberModel gibinm) {
		Interfac i = new Interfac();
		i.setInterfacNumber(gibinm.getInterfacNumber());

		Interfac interfac = jdbcService.get(i);

		Parameter p = new Parameter();
		p.setInterfacId(interfac.getInterfacId());
		List<Parameter> parameters = jdbcService.gets(p);
		ParameterRetur pr = new ParameterRetur();
		pr.setInterfacId(interfac.getInterfacId());
		List<ParameterRetur> parameterReturs = jdbcService.gets(pr);
		List<ParameterConstraintModel> parameterConstraintModels = new ArrayList<>();
		for (Parameter para : parameters) {

			ParameterConstraint pc = new ParameterConstraint();
			pc.setParameterId(para.getParameterId());
			List<ParameterConstraint> parameterConstraints = jdbcService.gets(pc);
			if (parameterConstraints != null && parameterConstraints.size() > 0) {
				ParameterConstraintModel pcm = new ParameterConstraintModel();
				pcm.setParameterCode(para.getParameterCode());
				pcm.setParameterConstraints(parameterConstraints);
				parameterConstraintModels.add(pcm);

			}

		}

		GetAllInterfacesResponseModel garm = new GetAllInterfacesResponseModel();
		garm.setInterfac(interfac);
		garm.setParameters(parameters);
		garm.setParameterReturns(parameterReturs);
		garm.setParameterConstraintModels(parameterConstraintModels);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("interfacesResponseModel", garm);
		return map;

	}

	@RequestMapping(value = "getAllModules", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAllModules(@RequestBody GetAllModulesModel gamm) {

		Module m = new Module();
		m.setProjectId(gamm.getProjectId());
		Conditions c = ConditionsBuilderProcess.getConditions(m);
		c.setOderBy("moduleName", Sort.ASC);
		List<Module> list = jdbcService.gets(c);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("modules", list);

		return map;

	}

	/*@RequestMapping(value = "loadController", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loadController() {

		String classPath = "D:\\java_source\\";
		String controllerName = "TestController";

		String[] params = new String[] { "-d", classPath, classPath + controllerName + ".java", "-verbose" };
		int status = Main.compile(params);

		try {
			ClassLo.lo();
			Class<?> controller = Class.forName("com.sooncode.creative_build_api_doc_service.TestController");
			
			registerBean("testController",controller);
			unregisterController(controller, "test");
			registerController(controller, "test");
		} catch (Exception e) {

			e.printStackTrace();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loadController", "ok");

		return map;

	}

	private void registerController(Class<?> controllerClass, String methodName) {
		RequestMappingHandlerMapping requestMappingHandlerMapping = ctx.getBean(RequestMappingHandlerMapping.class);
		Method getMappingForMethod = ReflectionUtils.findMethod(RequestMappingHandlerMapping.class, "getMappingForMethod", Method.class, Class.class);
		getMappingForMethod.setAccessible(true);

		RObject<?> roj = new RObject<>(controllerClass);
		Method method = roj.getDeclaredMethod(methodName);

		RequestMappingInfo mapping_info;
		try {

			mapping_info = (RequestMappingInfo) getMappingForMethod.invoke(requestMappingHandlerMapping, method, controllerClass);
		 

			requestMappingHandlerMapping.registerMapping(mapping_info, roj.getObject(), method);
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
	private void unregisterController(Class<?> controllerClass, String methodName) {
		RequestMappingHandlerMapping requestMappingHandlerMapping = ctx.getBean(RequestMappingHandlerMapping.class);
		Method getMappingForMethod = ReflectionUtils.findMethod(RequestMappingHandlerMapping.class, "getMappingForMethod", Method.class, Class.class);
		getMappingForMethod.setAccessible(true);
		
		RObject<?> roj = new RObject<>(controllerClass);
		Method method = roj.getDeclaredMethod(methodName);
		
		RequestMappingInfo mapping_info;
		try {
			
			mapping_info = (RequestMappingInfo) getMappingForMethod.invoke(requestMappingHandlerMapping, method, controllerClass);
			
			
			requestMappingHandlerMapping.unregisterMapping(mapping_info);
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	public void registerBean(String beanName, Class<?> beanClass) {
		Assert.notNull(beanClass, "register bean class must not null");
		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(beanClass);

		if (StringUtils.hasText(beanName)) {
			beanFactory.registerBeanDefinition(beanName, bd);
		} else {
			BeanDefinitionReaderUtils.registerWithGeneratedName(bd, beanFactory);
		}

	}*/
}

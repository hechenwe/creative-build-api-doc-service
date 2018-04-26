package com.sooncode.creative_build_api_doc_service.service.wordoutput;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooncode.creative_build_api_doc_service.entity.Interfac;
import com.sooncode.creative_build_api_doc_service.entity.Module;
import com.sooncode.creative_build_api_doc_service.entity.Parameter;
import com.sooncode.creative_build_api_doc_service.entity.ParameterConstraint;
import com.sooncode.creative_build_api_doc_service.entity.ParameterRetur;
import com.sooncode.creative_build_api_doc_service.entity.Project;
import com.sooncode.creative_build_api_doc_service.util.word.TitleType;
import com.sooncode.creative_build_api_doc_service.util.word.WordDocument;
import com.sooncode.creative_build_api_doc_service.util.word.WordTable;
import com.sooncode.soonjdbc.dao.JdbcDao;

@Service
public class WordOutputService4API {

	@Autowired
	private JdbcDao jdbcDao;

	public String buildDoc(String projectId) {
		try {
			WordDocument wd = new WordDocument();

			buildTitle(projectId, wd);
			buildModel(projectId, wd);
			wd.output("D:\\代码备份\\运营平台-接口文档.docx");
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "Fal";
		}

	}

	public void buildTitle(String projectId, WordDocument wd) {

		Project pro = new Project();
		pro.setProjectId(projectId);

		pro = jdbcDao.get(pro);

		wd.setTitle(pro.getProjectName() + "接口文档", "000000", 14);
		wd.addParagraph("作者:" + pro.getAuthorName(), "000000", 10, ParagraphAlignment.CENTER, null, 0);
		wd.addParagraph("日期:" + new SimpleDateFormat("yyyy-MM-dd").format(pro.getCreatDate()), "000000", 10, ParagraphAlignment.CENTER, null, 0);
		wd.addParagraph("版本:" + pro.getVersions(), "000000", 10, ParagraphAlignment.CENTER, null, 0);

	}

	public void buildModel(String projectId, WordDocument wd) {

		Module m = new Module();
		m.setProjectId(projectId);
		List<Module> modules = jdbcDao.gets(m);

		for (int i = 0 ; i < modules.size() ; i++) {
			Module module = modules.get(i);
			wd.addParagraph((i+1)+"." + module.getModuleName(), "000000", 10, ParagraphAlignment.LEFT, TitleType.H2, 0);
			Interfac inter = new Interfac();
			inter.setModuleId(module.getModuleId());
			List<Interfac> interfacs = jdbcDao.gets(inter);

			for (int j = 0 ; j < interfacs.size() ; j++) {
				
				Interfac interfac = interfacs.get(j);
				String color = "7A7878";
				wd.addParagraph((i+1) + "." + (j+1) +"." + interfac.getInterfacName(), "323E4F", 10, ParagraphAlignment.LEFT, TitleType.H3, 1);
				wd.addParagraph("请求地址:" + interfac.getUrl(), color, 6, ParagraphAlignment.LEFT, null, 1);
				wd.addParagraph("请求方式:" + interfac.getRequestType(), color, 6, ParagraphAlignment.LEFT, null,1);
				wd.addParagraph("参数数据格式:" + interfac.getParameterFormat(), color, 6, ParagraphAlignment.LEFT, null, 1);
				wd.addParagraph("返回数据格式:" + interfac.getReturnDataType(), color, 6, ParagraphAlignment.LEFT, null, 1);
				wd.addParagraph("请求参数:", color, 6, ParagraphAlignment.LEFT, null, 1);
				wd.addParagraph(interfac.getJsonParameters(), color, 5, ParagraphAlignment.LEFT, null, 1);
				wd.addLine();
				

				Parameter p = new Parameter();
				p.setInterfacId(interfac.getInterfacId());
				List<Parameter> parameters = jdbcDao.gets(p);

				if (parameters != null && parameters.size() > 0) {
					
					WordTable parameterWT = new WordTable();
					wd.addParagraph("请求参数说明:", color, 6, ParagraphAlignment.LEFT, null, 1);
					parameterWT.setTableTitl(new String[] { "代码", "名称", "是否必须", "类型", "最大长度", "枚举", "示例" });
					for (Parameter parameter : parameters) {
						parameterWT.addTableLine(new String[] { parameter.getParameterCode(), parameter.getParameterName(), parameter.getIsMust(), parameter.getParameterDataType(), parameter.getMaxLength().toString(), parameter.getEnumeration(), parameter.getParameterExample() });
					}
					wd.addWordTable(parameterWT);

				}
				
				
				
				ParameterRetur pr = new ParameterRetur();
				pr.setInterfacId(interfac.getInterfacId());
				List<ParameterRetur> parameterReturs = jdbcDao.gets(pr);
				if(parameterReturs != null && parameterReturs.size() > 0 ) {
					WordTable parameterWT = new WordTable();
					wd.addLine();
					wd.addParagraph("返回值说明:", color, 6, ParagraphAlignment.LEFT, null, 1);
					parameterWT.setTableTitl(new String[] { "代码", "名称", "是否必须", "类型", "最大长度", "枚举", "示例" });
					for (ParameterRetur pRetur : parameterReturs) {
						parameterWT.addTableLine(new String[] { pRetur.getParameterCode(), pRetur.getParameterName(), pRetur.getIsMust(), pRetur.getParameterDataType(), pRetur.getMaxLength().toString(), pRetur.getEnumeration(), pRetur.getParameterExample() });
					}
					wd.addWordTable(parameterWT);
					
				}
				
				for (Parameter parameter : parameters) {
					
					ParameterConstraint pc = new ParameterConstraint();
					
					pc.setParameterId(parameter.getParameterId());
					
					
					List<ParameterConstraint> parameterConstraints =  jdbcDao.gets(pc);
					
					if(parameterConstraints != null && parameterConstraints.size() > 0) {
						WordTable parameterWT = new WordTable();
						wd.addParagraph("["+parameter.getParameterCode()+"]枚举值说明:", color, 5, ParagraphAlignment.LEFT, null, 1);
						parameterWT.setTableTitl(new String[] { "枚举值", "枚举值说明"});
						for (ParameterConstraint pC : parameterConstraints) {
							parameterWT.addTableLine(new String[] { pC.getParameterConstraintCode() , pC.getParameterConstraintExplain()});
						}
						wd.addWordTable(parameterWT);
						
					}
					
				}
				
				
				
				
				wd.addLine();
				

			}
		}

	}

}

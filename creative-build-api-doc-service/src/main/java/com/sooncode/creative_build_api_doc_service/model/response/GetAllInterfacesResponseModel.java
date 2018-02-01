package com.sooncode.creative_build_api_doc_service.model.response;

import java.util.List;

import com.sooncode.creative_build_api_doc_service.entity.Interfac;
import com.sooncode.creative_build_api_doc_service.entity.Parameter;
import com.sooncode.creative_build_api_doc_service.entity.ParameterRetur;

public class GetAllInterfacesResponseModel {

	private Interfac interfac;
	
	private List<Parameter> parameters;
	private List<ParameterRetur> parameterReturns;
	
	private List<ParameterConstraintModel> parameterConstraintModels;

	public Interfac getInterfac() {
		return interfac;
	}

	public void setInterfac(Interfac interfac) {
		this.interfac = interfac;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public List<ParameterRetur> getParameterReturns() {
		return parameterReturns;
	}

	public void setParameterReturns(List<ParameterRetur> parameterReturns) {
		this.parameterReturns = parameterReturns;
	}

	public List<ParameterConstraintModel> getParameterConstraintModels() {
		return parameterConstraintModels;
	}

	public void setParameterConstraintModels(List<ParameterConstraintModel> parameterConstraintModels) {
		this.parameterConstraintModels = parameterConstraintModels;
	}
	
	
	
	
}

package com.sooncode.creative_build_api_doc_service.model.response;

import java.util.List;

import com.sooncode.creative_build_api_doc_service.entity.ParameterConstraint;

public class ParameterConstraintModel {
	private String parameterCode;

	private List<ParameterConstraint> parameterConstraints;

	public String getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(String parameterCode) {
		this.parameterCode = parameterCode;
	}

	public List<ParameterConstraint> getParameterConstraints() {
		return parameterConstraints;
	}

	public void setParameterConstraints(List<ParameterConstraint> parameterConstraints) {
		this.parameterConstraints = parameterConstraints;
	}

}

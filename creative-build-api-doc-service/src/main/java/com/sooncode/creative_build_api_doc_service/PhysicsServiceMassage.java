package com.sooncode.creative_build_api_doc_service;

public class PhysicsServiceMassage {

	/**
	 * 服务器唯一编号32位大写UUID
	 */
	private String serviceId;
	
	/**
	 * 服务器英文代码
	 */
	private String serviceCode;
	
	/**
	 * 服务器中文名称
	 */
	private String serviceName;
	
	/**
	 * 服务器所在详细地址
	 */
	
	private String serviceAddress;
	
	/**
	 * 服务器所在 地区 国家
	 */
	private String serviceArea;
	
	
	/**
	 * 服务器当前IP
	 */
	private String nowIp;
	
	/**
	 * 服务器当前域名
	 */
	
	private String nowDomain;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getServiceArea() {
		return serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public String getNowIp() {
		return nowIp;
	}

	public void setNowIp(String nowIp) {
		this.nowIp = nowIp;
	}

	public String getNowDomain() {
		return nowDomain;
	}

	public void setNowDomain(String nowDomain) {
		this.nowDomain = nowDomain;
	}
	
	
	
}

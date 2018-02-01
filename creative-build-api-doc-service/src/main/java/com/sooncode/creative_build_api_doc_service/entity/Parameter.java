
package com.sooncode.creative_build_api_doc_service.entity;
import java.io.Serializable;
/**
*
* @author hechen 
* 
*/ 
public class Parameter implements Serializable{ 
	 private static final long serialVersionUID = 1L;
	 /** 参数编号 */ 
	 private String parameterId; 
	 /** 枚举值 */
	 private String enumeration ;
	 /** 接口_编号 */
	 private String interfacId ;
	 /** 参数代码 */
	 private String parameterCode ;
	 /** 最大长度 */
	 private Integer maxLength ;
	 /** 参数数据类型 */
	 private String parameterDataType ;
	 /** 枚举值说明 */
	 private String enumerationExplain ;
	 /** 参数名称 */
	 private String parameterName ;
	 /** 最小长度 */
	 private Integer minLength ;
	 /** 是否必须 */
	 private String isMust ;
	 /** 版本号 */
	 private Integer versionNumber ;
	 /** 参数实例 */
	 private String parameterExample ;
	 /** 参数说明 */
	 private String parameterExplain ;
	 /** 创建时间 */
	 private java.util.Date creatDate ;
	 /** 权重 */
	 private Integer weight ;

	 /** 枚举值 */
	 public String getEnumeration() { 
	 	 return enumeration;
	 }
	 /** 枚举值 */
	 public void setEnumeration(String enumeration) {
	 	 this.enumeration = enumeration;
	 }

	 /** 接口_编号 */
	 public String getInterfacId() { 
	 	 return interfacId;
	 }
	 /** 接口_编号 */
	 public void setInterfacId(String interfacId) {
	 	 this.interfacId = interfacId;
	 }

	 /** 参数代码 */
	 public String getParameterCode() { 
	 	 return parameterCode;
	 }
	 /** 参数代码 */
	 public void setParameterCode(String parameterCode) {
	 	 this.parameterCode = parameterCode;
	 }

	 /** 最大长度 */
	 public Integer getMaxLength() { 
	 	 return maxLength;
	 }
	 /** 最大长度 */
	 public void setMaxLength(Integer maxLength) {
	 	 this.maxLength = maxLength;
	 }

	 /** 参数数据类型 */
	 public String getParameterDataType() { 
	 	 return parameterDataType;
	 }
	 /** 参数数据类型 */
	 public void setParameterDataType(String parameterDataType) {
	 	 this.parameterDataType = parameterDataType;
	 }

	 /** 枚举值说明 */
	 public String getEnumerationExplain() { 
	 	 return enumerationExplain;
	 }
	 /** 枚举值说明 */
	 public void setEnumerationExplain(String enumerationExplain) {
	 	 this.enumerationExplain = enumerationExplain;
	 }

	 /** 参数名称 */
	 public String getParameterName() { 
	 	 return parameterName;
	 }
	 /** 参数名称 */
	 public void setParameterName(String parameterName) {
	 	 this.parameterName = parameterName;
	 }

	 /** 最小长度 */
	 public Integer getMinLength() { 
	 	 return minLength;
	 }
	 /** 最小长度 */
	 public void setMinLength(Integer minLength) {
	 	 this.minLength = minLength;
	 }

	 /** 是否必须 */
	 public String getIsMust() { 
	 	 return isMust;
	 }
	 /** 是否必须 */
	 public void setIsMust(String isMust) {
	 	 this.isMust = isMust;
	 }

	 /** 版本号 */
	 public Integer getVersionNumber() { 
	 	 return versionNumber;
	 }
	 /** 版本号 */
	 public void setVersionNumber(Integer versionNumber) {
	 	 this.versionNumber = versionNumber;
	 }

	 /** 参数实例 */
	 public String getParameterExample() { 
	 	 return parameterExample;
	 }
	 /** 参数实例 */
	 public void setParameterExample(String parameterExample) {
	 	 this.parameterExample = parameterExample;
	 }

	 /** 参数说明 */
	 public String getParameterExplain() { 
	 	 return parameterExplain;
	 }
	 /** 参数说明 */
	 public void setParameterExplain(String parameterExplain) {
	 	 this.parameterExplain = parameterExplain;
	 }

	 /** 创建时间 */
	 public java.util.Date getCreatDate() { 
	 	 return creatDate;
	 }
	 /** 创建时间 */
	 public void setCreatDate(java.util.Date creatDate) {
	 	 this.creatDate = creatDate;
	 }

	 /** 权重 */
	 public Integer getWeight() { 
	 	 return weight;
	 }
	 /** 权重 */
	 public void setWeight(Integer weight) {
	 	 this.weight = weight;
	 }

	 /** 参数编号 */
	 public String getParameterId() { 
	 	 return parameterId;
	 }
	 /** 参数编号 */
	 public void setParameterId(String parameterId) {
	 	 this.parameterId = parameterId;
	 }

}

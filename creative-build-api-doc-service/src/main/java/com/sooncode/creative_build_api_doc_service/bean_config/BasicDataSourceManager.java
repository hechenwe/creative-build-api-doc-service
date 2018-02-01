package com.sooncode.creative_build_api_doc_service.bean_config;



import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@RefreshScope
public class BasicDataSourceManager {

	@Value("${api-doc-service.dbcp.driver}")
	private String driver;

	@Value("${api-doc-service.dbcp.url}")
	private String url;

	@Value("${api-doc-service.dbcp.username}")
	private String username;

	@Value("${api-doc-service.dbcp.password}")
	private String password;

	@Value("${api-doc-service.dbcp.maxActive}")
	private Integer maxActive;

	@Value("${api-doc-service.dbcp.initialSize}")
	private Integer initialSize;

	@Value("${api-doc-service.dbcp.maxWait}")
	private Integer maxWait;

	@Value("${api-doc-service.dbcp.maxIdle}")
	private Integer maxIdle;

	@Value("${api-doc-service.dbcp.minIdle}")
	private Integer minIdle;

	@Value("${api-doc-service.dbcp.timeBetweenEvictionRunsMillis}")
	private Integer timeBetweenEvictionRunsMillis;

	@Value("${api-doc-service.dbcp.minEvictableIdleTimeMillis}")
	private Integer minEvictableIdleTimeMillis;

	@Value("${api-doc-service.dbcp.removeAbandoned}")
	private Boolean removeAbandoned;

	@Value("${api-doc-service.dbcp.removeAbandonedTimeout}")
	private Integer removeAbandonedTimeout;

	@Value("${api-doc-service.dbcp.testWhileIdle}")
	private Boolean testWhileIdle;

	@Value("${api-doc-service.dbcp.testOnBorrow}")
	private Boolean testOnBorrow;

	@Value("${api-doc-service.dbcp.testOnReturn}")
	private Boolean testOnReturn;

	@Value("${api-doc-service.dbcp.validationQuery}")
	private String validationQuery;

	@Bean("dataSource")
	@Primary //在同样的DataSource中，首先使用被标注的DataSource 
	@RefreshScope
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setMaxActive(maxActive);
		ds.setInitialSize(initialSize);
		ds.setMaxWait(maxWait);
		ds.setMaxIdle(maxIdle);
		ds.setMinIdle(minIdle);
		ds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		ds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		ds.setRemoveAbandoned(removeAbandoned);
		ds.setRemoveAbandonedTimeout(removeAbandonedTimeout);
		ds.setTestWhileIdle(testWhileIdle);
		ds.setTestOnBorrow(testOnBorrow);
		ds.setTestOnReturn(testOnReturn);
		ds.setValidationQuery(validationQuery);
		return ds;
	}
	
 
}

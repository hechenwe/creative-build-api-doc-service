package com.sooncode.creative_build_api_doc_service.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;

@Order(1)

@WebFilter(filterName = "corsFilter", urlPatterns = "/*")
public class CorsFilter implements Filter {  
  
	private final Log logger = LogFactory.getLog(getClass());
  
  
  
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
       
    	logger.info("[跨域过滤器]");
    	HttpServletResponse response = (HttpServletResponse) res;  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        //Access-Control-Allow-Origin
        /**
         * allowed-origins="*"
			allowed-methods="GET,POST,PUT,DELETE,HEAD,OPTIONS"
			allowed-headers="DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,accept,Content-Type,token,userId,userName"
			allow-credentials="true"
			exposed-headers="Content-Type,Set-Cookie,Date,Cache-Control,Accept"
			max-age="1800" />
         */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,HEAD,OPTIONS");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,accept,Content-Type");  
        chain.doFilter(req, res);  
    }  
    public void init(FilterConfig filterConfig) {}  
    public void destroy() {}  
}  
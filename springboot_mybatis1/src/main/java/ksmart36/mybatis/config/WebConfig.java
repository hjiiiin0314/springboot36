package ksmart36.mybatis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ksmart36.mybatis.interceptor.CommonInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private CommonInterceptor commonInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//부트스트랩 사용할 때 하위경로를 다 써줘야한다.
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**");
		/*
		 * //부트스트랩 사용할 때 하위경로를 다 써줘야한다.
		 * ex)  .excludePathPatterns("/fonts/**")
		 * 	    .excludePathPatterns("/img/**")
		 *	    .excludePathPatterns("/js/**");
		 * 
		 * */
	}
}

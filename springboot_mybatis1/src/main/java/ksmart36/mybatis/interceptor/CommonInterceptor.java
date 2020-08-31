package ksmart36.mybatis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//이 객체를 생성하고 빌드
@Component
public class CommonInterceptor implements HandlerInterceptor{
	
	
	private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 요청이 일어났을 때 컨트롤러에 가기전단계 (전)
		// 트루일 때 컨트롤러에 진입 , 펄스일경우 여기서 중단 
		// 로그인 할 때 세션값이 없으면 로그인화면으로 보낼 수 이따.
		log.info("CommonInterceptor ======================================START");
		log.info("ACCESS INFO ======================================= START");
		log.info("PORT  :::: {} ",request.getLocalPort());
		log.info("serverName  :::: {} ",request.getServerName());
		log.info("getMethod  :::: {} ",request.getMethod());
		log.info("getRequestURI  :::: {} ",request.getRequestURI());
		log.info("ACCESS INFO ======================================= END");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 컨트롤러에 대해서 역할이 끝났을 때 (후)
		log.info("CommonInterceptor ======================================= END");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}

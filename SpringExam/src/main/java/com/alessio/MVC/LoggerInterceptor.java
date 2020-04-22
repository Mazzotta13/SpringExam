package com.alessio.MVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggerInterceptor implements HandlerInterceptor {
	private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandler(), URI: "+request.getRequestURI() + " - session: " + request.getSession().getId());
		// if (request.isRequestedSessionIdValid()) response.sendRedirect("/rest"); // Just a test...
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle(), URI: "+request.getRequestURI());
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion(), URI: "+request.getRequestURI() + " - locale: " + response.getLocale());
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}

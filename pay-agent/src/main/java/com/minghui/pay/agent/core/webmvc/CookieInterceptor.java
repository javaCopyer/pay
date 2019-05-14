package com.minghui.pay.agent.core.webmvc;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.minghui.pay.common.constants.AuthConstants;
import com.minghui.pay.common.enums.ResEnum;
import com.minghui.pay.common.utils.ServletUtils;
@Component
public class CookieInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		Cookie[] cookies = request.getCookies();
//		String deviceId = request.getHeader(AuthConstants.HEADER_DEVICEID);
//		boolean isHas = false;
//		
//		if (cookies.length > 0) {
//			for (Cookie cookie : cookies) {
//				if (StringUtils.equals(cookie.getName(), AuthConstants.COOKIE_NAME)) {
//					isHas = true;
//					break;
//				}
//			}
//		} 
//
//		
//		
//		if (!isHas) {
//			if (StringUtils.isNotBlank(deviceId)) {
//				ServletUtils.outPrintFail(request, response, ResEnum.AUTH_EXPIRED_COOKIE.getCode(), ResEnum.AUTH_EXPIRED_COOKIE.getMsg());
//			}
//			Cookie cookie = new Cookie(AuthConstants.COOKIE_NAME, "123");
//			response.addCookie(cookie);
//		}
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}

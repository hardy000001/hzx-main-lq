package com.lq.lss.controller.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestLocal {

	private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();

	private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();

	public static void setRequestLocal(HttpServletRequest request) {
		RequestLocal.requestThreadLocal.set(request);
	}

	public static HttpServletRequest getRequest() {
		return RequestLocal.requestThreadLocal.get();
	}

	public static void setResponseLocal(HttpServletResponse response) {
		RequestLocal.responseThreadLocal.set(response);
	}

	public static HttpServletResponse getResponse() {
		return RequestLocal.responseThreadLocal.get();
	}

	public static HttpSession getSession() {
		return RequestLocal.getRequest().getSession();
	}
}

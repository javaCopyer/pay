package com.minghui.pay.common.utils;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.alibaba.fastjson.JSON;
import com.minghui.pay.common.enums.ResEnum;


/**
 * Http与Servlet工具类.
 * 类描述: TODO<br/> 
 * 修改人: alex<br/>
 * 修改时间: 2015-6-28 下午6:56:52<br/>
 */
@SuppressWarnings("all")
public class ServletUtils {
	private static Logger logger = LoggerFactory.getLogger(ServletUtils.class);

	//-- Content Type 定义 --//
	public static final String TEXT_TYPE = "text/plain";
	public static final String JSON_TYPE = "application/json";
	public static final String XML_TYPE = "text/xml";
	public static final String HTML_TYPE = "text/html";
	public static final String JS_TYPE = "text/javascript";
	public static final String EXCEL_TYPE = "application/vnd.ms-excel";

	//-- Header 定义 --//
	public static final String AUTHENTICATION_HEADER = "Authorization";

	//-- 常用数值定义 --//
	public static final long ONE_YEAR_SECONDS = 60 * 60 * 24 * 365;
	
	/**
	 * 如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，
	 * 那么真正的用户端的真实IP则是取X-Forwarded-For中第一个非unknown的有效IP字符串。
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request){
		String ip = request.getHeader("X-Forwarder-For");
		if((StringUtils.isBlank(ip)) || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-Ip");
			if(StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)){
				ip = request.getHeader("WL-Proxy-Client-Ip");
			}
		}else{
			String[] ipArr = ip.split(",");
			for(String IP : ipArr){
				if(!"unknown".equalsIgnoreCase(IP)){
					ip = IP;
					break;
				}
			}
		}
		if((StringUtils.isBlank(ip)) || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 设置客户端缓存过期时间 的Header.
	 */
	public static void setExpiresHeader(HttpServletResponse response, long expiresSeconds) {
		//Http 1.0 header
		response.setDateHeader("Expires", System.currentTimeMillis() + expiresSeconds * 1000);
		//Http 1.1 header
		response.setHeader("Cache-Control", "private, max-age=" + expiresSeconds);
	}

	/**
	 * 设置禁止客户端缓存的Header.
	 */
	public static void setDisableCacheHeader(HttpServletResponse response) {
		//Http 1.0 header
		response.setDateHeader("Expires", 1L);
		response.addHeader("Pragma", "no-cache");
		//Http 1.1 header
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
	}

	/**
	 * 设置LastModified Header.
	 */
	public static void setLastModifiedHeader(HttpServletResponse response, long lastModifiedDate) {
		response.setDateHeader("Last-Modified", lastModifiedDate);
	}

	/**
	 * 设置Etag Header.
	 */
	public static void setEtag(HttpServletResponse response, String etag) {
		response.setHeader("ETag", etag);
	}

	/**
	 * 根据浏览器If-Modified-Since Header, 计算文件是否已被修改.
	 * 
	 * 如果无修改, checkIfModify返回false ,设置304 not modify status.
	 * 
	 * @param lastModified 内容的最后修改时间.
	 */
	public static boolean checkIfModifiedSince(HttpServletRequest request, HttpServletResponse response,
			long lastModified) {
		long ifModifiedSince = request.getDateHeader("If-Modified-Since");
		if ((ifModifiedSince != -1) && (lastModified < ifModifiedSince + 1000)) {
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			return false;
		}
		return true;
	}

	/**
	 * 根据浏览器 If-None-Match Header, 计算Etag是否已无效.
	 * 
	 * 如果Etag有效, checkIfNoneMatch返回false, 设置304 not modify status.
	 * 
	 * @param etag 内容的ETag.
	 */
	public static boolean checkIfNoneMatchEtag(HttpServletRequest request, HttpServletResponse response, String etag) {
		String headerValue = request.getHeader("If-None-Match");
		if (headerValue != null) {
			boolean conditionSatisfied = false;
			if (!"*".equals(headerValue)) {
				StringTokenizer commaTokenizer = new StringTokenizer(headerValue, ",");

				while (!conditionSatisfied && commaTokenizer.hasMoreTokens()) {
					String currentToken = commaTokenizer.nextToken();
					if (currentToken.trim().equals(etag)) {
						conditionSatisfied = true;
					}
				}
			} else {
				conditionSatisfied = true;
			}

			if (conditionSatisfied) {
				response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				response.setHeader("ETag", etag);
				return false;
			}
		}
		return true;
	}

	/**
	 * 设置让浏览器弹出下载对话框的Header.
	 * 
	 * @param fileName 下载后的文件名.
	 */
	public static void setFileDownloadHeader(HttpServletResponse response, String fileName) {
		try {
			//中文文件名支持
			String encodedfileName = new String(fileName.getBytes(), "ISO8859-1");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	/**
	 * 设置让浏览器弹出下载Excel对话框的Header.
	 * 
	 * @param fileName 下载后的文件名.
	 */
	public static void setExcelDownloadHeader(HttpServletResponse response, String fileName) {
		response.setContentType(EXCEL_TYPE);
		setFileDownloadHeader(response, fileName);
	}
 
	/**
	 * 将处理成功结果(默认提示信息）返回给客服端ajax脚本
	 * @param response
	 */
	public static void outPrintSuccess(HttpServletRequest request, HttpServletResponse response) {
		outPrintSuccess(request, response, ResEnum.SUCCESS.getMsg(), null);
	}
	
	/**
	 * 将处理成功结果(用户设置提示信息）返回给客服端ajax脚本
	 * @param response
	 * @param msg
	 */
	public static void outPrintSuccess(HttpServletRequest request, HttpServletResponse response, String msg) {
		outPrintSuccess(request, response, msg, null);
	}
	
	/**
	 * 将处理成功结果(用户返回的数据）返回给客服端ajax脚本
	 * @param response
	 * @param map 用户返回的数据
	 */
	public static void outPrintSuccess(HttpServletRequest request, HttpServletResponse response, Object obj) {
		outPrintSuccess(request, response, ResEnum.SUCCESS.getMsg(), obj);
	}
	
	
	/**
	 * 将处理成功结果(用户设置提示信息,用户返回的数据）返回给客服端ajax脚本
	 * @param response
	 * @param msg  用户设置提示信息
	 * @param map  用户返回的数据
	 */
	public static void outPrintSuccess(HttpServletRequest request, HttpServletResponse response, String msg, Object obj) {
		flushResult(request, response, buildRs(ResEnum.SUCCESS.getCode(), msg, obj));
	}
	
	/**
	 * 将处理失败结果（用户设置失败提示信息） 返回给客服端ajax脚本
	 * @param response
	 * @param msg  用户设置失败提示信息
	 */
	public static void outPrintFail(HttpServletRequest request, HttpServletResponse response,String errorCode, String msg) {
		flushResult(request, response, buildRs(errorCode, msg, null));
	}
	
	
	
	/**
	 * 将用户数据 msg 不进行封装，直接传递给客服端ajax
	 * @param response
	 * @param msg
	 */
	public static void outPrintMsg(HttpServletRequest request, HttpServletResponse response, String msg) {
		flushResult(request, response, msg);
	}
	
 
	
	/**
	 * 返回信息最后JSON格式
	 * @param success  处理结果是否成功
	 * @param msg  提示信息
	 * @param map  用户数据
	 * @return
	 */
	private static String buildRs(String errorCode, String msg, Object obj){
		StringBuilder strb = new StringBuilder("{\"errorCode\":");
		strb.append("\"").append(errorCode).append("\"")
			.append(",\"msg\":\"").append(null == msg ? "" : msg).append("\"");
//			if(obj!=null){
				strb.append(",\"datas\":").append(null == obj ? "{}" : JSON.toJSONString(obj));
//			}
			strb.append("}");
		
		logger.debug("rs：[ {} ]", strb);
 
		
		return strb.toString();
	}
	
	
	/**
	 * 将用户数据返回给相应的客服端请求ajax页面
	 * @param response
	 * @param str
	 */
	private static void flushResult(HttpServletRequest request, HttpServletResponse response, String str){
		setDisableCacheHeader(response);
		response.setHeader("Content-type", JSON_TYPE);  
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			logger.debug("用户数据返回: [ {} ]",  str);
			
			out.print(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != out){
				out.close();
			}
		}
	}
	
	/**
	 * 返回xml格式数据到客服端页面
	 * @param response
	 * @param xml
	 */
	public static void outPrintXml(HttpServletRequest request, HttpServletResponse response, String xml){
		setDisableCacheHeader(response);
		response.setHeader("Content-type", XML_TYPE);  
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			logger.debug("用户数据返回: [ {} ]",  xml);
			
			out.print(xml);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != out){
				out.close();
			}
		}
	}
	
	/**
	 * 返回TEXT格式数据到客服端页面
	 * @param response
	 * @param xml
	 */
	public static void outPrintText(HttpServletResponse response, String xml){
		setDisableCacheHeader(response);
		response.setHeader("Content-type", TEXT_TYPE);  
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			logger.debug("用户数据返回: [ {} ]",  xml);
			
			out.print(xml);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != out){
				out.close();
			}
		}
	}
	
	public static void downLoad(HttpServletRequest request, HttpServletResponse response,String filePath){
		File file = new File(filePath);
		String fileName = file.getName();
		OutputStream os = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			byte b[] = new byte[is.available()];
			is.read(b);
			// 清空response
            response.reset();
			response.setContentType("application/octet-stream");// 设置为下载application/x-download
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("UTF-8"), "ISO8859-1")); // 这个很重要
			response.addHeader("Content-Length", "" + file.length());
			os = new BufferedOutputStream(response
					.getOutputStream());
			os.write(b);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void sendErrorMsg(HttpServletResponse response,String msg){
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			out.print("<script>alert('"+msg+"');</script>");
			if(null != out){
				out.flush();
				out.close();
			}
		}
	}
	
	public static String convertErrors2Msg(Errors errors){
		List<FieldError> listErrors = errors.getFieldErrors();
		StringBuffer sb = new StringBuffer("");
		
		for(FieldError fieldError : listErrors){
			sb.append(fieldError.getDefaultMessage() + "<br/>");
			if(logger.isDebugEnabled()){
				logger.debug(fieldError.getDefaultMessage() + " " + fieldError.getRejectedValue() + " " + fieldError.getCode());
			}
		}
		
		return sb.toString();
	}
	
	public static String getDomainNoScheme(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getServerName() + ":" + request.getServerPort() + path;
		if (basePath.endsWith(":80")) {
			basePath = basePath.substring(0, basePath.indexOf(":80"));
		}
		return basePath;
	}
	
	public static void main(String[] args) {
		
	}
	
	public static String getUserLoginDomain(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
		if (basePath.endsWith(":80/")) {
			basePath = basePath.substring(0, basePath.indexOf(":80/"));
		}
		return basePath;
	}
	
	public static String getWebDomain(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		if (basePath.endsWith(":80/")) {
			basePath = basePath.substring(0, basePath.indexOf(":80/")) + "/";
		}
		return basePath;
	}
	
	/**
	 * 获取当前页面的名称
	 * @author Jackey <jackey@xxx.com>
	 * @param request
	 * @return
	 */
	public static String getWebPageName(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int hasParams = uri.indexOf("?");
		String name = "";
		if (hasParams > -1) {
			name = uri.subSequence(uri.lastIndexOf("/") + 1, uri.indexOf("?")).toString().toLowerCase();
		}
		else {
			name = uri.substring(uri.lastIndexOf("/") + 1).toLowerCase();
		}
			
		if (name.indexOf(".") > -1) {
			return name.subSequence(0, name.indexOf(".")).toString();
		}
		return name;
	}
	
	
	
}

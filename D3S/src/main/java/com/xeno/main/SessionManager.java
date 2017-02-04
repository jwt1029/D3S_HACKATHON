package com.xeno.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xeno.service.TestService;

/**
 * Handles requests for the application home page.
 */
public class SessionManager {
	@Resource(name = "testService")
	private TestService testService;

	private static final Logger logger = LoggerFactory.getLogger(SessionManager.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	public boolean isLogin(Cookie[] cookies) {
		String userkey = null;
		String session = null;
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("session")){
					session = cookie.getValue();
				}
			}
			if(userkey != null && session != null)
				if(checkSession(userkey, session))
					return true;
		}
		return false;
	}
	
	public String makeSession(String userkey) {
		System.out.println("Session Manager : " + testService);
		try {
			return convertSHA256(userkey + testService.makesession(userkey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkSession(String userkey, String session) {
		if(makeSession(userkey).equals(session))
			return true;
		else
			return false;
	}
	
	public String convertSHA256(String str) {
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}
}

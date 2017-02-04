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
@Controller
public class LoginController {
	@Resource(name = "testService")
	private TestService testService;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/trylogin", method = RequestMethod.POST)
	public ResponseEntity<String> trylogin(Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Login request from : " + request.getParameter("id"));
		SessionManager smanager = new SessionManager();
		JSONObject jsonobj = new JSONObject();

		HashMap<String, Object> map = new HashMap<>();
		map.put("userid", request.getParameter("id"));
		map.put("userpw", convertSHA256(request.getParameter("password")));
		
		try {
			String userkey = testService.check_login(map);
			if (userkey != null) {
				jsonobj.put("success", true);
				jsonobj.put("redirect", "./");
				response.addCookie(new Cookie("session", smanager.makeSession(userkey)));
				response.addCookie(new Cookie("userkey", userkey));
				return new UTF8Response(jsonobj.toJSONString(), "json").entity;
			}
			else {
				jsonobj.put("success", false);
				return new UTF8Response(jsonobj.toJSONString(), "json").entity;
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonobj.put("success", false);
			return new UTF8Response(jsonobj.toJSONString(), "json").entity;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<String> logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Logged out");

		JSONObject jsonobj = new JSONObject();
		jsonobj.put("redirect", "./");

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("session")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}

		return new UTF8Response(jsonobj.toJSONString(), "json").entity;
	}

	@RequestMapping(value = "/trysignup", method = RequestMethod.POST)
	public ResponseEntity<String> trysignup(Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Sign up request");

		HashMap<String, Object> map = new HashMap<>();
		map.put("userid", request.getParameter("id"));
		map.put("userpw", convertSHA256(request.getParameter("password")));
		map.put("phone_number", request.getParameter("phone_number"));
		map.put("email", request.getParameter("email"));

		try {
			testService.register(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Register complete");
		System.out.println("New user : " + request.getParameter("id"));
		return null;
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

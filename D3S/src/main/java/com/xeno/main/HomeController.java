package com.xeno.main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xeno.service.TestService;

import sun.misc.BASE64Decoder;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource(name = "testService")
	private TestService testService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		SessionManager smanager = new SessionManager();
		Cookie[] cookies = request.getCookies();

		if (smanager.isLogin(cookies))
			model.addAttribute("loginstatus", "Logout");
		else
			model.addAttribute("loginstatus", "Login");

		return "home";
	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(Locale locale, Model model) {
		System.out.println("Request : Buy");

		return "buy";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		System.out.println("Request : Login");

		return "login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) {
		System.out.println("Request : SignUp");

		return "signup";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		System.out.println("Request : Test");
		
		return "test";
	}
	
	@RequestMapping(value = "/getpixeldatas", method = RequestMethod.POST)
	public ResponseEntity<String> pixeldatas(Locale locale, Model model) {
		JSONObject jsondata = new JSONObject();
		JSONArray jsonarr = new JSONArray();
		try {
			List<HashMap<String, Object>> dbData = testService.getPixelDatas();
			System.out.println("DBDT : " + dbData.get(0));
			for(HashMap<String, Object> data : dbData) {
				JSONObject obj = new JSONObject();
				obj.put("x", data.get("x"));
				obj.put("y", data.get("y"));
				obj.put("color", data.get("color"));
				obj.put("link", data.get("link"));
				obj.put("owner_id", data.get("owner_id"));
				jsonarr.add(obj);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("SENDDATA : " + jsonarr.toJSONString());
		return new UTF8Response(jsonarr.toJSONString(), "json").entity;
	}
	
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public ResponseEntity<String> uploadImage(Locale locale, Model model, HttpServletRequest request) {
		JSONObject jsondata = new JSONObject();
		
		try {
			readImage();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		String imageString = request.getParameter("image");
//		try {
//			if (!imageString.equals("") && imageString != null) {
//				logger.info("IMAGESTRING : " + imageString);
//				String realImageString = imageString.split(",")[1];
//				BASE64Decoder decoder = new BASE64Decoder();
//				byte[] imgBytes = decoder.decodeBuffer(realImageString.replace(" ", "+"));
//
//				BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imgBytes));
//
//				logger.debug("File Saved!");
//				System.out.println("Saved 4");
//				
//				
//				BufferedImage loadedImage = ImageIO.read(new File("pig.png"));
//				for(int i=0;i<loadedImage.getHeight();i++)
//					for(int j=0;j<loadedImage.getWidth();i++) {
//						int color = loadedImage.getRGB(i, j);
//						System.out.println("Color : " + color);
//					}
//				
//				
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		jsondata.put("success", true);
		
		return new UTF8Response(jsondata.toJSONString(), "json").entity;
	}

	private void readImage() throws IOException {
		// TODO Auto-generated method stub

		BufferedImage loadedImage = ImageIO.read(new File("pig.png"));
		for(int i=0;i<loadedImage.getHeight();i++)
			for(int j=0;j<loadedImage.getWidth();i++) {
				int color = loadedImage.getRGB(i, j);
				System.out.println("Color : " + color);
			}
	}
}

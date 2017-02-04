package com.xeno.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TestService {
	public List<HashMap<String, Object>> loadContents(String id) throws Exception;

	public void register(HashMap<String, Object> map) throws Exception;

	public String check_login(HashMap<String, Object> map) throws Exception;

	public String makesession(String userkey) throws Exception;

	public List<HashMap<String, Object>> getPixelDatas() throws Exception;

}
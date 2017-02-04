package com.xeno.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xeno.service.TestService;

import com.xeno.dao.TestDBConnDao;


@Service("testService")
public class TestServiceImpl implements TestService{
	
    @Resource(name="testDBConnDao")
    private TestDBConnDao testDBConnDao;
	
	public List<HashMap<String, Object>> loadContents(String id) {
		return testDBConnDao.loadContents(id);
	}
	
	public void register(HashMap<String, Object> map) {
		testDBConnDao.register(map);
	}
	
	public String check_login(HashMap<String, Object> map) {
		return testDBConnDao.check_login(map);
	}
	
	public String makesession(String userkey) {
		return testDBConnDao.makesession(userkey);
	}
	
	public List<HashMap<String, Object>> getPixelDatas() {
		return testDBConnDao.getPixelDatas();
	}
}
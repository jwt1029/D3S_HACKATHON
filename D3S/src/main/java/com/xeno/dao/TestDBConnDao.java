package com.xeno.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDBConnDao")
public class TestDBConnDao {

	@Autowired
	private SqlSession sqlSession;

	public List<HashMap<String, Object>> loadContents(String id) {
		return sqlSession.selectList("userMapper.loadContents", id);
	}

	public void register(HashMap<String, Object> map) {
		sqlSession.selectList("userMapper.register_account", map);
	}

	public String check_login(HashMap<String, Object> map) {
		return sqlSession.selectOne("userMapper.check_login", map);
	}

	public String makesession(String userkey) {
		return sqlSession.selectOne("userMapper.getpassword", userkey);
	}

	public List<HashMap<String, Object>> getPixelDatas() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userMapper.getpixeldatas");
	}
}

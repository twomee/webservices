package com.ido.sprniglogin.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean insert(String user,String pass) {
		String sql = "INSERT INTO users (user, password) VALUES (?, ?)";
		return jdbcTemplate.update(sql,user, pass) > 0;
	}

	public boolean update(String user,String pass) {
		String sql = "UPDATE users SET password = ? where user = ?";
		return jdbcTemplate.update(sql,pass, user) > 0;
	}

	public boolean delete(String pass) {
		String sql = "DELETE FROM users WHERE user=?";
		return jdbcTemplate.update(sql,pass) > 0;
	}
	
	
	

}

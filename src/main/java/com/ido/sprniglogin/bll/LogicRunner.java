package com.ido.sprniglogin.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicRunner {
	
	@Autowired
	UserDAO userDAO;
	
	public boolean insertUserToDB(String user,String pass) {
		return userDAO.insert(user, pass); 
	}
	
	public boolean updateUserDetailsOnDB(String user,String pass) {
		return userDAO.update(user, pass); 
	}
	
	public boolean deleteUserFromDB(String pass) {
		return userDAO.delete(pass); 
	}
	
}

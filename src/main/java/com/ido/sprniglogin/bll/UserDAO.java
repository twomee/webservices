package com.ido.sprniglogin.bll;

public interface UserDAO {
	public boolean insert(String user,String pass);
	public boolean update(String user,String pass);
	public boolean delete(String user);
}

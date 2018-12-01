package com.ido.sprniglogin.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ido.sprniglogin.bll.LogicRunner;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	@Autowired
	LogicRunner logicRunner;
	private static final Gson gson = new Gson();
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {
		return "welcome";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain() {
		return "welcome again";
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> insertUser(HttpEntity<String> httpEntity) {
		try {
	//		HashMap<String, Boolean> map = new HashMap<>();
			String stringData = httpEntity.getBody();
			JSONObject jsonData = new JSONObject(stringData);
			String user = jsonData.getString("user");
			String pass = jsonData.getString("pass");
			boolean result = logicRunner.insertUserToDB(user, pass);
	//		map.put("response", result);
			return ResponseEntity.ok(gson.toJson(result));
		}
		catch (Exception e) {
			return ResponseEntity.ok(gson.toJson(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> UpdateUser(HttpEntity<String> httpEntity) {
		try {
	//		HashMap<String, Boolean> map = new HashMap<>();
			String stringData = httpEntity.getBody();
			JSONObject jsonData = new JSONObject(stringData);
			String user = jsonData.getString("user");
			String pass = jsonData.getString("pass");
			boolean result = logicRunner.updateUserDetailsOnDB(user, pass);
			System.out.println(gson.toJson(result));
	//		map.put("response", result);
			return ResponseEntity.ok(gson.toJson(result));
		}
		catch (Exception e) {
			return ResponseEntity.ok(gson.toJson(e.getMessage()));
		}
		
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> deleteUser(HttpEntity<String> httpEntity) {
		try {
	//		HashMap<String, Boolean> map = new HashMap<>();
			String stringData = httpEntity.getBody();
			JSONObject jsonData = new JSONObject(stringData);
			String user = jsonData.getString("user");
			boolean result = logicRunner.deleteUserFromDB(user);
	//		map.put("response", result);
			return ResponseEntity.ok(gson.toJson(result));
		}
		catch (Exception e) {
			return ResponseEntity.ok(gson.toJson(e.getMessage()));
		}
	}


}
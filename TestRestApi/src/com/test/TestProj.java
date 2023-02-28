package com.test;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;

public class TestProj {
	
	private static final String getBasicAuthenticationHeader(String username, String password) {
	    String valueToEncode = username + ":" + password;
	    String encodedString = "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
	    return encodedString;
	}

	
	public void getapiResponse() {
		System.out.println("program started");
		
		try {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
		  .GET()
		  .uri(new URI("https://api.thousandeyes.com/v6/users.json"))
		  .header("Authorization", getBasicAuthenticationHeader("p.rohitgnp@yahoo.co.in", "279894d1-5c57-4d5b-8666-f41fdecc0e3b"))
		  .build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		System.out.println("Status {}"+ response.statusCode());
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("program ended");
	}
	
	public void getThousandEyesUserList() {
		System.out.println("program started");
		
		try {
			String username = "p.rohitgnp@yahoo.co.in";
		//	String pwd = "g92cfzqjz7y80je7rko5fim8ti6e9tht";
			String pwd = "8gp07y35l0xsad9xt59fi3nkisgsw4vg";
			String basicAuth = "Basic "+username+":"+pwd;
		URL url =new URL("https://api.thousandeyes.com/v6/users.json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", getBasicAuthenticationHeader(username,pwd));
		
		System.out.println("all values set");
		
		if(conn.getResponseCode()!=200) {
			System.out.println("failed="+conn.getResponseCode()+ ": "+conn.getResponseMessage());
		}else {
			System.out.println("response code="+conn.getResponseCode()+"; message:"+conn.getResponseMessage());
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("program ended");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestProj obj = new TestProj();
	//	obj.getapiResponse();
		obj.getThousandEyesUserList();
	}

}

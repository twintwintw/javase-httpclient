package com.demo;

import org.apache.http.client.HttpClient;

import com.demo.util.HttpUtils;
import com.demo.util.HttpUtils2;

public class Demo01 {

	public static void main(String[] args) {
		
		String url = "http://www.azyxw.com/json/index.php";
		String url_pic = "http://www.azyxw.com/download/file/pic/20150814/blahxrgnjyr.png";
		
	//	System.out.println(HttpUtils.getNetString2(url));
		
	//	HttpUtils.savePic(url_pic);
		
		System.out.println(HttpUtils2.getNetString("http://172.21.19.200:8080/lesson_http_server/SecondServlet"));
		
		//System.out.println(HttpUtils2.login("http://localhost:8888/lesson_server20180803/ServletLogin", "wan", "abc123"));

	}
	
}


package com.demo.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils2 {
	
	public static String login(String path,String username,String password){
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		BufferedInputStream bis = null;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(1000 * 5);
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			os = conn.getOutputStream();
			os.write(("&username=" + username + "&password=" + password).getBytes());
			
			os.flush();
			os.close();
			
			conn.connect();
			
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
				
				is = conn.getInputStream();
				bis = new BufferedInputStream(is);
				
				byte[] bs = new byte[1024];
				int len = 0;
				while((len = bis.read(bs, 0, bs.length)) != -1){
					
					stringBuffer.append(new String(bs, 0, len));
					
				}
				
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(null != bis){
				
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(null != is){
				
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		return stringBuffer.toString();
		
		
	}

	public static String getNetString(String path){
		
		StringBuffer stringBuffer = new StringBuffer("");
		
		BufferedInputStream bis = null;
		InputStream is = null;
		
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
				
				is = conn.getInputStream();
				bis = new BufferedInputStream(is);
				
				byte[] bs = new byte[1024];
				int len = 0;
				while((len = bis.read(bs, 0, bs.length)) != -1){
					
					stringBuffer.append(new String(bs, 0, len));
					
				}
				
			}

			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(null != bis){
				
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(null != is){
				
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		return stringBuffer.toString();
		
		
	}
	
}

package com.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public final class HttpUtils {
	
	//±£´æÍ¼Æ¬
	public static void savePic(String path){
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(path);
		
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			
			HttpResponse response = httpClient.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200){
				
				is = response.getEntity().getContent();
				fos = new FileOutputStream(new File("D:\\test.png"));
				
				byte[] bs = new byte[1024];
				int len = 0;
				while((len = is.read(bs, 0, bs.length)) != -1){
					
					fos.write(bs, 0, len);
					
				}
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(null != fos){
				
				try {
					fos.flush();
					fos.close();
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
		
		
	}
	
	public static String getNetString2(String path){
		
		StringBuilder stringBuilder = new StringBuilder("");
		
		HttpClient httpClient = new DefaultHttpClient();
		
		HttpGet httpGet = new HttpGet(path);
	
		InputStream is = null;
		try {
			
			HttpResponse httpResponse = httpClient.execute(httpGet);
		 	
			if(httpResponse.getStatusLine().getStatusCode() == 200){
				
				is = httpResponse.getEntity().getContent();
				
				byte[] bs = new byte[1024];
				int len = 0;
				while((len = is.read(bs, 0, bs.length)) != -1){
					
					stringBuilder.append(new String(bs, 0, len));
					
				}
			
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(null != is){
				
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return stringBuilder.toString();
		
	}

	public static String getNetString(String path){
		
		String result = "";
		
		HttpClient httpClient = new DefaultHttpClient();
		
		HttpGet httpGet = new HttpGet(path);
		
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			
			int code = httpResponse.getStatusLine().getStatusCode();
			
			if(code == 200){
				
				HttpEntity httpEntity = httpResponse.getEntity();
				
				result = EntityUtils.toString(httpEntity);
				
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}

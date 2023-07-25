package com.qatouch.apitestsync;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class AddResultNew {
	
	public static String QA_TOUCH_APITOKEN = "****APIToken*******";
	public static String QA_TOUCH_URL = "https://api.qatouch.com/api/v1";
	public static String QA_TOUCH_DOMAIN = "*****Domain****";
	static String status;


    public static void main(String[] args) {
      
        System.out.println("Add Result URL");
        
        }
    //Add Test Run Status
    
    public static void addTestRunStatus(String[] args, String test_run, String project, String run_result,String newstatus) { 
    	
    
    	       String url = "https://api.qatouch.com/api/v1/";
    
    	       String addresulturl =url + "testRunResults/status?" + "status=" + newstatus + "&" + "project=" + project + "&" + "test_run=" + test_run + "&" + "run_result=" + run_result;  
    	       System.out.println("Add Result URL");
    	       System.out.println(addresulturl);		
    	       String addresult = addTestResults(QA_TOUCH_APITOKEN, QA_TOUCH_DOMAIN, addresulturl);
    	       System.out.println(addresult);
    	       
    	    }
    
     public static String addTestResults(String apiToken, String domain, String addresulturl) {
    	try {
            URL urlObj = new URL(addresulturl);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            connection.setRequestMethod("POST");
            connection.setRequestProperty("api-token", apiToken);
            connection.setRequestProperty("domain", domain);
            connection.setRequestProperty("url", addresulturl); 
            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
  
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                
                in.close();
                System.out.println(response);
                return response.toString();
                
                } else {
                return "Error: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}


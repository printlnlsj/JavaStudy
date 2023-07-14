package com.test.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {
    public static void main(String[] args) {
        // http request body 부분
        String trgetURL = "http://127.0.0.1/jdbctest_memberRegistry";   // 데이터베이스에 데이터를 넣는 서블릿
        String parameters = "userid=mysky&username=최지현&age=38";
        TestHttpRequest.TestHttpRequest(trgetURL, parameters);
    }
}


class TestHttpRequest{
    public static void TestHttpRequest(String trgetURL, String parameters){
        
        HttpURLConnection connection = null;
        
        try {
            URL url = new URL(trgetURL);
            connection = (HttpURLConnection) url.openConnection();
            
            // http request header 부분
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-Type", "application/x-www-form-urlencoded"); // content-type 속성 : application 어쩌구저쩌구~ 부분
            connection.setRequestProperty("content-Language", "ko-KR"); // locale 표기법
            connection.setUseCaches(false); // 캐시 자체를 생성하지 마라 라고 하는 것
            
            // OutputStream으로 POST 데이터를 전송
            connection.setDoOutput(true);

            // Request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(parameters.getBytes("utf-8"));
            wr.flush();
            wr.close();

            // Response
            int responseCode = connection.getResponseCode();
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

            StringBuilder response = new StringBuilder();
            String line;
            while((line = rd.readLine())!=null){
                response.append(line).toString();
                response.append("\r\n");
            }
            rd.close();

            System.out.println("HTTP 응답 코드 : " + responseCode);
            System.out.println("HTTP 응답 헤더 : " + connection.getHeaderFields());
            System.out.println("HTTP Body : " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(connection != null)
                connection.disconnect();
        }
    }

}
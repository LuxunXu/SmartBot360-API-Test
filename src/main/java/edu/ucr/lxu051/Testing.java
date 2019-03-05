package edu.ucr.lxu051;

import java.io.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Testing {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        String json = "{\"userPhone\":\"1-951-455-5987\", \"functionID\":\"TempBot1944\", \"securityToken\":\"prestontest\"}";
        String url = "https://inlandempiredocs.com/test/smartdash/public/kickOffBotSMS";
        //String response = sentence.replaceAll("\\s", "%20").replaceAll("'", "%27");
        String test = getResult(url, json);
    }

    public static String getResult(String url, String json) throws IOException {
        String rs = "";
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            //httpPost.setHeader("Authorization", "Bearer " +  token);
            httpPost.setHeader("Content-Type",  "application/json");

            CloseableHttpResponse response = client.execute(httpPost);
            System.out.println(("Response code: " + response.getStatusLine().getStatusCode()));
            HttpEntity responseEntity = response.getEntity();

            // Read the contents of an entity and return it as a String.
            rs = EntityUtils.toString(responseEntity);
            System.out.println(rs);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rs;
    }
}

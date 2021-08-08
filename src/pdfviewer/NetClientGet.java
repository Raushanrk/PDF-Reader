/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfviewer;

/**
 *
 * @author raushan kumar
 * 
// */
////
package restclient;
import java.util.*;
import org.json.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetClientGet {
//    public static void main(String[] args) {
    public JSONArray returnUrl(String s){
        try {
//            Scanner sc= new Scanner(System.in);
//            String s=sc.next();

            URL url = new URL("https://youtube.googleapis.com/youtube/v3/search?part=snippet&q=" + s +"&key=AIzaSyBIP1BJauXDW6DWTP40xMalx3z3tNz3exE");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            

//           System.out.println(br.readLine());
//            System.out.println(br.readLine());
            StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
//                System.out.println(sb.toString());
                JSONObject obj = new JSONObject(sb.toString());
                JSONArray array = obj.getJSONArray("items");
//                StringBuilder strb = new StringBuilder();
//                for(int i = 0 ; i < array.length() ; i++){
//                    String str="http://www.youtube.com/embed/" + array.getJSONObject(i).getJSONObject("id").getString("videoId");
//                    
//                    strb.append(str+"\n");
//                 }
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            }
            conn.disconnect();
             return array;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return null;
        }
        
        
    }
    



}


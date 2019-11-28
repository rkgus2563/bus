package api;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.gbis.go.kr/ws/rest/busarrivalservice"); /*URL*/
        urlBuilder.append("?serviceKey=eUiETQ%2Bl3ZgVs7V1CEJ041DbFO6nugcHguOOZI6oHt7%2BVVI15lrYXZ7L35H%2B4I9JnuNmkjMDDGFEwSR0nmLW5A%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("stationId","UTF-8") + "=" + URLEncoder.encode("200000177", "UTF-8")); /*정류소 ID*/
        urlBuilder.append("&" + URLEncoder.encode("routeId","UTF-8") + "=" + URLEncoder.encode("200000037", "UTF-8")); /*노선 ID*/
        urlBuilder.append("&" + URLEncoder.encode("staOrder","UTF-8") + "=" + URLEncoder.encode("19", "UTF-8")); /*노선의 정류소 순번*/
       
        URL url = new URL(urlBuilder.toString());
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
   
}}
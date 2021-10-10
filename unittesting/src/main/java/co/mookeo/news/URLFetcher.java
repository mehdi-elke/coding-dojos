package co.mookeo.news;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class URLFetcher {


    public String get(final String urlToRead) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try(BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
            }
            return result.toString();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}

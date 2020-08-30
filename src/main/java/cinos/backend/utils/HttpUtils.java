package cinos.backend.utils;

import cinos.backend.model.ApiKey;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class HttpUtils {

    public static ResponseEntity<?> makeHttpRequest(URL url, Map<String, String> headers, String type) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        for (Map.Entry<String, String> entry : headers.entrySet()){
            con.setRequestProperty(entry.getKey(), entry.getValue());
        }

        con.setRequestMethod(type);

        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();

        return ResponseEntity.status(status).body(content.toString());
    }


}

package cinos.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MessagingService {

    public void sendMessageToTelegramBot(String email) {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        String apiToken = System.getenv("TELEGRAM_BOT_API_TOKEN");

        String chatId = "-411078607";

        urlString = String.format(urlString, apiToken, chatId, email);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

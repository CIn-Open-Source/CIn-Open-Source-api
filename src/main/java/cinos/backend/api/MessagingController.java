package cinos.backend.api;

import cinos.backend.exceptions.MissingProjectException;
import cinos.backend.service.MessagingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@AllArgsConstructor
@RestController
@ControllerAdvice
@RequestMapping({"/api/message"})
public class MessagingController {

    private MessagingService messagingService;

    @GetMapping(path = "/telegram/{email}")
    public ResponseEntity<?> sendInterestRequestMessage(@PathVariable String email) throws IOException {
        messagingService.sendMessageToTelegramBot(email);
        return ResponseEntity.ok().body("Sucefully sent");
    }
}

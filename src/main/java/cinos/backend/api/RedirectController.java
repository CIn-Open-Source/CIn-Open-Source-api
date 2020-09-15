package cinos.backend.api;


import cinos.backend.exceptions.MissingProjectException;
import cinos.backend.model.Project;
import cinos.backend.service.RedirectService;
import cinos.backend.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping({"/api/redirect"})
@ControllerAdvice
public class RedirectController {

    private RedirectService redirectService;

    @GetMapping(path = "/github/repos/{name}")
    public ResponseEntity<?> getRepoInfo(@PathVariable String name) throws MissingProjectException, IOException {
        Project project = redirectService.getRepoInfo(name).orElseThrow(MissingProjectException::new);
        return ResponseEntity.ok().body(project);
    }

    @GetMapping(path="/test")
    ResponseEntity<?> test(){
        return ResponseEntity.ok().body("Sucefully Deployed");
    }

}

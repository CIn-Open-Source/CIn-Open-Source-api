package cinos.backend.api;


import cinos.backend.exceptions.MissingProjectException;
import cinos.backend.model.Project;
import cinos.backend.service.RedirectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping({"/api/redirect"})
public class RedirectController {

    private RedirectService redirectService;

    @GetMapping(path = "/github/repos/{name}")
    public ResponseEntity<?> getRepoInfo(@PathVariable String name) throws MissingProjectException, IOException {
        Project project = redirectService.getRepoInfo(name).orElseThrow(MissingProjectException::new);
        return ResponseEntity.ok().body(project);
    }

}

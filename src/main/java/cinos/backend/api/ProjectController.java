package cinos.backend.api;

import java.util.List;
import java.util.UUID;

import cinos.backend.exceptions.MissingProjectException;
import cinos.backend.model.Project;
import cinos.backend.service.ProjectInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping({"/api/projects"})
public class ProjectController {

    private ProjectInfoService projectInfoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getDocument(@PathVariable Long id) throws MissingProjectException {
        Project project = projectInfoService.getDocument(id).orElseThrow(MissingProjectException::new);
        return ResponseEntity.ok().body(project);
    }
}

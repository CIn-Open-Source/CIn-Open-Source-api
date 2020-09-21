package cinos.backend.api;

import cinos.backend.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping({"/api/projects"})
@ControllerAdvice
public class ProjectInfoController {

    private StatisticsService statisticsService;

    @GetMapping(path = "/statistics/global")
    public ResponseEntity<?> getGlobalStatistics() throws IOException {
        Map<String, List<Integer>> statistics = statisticsService.projectsGeneralStats().orElseThrow(IOException::new);
        return ResponseEntity.ok().body(statistics);
    }

    @GetMapping(path = "/statistics/{project}")
    public ResponseEntity<?> getProjectStatistics(@PathVariable String project) throws IOException {
        Map<String, List<Integer>> statistics = statisticsService.projectGeneralStats(project).orElseThrow(IOException::new);
        return ResponseEntity.ok().body(statistics);
    }

}

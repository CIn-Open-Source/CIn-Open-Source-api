package cinos.backend.service;

import cinos.backend.dao.ProjectDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StatisticsService {
    ProjectDAO projectDAO;

    public Optional<Map<String, List<Integer>>> projectsGeneralStats(){
        Map<String, List<Integer>> stats = new HashMap<>();
        stats.put("forks_count", projectDAO.findGlobalForkCountPerYear());
        stats.put("stargazers_count", projectDAO.findGlobalStarCountPerYear());
        stats.put("issues_open_count", projectDAO.findGlobalIssuesCountPerYear());
        return Optional.of(stats);
    }

    public Optional<Map<String, List<Integer>>> projectGeneralStats(String project){
        Map<String, List<Integer>> stats = new HashMap<>();
        stats.put("forks_count", projectDAO.findProjectForkCount(project));
        stats.put("stargazers_count", projectDAO.findProjectStarCount(project));
        stats.put("issues_open_count", projectDAO.findProjectIssuesCount(project));
        return Optional.of(stats);
    }

}

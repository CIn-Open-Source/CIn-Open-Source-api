package cinos.backend.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Project {
    private String html_url;
    private String name;
    private Integer forks_count;
    private Integer stargazers_count;
    private Integer open_issues_count;
    private String description;
    private String language;
}

package cinos.backend.model;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity(name = "projects_month")
@Getter
@Builder
@Table(name = "projects_month")
public class Project {
    @Id
    @SequenceGenerator(name = "projects_month_id_seq", sequenceName = "projects_month_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_month_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    private String html_url;
    private String name;
    private Integer forks_count;
    private Integer stargazers_count;
    private Integer open_issues_count;
    private String description;
    private String language;
    private Integer month;
}

package cinos.backend.dao;

import cinos.backend.model.Project;
import cinos.backend.model.StatisticsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectDAO extends JpaRepository<Project, Long> {


    @Query(value = "select sum(stargazers_count) from projects_month group by month order by month asc", nativeQuery = true)
    List<Integer> findGlobalStarCountPerYear();

    @Query(value = "select sum(forks_count) from projects_month group by month order by month asc", nativeQuery = true)
    List<Integer> findGlobalForkCountPerYear();

    @Query(value = "select sum(open_issues_count) from projects_month group by month order by month asc", nativeQuery = true)
    List<Integer> findGlobalIssuesCountPerYear();

    @Query(value = "select sum(stargazers_count) from projects_month where name = :projectName group by month order by month asc", nativeQuery = true)
    List<Integer> findProjectStarCount(@Param("projectName") String projectName);

    @Query(value = "select sum(forks_count) from projects_month where name = :projectName group by month order by month asc", nativeQuery = true)
    List<Integer> findProjectForkCount(@Param("projectName") String projectName);

    @Query(value = "select sum(open_issues_count) from projects_month where name = :projectName group by month order by month asc", nativeQuery = true)
    List<Integer> findProjectIssuesCount(@Param("projectName") String projectName);

}

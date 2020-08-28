package cinos.backend.dao;

import cinos.backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository<Project, Long> {
}

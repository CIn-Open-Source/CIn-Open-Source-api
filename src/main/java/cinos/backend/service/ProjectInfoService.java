package cinos.backend.service;

import cinos.backend.dao.ProjectDAO;
import cinos.backend.model.Project;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProjectInfoService {
    private ProjectDAO projectDAO;

    public Optional<Project> getDocument(Long id){
        return projectDAO.findById(id);
    }
}

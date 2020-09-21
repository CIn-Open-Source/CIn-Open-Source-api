package cinos.backend.service;

import cinos.backend.dao.DeveloperDAO;
import cinos.backend.exceptions.DeveloperUnauthorizedException;
import cinos.backend.model.Developer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeveloperService {
    DeveloperDAO developerDAO;

    public void authenticateDeveloper(String key) throws DeveloperUnauthorizedException {
        Developer developer = this.developerDAO.findDeveloperByKey(key);
        if (developer == null){
            throw new DeveloperUnauthorizedException();
        }
    }
}

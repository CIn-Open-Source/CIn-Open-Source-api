package cinos.backend.mappers;

import cinos.backend.model.Project;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;

public class ResponseMapper {

    public static Project toProject(ResponseEntity<?> response){
        Gson g = new Gson();
        return g.fromJson((String) response.getBody(), Project.class);
    }
}

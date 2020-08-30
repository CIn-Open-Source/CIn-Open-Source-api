package cinos.backend.service;

import cinos.backend.mappers.ResponseMapper;
import cinos.backend.model.ApiKey;
import cinos.backend.model.Project;
import cinos.backend.utils.HttpUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static cinos.backend.constants.ApiKeys.GITHUB_API_KEYS;
import static cinos.backend.constants.Links.GITHUB_REPO_LINK;

@Service
public class RedirectService {

    private List<ApiKey> keys = GITHUB_API_KEYS;

    public Optional<Project> getRepoInfo(String name) throws IOException {
        URL url = new URL(GITHUB_REPO_LINK + name);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", buildAuthHeader(keys.get(0)));

        return Optional.ofNullable(ResponseMapper.toProject(HttpUtils.makeHttpRequest(url, headers, "GET")));
    }


    private String buildAuthHeader(ApiKey apiKey){
        return apiKey.getUser() + ":" + apiKey.getKey();
    }

}

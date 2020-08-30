package cinos.backend.constants;

import cinos.backend.model.ApiKey;

import java.util.Arrays;
import java.util.List;

public class ApiKeys {

    private static ApiKey GUI_GITHUB_KEY = ApiKey.builder()
            .key(System.getenv("GITHUB_GUI_KEY"))
            .user("gui-lima")
            .source("Github")
            .build();

    public static List<ApiKey> GITHUB_API_KEYS = Arrays.asList(GUI_GITHUB_KEY);


}

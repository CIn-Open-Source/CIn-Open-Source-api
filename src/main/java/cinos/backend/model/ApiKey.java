package cinos.backend.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiKey {
    private String key;
    private String user;
    private String source;
}

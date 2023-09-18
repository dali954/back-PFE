package tn.numeryx.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "gitlab")
public class GitlabProperties {

    private String apiUrl = "http://192.168.195.128/api/v4";
    // private String personalAccessToken = "glpat-8uUX6xLc_5wn6hz9WiAZ";
    private String personalAccessToken = "glpat-Mya-QzqZZz97oBhet99G";

}

// 115c17926f1116ecf72170ae0133dfab45 jenkins jeton

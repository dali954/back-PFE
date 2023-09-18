
package tn.numeryx.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "jenkins")
public class JenkinsProperties {

    private String apiUrl = "http://192.168.195.129:8080";
    // private String personalAccessToken = "a5279d304b42ec66484dc9585dcfa421";
    // private String JenkinsCrumb =
    // "6938355d098ee4aadc67b9547eaa37e84eab6c85043a11f916c19956593cd96b1885697b9558bc48f38f4b6b0b2adb86c1dbaae9b61970b882af43f6ca006f3c";
    private String username = "dali";
    private String password = "114972d9b602f3ca86a178349a07af7db8";

}
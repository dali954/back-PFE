package tn.numeryx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Crumb {

    @JsonProperty("crumb")
    private String crumb;

    @JsonProperty("crumbRequestField")
    private String crumbRequestField;

}

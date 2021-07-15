
package org.example.pojos.herokuapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "username",
    "password"
})
@Data
public class GetAuthRequest {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

}

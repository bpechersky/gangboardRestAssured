
package org.example.pojos.herokuapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name"
})
@Data
public class Category {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
}

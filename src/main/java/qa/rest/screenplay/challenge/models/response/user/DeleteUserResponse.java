package qa.rest.screenplay.challenge.models.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteUserResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("message")
    private String message;
}

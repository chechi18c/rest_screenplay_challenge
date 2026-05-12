package qa.rest.screenplay.challenge.models.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteUserResponse {
    private String id;
    private String message;
}

package qa.rest.screenplay.challenge.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserResponse {

    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}

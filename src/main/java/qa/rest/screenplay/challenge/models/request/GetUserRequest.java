package qa.rest.screenplay.challenge.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUserRequest {

    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}

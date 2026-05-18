package qa.rest.screenplay.challenge.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteUserRequest {
    private String userId;
}

package qa.rest.screenplay.challenge.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object representing the payload for SQI (Service Quality Indicator) creation
 * requests.
 *
 * <p>Leverages the Builder pattern to facilitate the construction of product-specific payloads
 * (Stark, Parker, Thor). This class ensures that only populated fields are serialized into the JSON
 * request body by using {@link JsonInclude.Include#NON_NULL}, maintaining a clean interface with
 * backend REST services.
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("job")
    private String job;
}

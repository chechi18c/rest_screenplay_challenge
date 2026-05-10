package qa.rest.screenplay.challenge.models.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents the data transfer object for a user creation response.
 *
 * <p>
 * This class encapsulates the user information returned by the server
 * upon a successful user creation. It is designed to be deserialized from a
 * JSON response. Lombok and
 * Jackson annotations are used for boilerplate reduction and JSON processing.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Create {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String name;

    @JsonProperty("email")
    String email;

    @JsonProperty("role")
    String role;

    @JsonProperty("createdAt")
    String createdAt;

    @JsonProperty("updatedAt")
    String updatedAt;

    @JsonProperty("msg")
    String msg;
}

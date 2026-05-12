package qa.rest.screenplay.challenge.utils.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API resource endpoint constants.
 *
 * <p>Responsibility: Centralizes the paths (endpoints) for all API resources used in the automation
 * CRUD operations.
 */
@Getter
@AllArgsConstructor
public enum Resources {
    CREATE_USER("/users"),
    GET_USER("users"),
    UPDATE_USER("users/{id}"),
    DELETE_USER("users/{id}");

    private final String value;
}

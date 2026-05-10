package qa.rest.screenplay.challenge.utils.constants;

import lombok.Getter;
import lombok.AllArgsConstructor;

/**
 * API resource endpoint constants.
 *
 * <p>
 * Responsibility: Centralizes the paths (endpoints) for all API resources used
 * in the automation CRUD operations.
 */

@Getter
@AllArgsConstructor
public enum Resources {

    CREATE_USER("collections/users/records"),
    GET_USER("collections/users/records"),
    UPDATE_USER("collections/users/records/{id}"),
    DELETE_USER("collections/users/records/{id}");

    private final String value;

}

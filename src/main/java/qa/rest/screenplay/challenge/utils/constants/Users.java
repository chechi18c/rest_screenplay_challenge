package qa.rest.screenplay.challenge.utils.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Users {
    USER_ID("2"),
    USER_ROLE("superadmin");

    private final String value;
}

package qa.rest.screenplay.challenge.utils.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Constants for assertion messages used across the automation suite.
 *
 * <p>This enum centralizes descriptive messages and keys used in test assertions to ensure
 * consistency and readability in test reports and failure logs.
 */
@Getter
@AllArgsConstructor
public enum AssertionMessages {
    STATUS_CODE("the status code");

    private final String message;
}

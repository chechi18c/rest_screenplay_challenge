package qa.rest.screenplay.challenge.serenityJUnit5;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import qa.rest.screenplay.challenge.hooks.*;

/**
 * Base suite for automated tests using Serenity BDD and Screenplay pattern.
 *
 * <p>Responsibility: Provides shared setup and common actor initialization for test suites.
 *
 * @see SerenityJUnit5Extension
 */
@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseTestSuite {

    /** The primary actor used for interacting with the system under test. */
    protected Actor tyber;

    /** Sets up the actor with the ability to call API endpoints using the configured base URL. */
    @BeforeEach
    public void setUp() {
        tyber = Actor.named("chechi").whoCan(CallAnApi.at(EnvironmentConfig.getBaseUrl()));
    }
}

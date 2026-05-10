package qa.rest.screenplay.challenge.serenityJUnit5;

import static qa.rest.screenplay.challenge.utils.constants.AssertionMessages.STATUS_CODE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

import qa.rest.screenplay.challenge.factory.UserFactory;
import qa.rest.screenplay.challenge.models.request.CreateUserRequest;
import qa.rest.screenplay.challenge.questions.generics.ResponseCode;
import qa.rest.screenplay.challenge.tasks.user.CreateUser;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.hamcrest.Matchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Test suite for authentication-related functionalities, including email/phone
 * existence checks and
 * user login. This suite uses Serenity BDD for writing automated acceptance
 * tests.
 */
@ExtendWith(SerenityJUnit5Extension.class)
class TestCreateUser extends BaseTestSuite {

    private final String name = "Jane Doe";
    private final String email = "jane@example.com";
    private final String role = "admin";

    // private static final Logger LOGGER =
    // LoggerFactory.getLogger(TestRegisterUser.class);

    /**
     * Tests the user creation functionality. Constructs a
     * {@link CreateUserRequest}.
     * Asserts that the status code of the response is OK (200) and that a create
     * user response
     * is returned. The create user details are also logged and stored in the
     * actor's memory for potential subsequent tests.
     */
    @Test
    void createUser() {

        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .name(name)
                .email(email)
                .role(role)
                .build();

        tyber.attemptsTo(CreateUser.with(createUserRequest));

        tyber.should(seeThat(STATUS_CODE.getMessage(), ResponseCode.was(), equalTo(SC_OK)));
    }
}
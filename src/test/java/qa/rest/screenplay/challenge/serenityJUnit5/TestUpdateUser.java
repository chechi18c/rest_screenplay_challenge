package qa.rest.screenplay.challenge.serenityJUnit5;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static qa.rest.screenplay.challenge.utils.constants.AssertionMessages.STATUS_CODE;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import qa.rest.screenplay.challenge.models.questions.UserUpdateResult;
import qa.rest.screenplay.challenge.models.request.UpdateUserRequest;
import qa.rest.screenplay.challenge.questions.generics.ResponseCode;
import qa.rest.screenplay.challenge.tasks.user.UpdateUser;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestUpdateUser extends BaseTestSuite {

    private final String name = "Cecilia";
    private final String email = "chechi@yopmail.com";
    private final String role = "superadmin";

    /**
     * Tests the user creation functionality. Constructs a {@link UpdateUserRequest}. Asserts that
     * the status code of the response is OK (200) and that a create user response is returned. The
     * create user details are also logged and stored in the actor's memory for potential subsequent
     * tests.
     */
    @Test
    @Order(2)
    void updateUser() {

        UpdateUserRequest updateUserRequest =
                UpdateUserRequest.builder().name(name).email(email).role(role).build();

        tyber.attemptsTo(UpdateUser.with(updateUserRequest));
        tyber.should(seeThat(STATUS_CODE.getMessage(), ResponseCode.was(), equalTo(SC_OK)));
        tyber.should(
                seeThat(
                        "The User role",
                        actor -> UserUpdateResult.wasSuccessful().answeredBy(actor).getRole(),
                        equalTo(role)));
    }
}

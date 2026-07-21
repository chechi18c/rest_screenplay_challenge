package qa.rest.screenplay.challenge.serenityJUnit5;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static qa.rest.screenplay.challenge.questions.user.ResponseBody.*;
import static qa.rest.screenplay.challenge.questions.user.ServerResponse.statusCode;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import qa.rest.screenplay.challenge.models.request.UpdateUserRequest;
import qa.rest.screenplay.challenge.tasks.user.UpdateUser;
import qa.rest.screenplay.challenge.utils.constants.Users;
import qa.rest.screenplay.challenge.utils.data.DataGenerator;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestUpdateUser extends BaseTestSuite {

    private final String name = DataGenerator.generateRandomName();
    private final String email = DataGenerator.generateRandomEmail();

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
                UpdateUserRequest.builder()
                        .name(name)
                        .email(email)
                        .role(Users.USER_ROLE.getValue())
                        .build();

        tyber.attemptsTo(UpdateUser.with(updateUserRequest));
        tyber.should(seeThat("The status code is: ", statusCode(), equalTo(SC_OK)));
        tyber.should(
                seeThat(
                        "The User role",
                        actor -> asMap().answeredBy(actor).get("role"),
                        equalTo(Users.USER_ROLE.getValue())));
    }
}

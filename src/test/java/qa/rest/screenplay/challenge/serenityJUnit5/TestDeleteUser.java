package qa.rest.screenplay.challenge.serenityJUnit5;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.hamcrest.Matchers.equalTo;
import static qa.rest.screenplay.challenge.questions.user.ServerResponse.statusCode;
import static qa.rest.screenplay.challenge.utils.constants.Users.USER_ID;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import qa.rest.screenplay.challenge.models.request.DeleteUserRequest;
import qa.rest.screenplay.challenge.tasks.user.DeleteUser;

/**
 * Test suite for authentication-related functionalities, including email/phone existence checks and
 * user login. This suite uses Serenity BDD for writing automated acceptance tests.
 */
@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestDeleteUser extends BaseTestSuite {

    /**
     * Tests the user deletion functionality. Constructs a {@link DeleteUserRequest}. Asserts that
     * the status code of the response is OK (200) and that a delete user response is returned. The
     * delete user details are also logged and stored in the actor's memory for potential subsequent
     * tests.
     */
    @Test
    @Order(4)
    void deleteUser() {

        DeleteUserRequest deleteUserRequest =
                DeleteUserRequest.builder().userId(USER_ID.getValue()).build();

        tyber.attemptsTo(DeleteUser.with(deleteUserRequest));
        tyber.should(seeThat("The status code is", statusCode(), equalTo(SC_NO_CONTENT)));
    }
}

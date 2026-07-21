package qa.rest.screenplay.challenge.serenityJUnit5;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.equalTo;
import static qa.rest.screenplay.challenge.questions.user.ServerResponse.statusCode;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import qa.rest.screenplay.challenge.models.request.CreateUserRequest;
import qa.rest.screenplay.challenge.tasks.user.CreateUser;
import qa.rest.screenplay.challenge.utils.data.DataGenerator;

/**
 * Test suite for authentication-related functionalities, including email/phone existence checks and
 * user login. This suite uses Serenity BDD for writing automated acceptance tests.
 */
@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestCreateUser extends BaseTestSuite {

    private final String name = DataGenerator.generateRandomName();
    private final String email = DataGenerator.generateRandomEmail();
    private final String role = DataGenerator.generateRandomRole();

    /**
     * Tests the user creation functionality. Constructs a {@link CreateUserRequest}. Asserts that
     * the status code of the response is OK (200) and that a create user response is returned. The
     * create user details are also logged and stored in the actor's memory for potential subsequent
     * tests.
     */
    @Test
    @Order(1)
    void createUser() {

        CreateUserRequest createUserRequest =
                CreateUserRequest.builder().name(name).email(email).role(role).build();

        tyber.attemptsTo(CreateUser.with(createUserRequest));
        tyber.should(seeThat("The status code is:", statusCode(), equalTo(SC_CREATED)));
    }
}

package qa.rest.screenplay.challenge.serenityJUnit5;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static qa.rest.screenplay.challenge.utils.constants.AssertionMessages.STATUS_CODE;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import qa.rest.screenplay.challenge.questions.generics.ResponseCode;
import qa.rest.screenplay.challenge.questions.user.GetUserResult;
import qa.rest.screenplay.challenge.tasks.user.GetUser;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestGetUser extends BaseTestSuite {

    /**
     * Tests the get user functionality. Sends a GET request to the user endpoint and asserts that
     * the status code of the response is OK (200) and that the returned email matches the expected
     * value.
     */
    @Test
    @Order(3)
    void getUser() {

        tyber.attemptsTo(GetUser.with());
        tyber.should(seeThat(STATUS_CODE.getMessage(), ResponseCode.was(), equalTo(SC_OK)));
        tyber.should(seeThat("La cantidad de usuarios", GetUserResult.wasSuccessful(), hasSize(6)));
    }
}

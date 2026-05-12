package qa.rest.screenplay.challenge.questions.user;

import java.util.List;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import qa.rest.screenplay.challenge.models.response.GetUserResponse;

/**
 * Screenplay Question for retrieving and parsing the result of an user get API call.
 *
 * <p>Wraps the extraction of the last response body, mapping it to the {@link GetUserResponse}
 * model to enable fluent assertions on the get user.
 */
public class GetUser implements Question<List<Map<String, Object>>> {

    /**
     * Factory method to obtain a new GetUser question instance.
     *
     * @return A question that resolves to the GetUser response data.
     */
    public static Question<List<Map<String, Object>>> wasSuccessful() {
        return new GetUser();
    }

    @Override
    public List<Map<String, Object>> answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getList("data");
    }
}

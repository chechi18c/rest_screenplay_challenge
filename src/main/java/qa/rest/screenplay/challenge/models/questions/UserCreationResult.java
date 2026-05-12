package qa.rest.screenplay.challenge.models.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import qa.rest.screenplay.challenge.models.response.user.CreateUserResponse;

/**
 * Screenplay Question for retrieving and parsing the result of a user creation API call.
 *
 * <p>Wraps the extraction of the last response body, mapping it to the {@link CreateUserResponse}
 * model to enable fluent assertions on the created user.
 */
public class UserCreationResult implements Question<CreateUserResponse> {

    /**
     * Factory method to obtain a new SqiCreationResult question instance.
     *
     * @return A question that resolves to the SQI response data.
     */
    public static Question<CreateUserResponse> wasSuccessful() {
        return new UserCreationResult();
    }

    /**
     * Resolves the question by mapping the last REST response to the SqiResponse DTO.
     *
     * @param actor The actor asking the question.
     * @return The mapped SQI response object.
     */
    @Override
    public CreateUserResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(CreateUserResponse.class);
    }
}

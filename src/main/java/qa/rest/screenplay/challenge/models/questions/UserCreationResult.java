package qa.rest.screenplay.challenge.models.questions;

import qa.rest.screenplay.challenge.models.response.user.Create;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * Screenplay Question for retrieving and parsing the result of an SQI creation
 * API call.
 *
 * <p>
 * Wraps the extraction of the last response body, mapping it to the
 * {@link Create}
 * model to enable fluent assertions on the created investment goals.
 */
public class UserCreationResult implements Question<Create> {

    /**
     * Factory method to obtain a new SqiCreationResult question instance.
     *
     * @return A question that resolves to the SQI response data.
     */
    public static Question<Create> wasSuccessful() {
        return new UserCreationResult();
    }

    /**
     * Resolves the question by mapping the last REST response to the SqiResponse
     * DTO.
     *
     * @param actor The actor asking the question.
     * @return The mapped SQI response object.
     */
    @Override
    public Create answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Create.class);
    }
}
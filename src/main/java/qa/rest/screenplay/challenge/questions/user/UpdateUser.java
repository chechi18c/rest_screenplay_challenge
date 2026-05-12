package qa.rest.screenplay.challenge.questions.user;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import qa.rest.screenplay.challenge.models.response.user.UpdateUserResponse;

/**
 * Screenplay Question for retrieving and parsing the result of an SQI creation API call.
 *
 * <p>Wraps the extraction of the last response body, mapping it to the {@link UpdateUserResponse}
 * model to enable fluent assertions on the created investment goals.
 */
public class UpdateUser implements Question<UpdateUserResponse> {

    /**
     * Factory method to obtain a new SqiCreationResult question instance.
     *
     * @return A question that resolves to the SQI response data.
     */
    public static Question<UpdateUserResponse> wasSuccessful() {
        return new UpdateUser();
    }

    /**
     * Resolves the question by mapping the last REST response to the SqiResponse DTO.
     *
     * @param actor The actor asking the question.
     * @return The mapped SQI response object.
     */
    @Override
    public UpdateUserResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UpdateUserResponse.class);
    }
}

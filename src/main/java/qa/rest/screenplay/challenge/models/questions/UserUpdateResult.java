package qa.rest.screenplay.challenge.models.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import qa.rest.screenplay.challenge.models.response.user.UpdateUserResponse;

/**
 * Screenplay Question for retrieving and parsing the result of an user update API call.
 *
 * <p>Wraps the extraction of the last response body, mapping it to the {@link UpdateUserResponse}
 * model to enable fluent assertions on the updated user.
 */
public class UserUpdateResult implements Question<UpdateUserResponse> {

    /**
     * Factory method to obtain a new UserUpdateResult question instance.
     *
     * @return A question that resolves to the UserUpdate response data.
     */
    public static Question<UpdateUserResponse> wasSuccessful() {
        return new UserUpdateResult();
    }

    /**
     * Resolves the question by mapping the last REST response to the UpdateUserResponse DTO.
     *
     * @param actor The actor asking the question.
     * @return The mapped UpdateUser response object.
     */
    @Override
    public UpdateUserResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UpdateUserResponse.class);
    }
}

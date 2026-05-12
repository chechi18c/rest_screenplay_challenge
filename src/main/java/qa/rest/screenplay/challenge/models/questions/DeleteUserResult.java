package qa.rest.screenplay.challenge.models.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import qa.rest.screenplay.challenge.models.response.user.DeleteUserResponse;

/**
 * Screenplay Question for retrieving and parsing the result of a user delete API call.
 *
 * <p>Wraps the extraction of the last response body, mapping it to the {@link DeleteUserResponse}
 * model to enable fluent assertions on the delete user.
 */
public class DeleteUserResult implements Question<DeleteUserResponse> {

    /**
     * A factory method that provides a new instance of this question, which helps improve the
     * readability of test steps.
     *
     * @return A new {@link DeleteUserResult} instance.
     */
    public static Question<DeleteUserResponse> wasSuccessful() {
        return new DeleteUserResult();
    }

    @Override
    public DeleteUserResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(DeleteUserResponse.class);
    }
}

package qa.rest.screenplay.challenge.questions.user;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import qa.rest.screenplay.challenge.models.response.user.CreateUserResponse;
import qa.rest.screenplay.challenge.models.response.user.DeleteUserResponse;

/**
 * Screenplay Question for retrieving and parsing the result of a user delete API call.
 *
 * <p>Wraps the extraction of the last response body, mapping it to the {@link DeleteUserResponse}
 * model to enable fluent assertions on the delete user.
 */
public class DeleteUser implements Question<DeleteUserResponse> {

    public static Question<DeleteUserResponse> wasSuccessful() {
        return new DeleteUser();
    }

    /**
     * Deserializes the last HTTP response into a {@link CreateUserResponse} object.
     *
     * @param actor The actor performing the action.
     * @return The {@link CreateUserResponse} object with the data from the last API response.
     */
    @Override
    public DeleteUserResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(DeleteUserResponse.class);
    }
}

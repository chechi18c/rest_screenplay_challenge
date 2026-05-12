package qa.rest.screenplay.challenge.questions.user;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import qa.rest.screenplay.challenge.models.response.user.CreateUserResponse;

/**
 * A Screenplay {@link Question} that extracts a {@link CreateUserResponse} from the last REST API
 * call. This class is responsible for deserializing the JSON response into its corresponding Java
 * object, allowing for easy data validation in test scenarios.
 */
public class CreateUser implements Question<CreateUserResponse> {

    /**
     * A factory method that provides a new instance of this question, which helps improve the
     * readability of test steps.
     *
     * @return A new {@link CreateUser} instance.
     */
    public static Question<CreateUserResponse> wasSuccessful() {
        return new CreateUser();
    }

    /**
     * Deserializes the last HTTP response into a {@link CreateUserResponse} object.
     *
     * @param actor The actor performing the action.
     * @return The {@link CreateUserResponse} object with the data from the last API response.
     */
    @Override
    public CreateUserResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(CreateUserResponse.class);
    }
}

package qa.rest.screenplay.challenge.tasks.user;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static qa.rest.screenplay.challenge.utils.constants.Resources.UPDATE_USER;

import io.restassured.http.ContentType;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import qa.rest.screenplay.challenge.interactions.Put;
import qa.rest.screenplay.challenge.models.request.CreateUserRequest;
import qa.rest.screenplay.challenge.models.request.UpdateUserRequest;

/**
 * A Serenity BDD {@link Task} to create a new user in reqres.in. This task encapsulates the API
 * interaction for user creation, constructing a POST request with the {@link CreateUserRequest}
 * payload containing the new user's details. It is designed to be used within the Screenplay
 * Pattern.
 */
@Builder
public class UpdateUser implements Task {

    private final UpdateUserRequest updateUserRequest;
    private final String API_KEY = "reqres_b2933e2f11814e89b1fb24eba3019a49";

    /**
     * @param updateUserRequest The {@link UpdateUserRequest} containing the details for the new
     *     user.
     */
    public UpdateUser(UpdateUserRequest updateUserRequest) {
        this.updateUserRequest = updateUserRequest;
    }

    /**
     * Creates an instrumented instance of the {@code UpdateUser} task. This is the recommended way
     * to instantiate tasks in Serenity BDD, ensuring proper integration with reporting and
     * execution.
     *
     * @param updateUserRequest The {@link UpdateUserRequest} containing the user's update details.
     * @return A {@link Performable} task ready to be executed by an {@link Actor}.
     */
    public static Performable with(UpdateUserRequest updateUserRequest) {
        return instrumented(UpdateUser.class, updateUserRequest);
    }

    /**
     * Performs the user update task as the given {@link Actor}. It constructs and sends a POST
     * request with the user update details to the {@code UPDATE_USER} endpoint.
     *
     * @param actor The {@link Actor} who performs the task.
     * @param <T> A type parameter representing the {@link Actor}.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(UPDATE_USER.getValue())
                        .with(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .header("x-api-key", API_KEY)
                                                .body(updateUserRequest)));
    }
}

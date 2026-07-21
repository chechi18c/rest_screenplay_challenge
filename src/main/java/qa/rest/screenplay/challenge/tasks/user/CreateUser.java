package qa.rest.screenplay.challenge.tasks.user;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static qa.rest.screenplay.challenge.utils.constants.Resources.CREATE_USER;

import io.restassured.http.ContentType;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import qa.rest.screenplay.challenge.hooks.*;
import qa.rest.screenplay.challenge.interactions.Post;
import qa.rest.screenplay.challenge.models.request.CreateUserRequest;

/**
 * A Serenity BDD {@link Task} to create a new user in reqres.in. This task encapsulates the API
 * interaction for user creation, constructing a POST request with the {@link CreateUserRequest}
 * payload containing the new user's details. It is designed to be used within the Screenplay
 * Pattern.
 */
@Builder
public class CreateUser implements Task {

    private final CreateUserRequest createUserRequest;

    /**
     * @param createUserRequest The {@link CreateUserRequest} containing the details for the new
     *     user.
     */
    public CreateUser(CreateUserRequest createUserRequest) {
        this.createUserRequest = createUserRequest;
    }

    /**
     * Creates an instrumented instance of the {@code CreateUser} task. This is the recommended way
     * to instantiate tasks in Serenity BDD, ensuring proper integration with reporting and
     * execution.
     *
     * @param createUserRequest The {@link CreateUserRequest} containing the user's creation
     *     details.
     * @return A {@link Performable} task ready to be executed by an {@link Actor}.
     */
    public static Performable with(CreateUserRequest createUserRequest) {
        return instrumented(CreateUser.class, createUserRequest);
    }

    /**
     * Performs the user creation task as the given {@link Actor}. It constructs and sends a POST
     * request with the user creation details to the {@code CREATE_USER} endpoint.
     *
     * @param actor The {@link Actor} who performs the task.
     * @param <T> A type parameter representing the {@link Actor}.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(CREATE_USER.getValue())
                        .with(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .header("x-api-key", EnvironmentConfig.getApiKey())
                                                .body(createUserRequest)));
    }
}

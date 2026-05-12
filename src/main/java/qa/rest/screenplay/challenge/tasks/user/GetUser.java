package qa.rest.screenplay.challenge.tasks.user;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static qa.rest.screenplay.challenge.utils.constants.Resources.GET_USER;

import io.restassured.http.ContentType;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import qa.rest.screenplay.challenge.interactions.Get;

/**
 * A Serenity BDD {@link Task} to get a user in reqres.in. This task encapsulates the API
 * interaction for user get, constructing a GET request with the {@link GetUserRequest} payload
 * containing the new user's details. It is designed to be used within the Screenplay Pattern.
 */
@Builder
public class GetUser implements Task {

    private final String API_KEY = "reqres_b2933e2f11814e89b1fb24eba3019a49";

    /**
     * Creates an instrumented instance of the {@code GetUser} task. This is the recommended way to
     * instantiate tasks in Serenity BDD, ensuring proper integration with reporting and execution.
     *
     * @return A {@link Performable} task ready to be executed by an {@link Actor}.
     */
    public static Performable with() {
        return instrumented(GetUser.class);
    }

    /**
     * Performs the user get task as the given {@link Actor}. It constructs and sends a GET request
     * with the user get details to the {@code GET_USER} endpoint.
     *
     * @param actor The {@link Actor} who performs the task.
     * @param <T> A type parameter representing the {@link Actor}.
     */
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.to(GET_USER.getValue())
                        .with(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .header("x-api-key", API_KEY)));
    }
}

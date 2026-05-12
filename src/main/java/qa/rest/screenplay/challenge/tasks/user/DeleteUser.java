package qa.rest.screenplay.challenge.tasks.user;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static qa.rest.screenplay.challenge.utils.constants.Resources.DELETE_USER;

import groovy.transform.builder.Builder;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import qa.rest.screenplay.challenge.models.request.DeleteUserRequest;

@Builder
public class DeleteUser implements Task {

    private final DeleteUserRequest deleteUserRequest;
    private final String API_KEY = "reqres_b2933e2f11814e89b1fb24eba3019a49";

    /**
     * @param deleteUserRequest The {@link DeleteUserRequest} containing the details for the new
     *     user.
     */
    public DeleteUser(DeleteUserRequest deleteUserRequest) {
        this.deleteUserRequest = deleteUserRequest;
    }

    /**
     * Creates an instrumented instance of the {@code DeleteUser} task. This is the recommended way
     * to instantiate tasks in Serenity BDD, ensuring proper integration with reporting and
     * execution.
     *
     * @param deleteUserRequest The {@link DeleteUserRequest} containing the user's creation
     *     details.
     * @return A {@link Performable} task ready to be executed by an {@link Actor}.
     */
    public static Performable with(DeleteUserRequest deleteUserRequest) {
        return instrumented(DeleteUser.class, deleteUserRequest);
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
                Delete.from(DELETE_USER.getValue())
                        .with(
                                request ->
                                        request.contentType(ContentType.JSON)
                                                .header("x-api-key", API_KEY)
                                                .body(deleteUserRequest)));
    }
}

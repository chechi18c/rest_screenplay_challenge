package qa.rest.screenplay.challenge.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

/**
 * A custom Serenity BDD {@link RestInteraction} to perform an HTTP DELETE request.
 *
 * <p>This class provides a clean and reusable way to model DELETE interactions within the
 * Screenplay Pattern, including built-in logging of the request and response.
 */
public class Delete extends RestInteraction {

    private final String resource;

    /**
     * Constructs the interaction with a specific API resource.
     *
     * @param resource The target API resource or endpoint for the DELETE request.
     */
    public Delete(String resource) {
        this.resource = resource;
    }

    /**
     * {@inheritDoc}
     *
     * @param actor The actor executing the request.
     */
    @Step("{0} executes a DELETE on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().delete(as(actor).resolve(this.resource)).then().log().all();
    }

    /**
     * A factory method to create a new instance of this interaction. This is the standard way to
     * instantiate Screenplay tasks and interactions.
     *
     * @param resource The target API resource or endpoint for the DELETE request.
     * @return An instrumented instance of the {@link Delete} interaction.
     */
    public static Delete to(String resource) {
        return instrumented(Delete.class, resource);
    }
}

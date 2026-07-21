package qa.rest.screenplay.challenge.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

/**
 * A custom Serenity BDD {@link RestInteraction} to perform an HTTP POST request.
 *
 * <p>This class provides a clean and reusable way to model POST interactions within the Screenplay
 * Pattern, including built-in logging of the request and response.
 */
public class Post extends RestInteraction {

    private final String resource;

    /**
     * Constructs the interaction with a specific API resource.
     *
     * @param resource The target API resource or endpoint for the POST request.
     */
    public Post(String resource) {
        this.resource = resource;
    }

    /**
     * {@inheritDoc}
     *
     * @param actor The actor executing the request.
     */
    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().post(as(actor).resolve(this.resource)).then().log().all();
    }

    /**
     * A factory method to create a new instance of this interaction. This is the standard way to
     * instantiate Screenplay tasks and interactions.
     *
     * @param resource The target API resource or endpoint for the POST request.
     * @return An instrumented instance of the {@link Post} interaction.
     */
    public static Post to(String resource) {
        return instrumented(Post.class, resource);
    }
}

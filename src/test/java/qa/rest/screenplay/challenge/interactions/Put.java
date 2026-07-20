package qa.rest.screenplay.challenge.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

public class Put extends RestInteraction {

    private final String resource;

    /**
     * Constructs the interaction with a specific API resource.
     *
     * @param resource The target API resource or endpoint for the POST request.
     */
    public Put(String resource) {
        this.resource = resource;
    }

    /**
     * {@inheritDoc}
     *
     * @param actor The actor executing the request.
     */
    @Step("{0} executes a PUT on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().put(as(actor).resolve(this.resource)).then().log().all();
    }

    /**
     * A factory method to create a new instance of this interaction. This is the standard way to
     * instantiate Screenplay tasks and interactions.
     *
     * @param resource The target API resource or endpoint for the POST request.
     * @return An instrumented instance of the {@link Put} interaction.
     */
    public static Put to(String resource) {
        return instrumented(Put.class, resource);
    }
}

package qa.rest.screenplay.challenge.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import lombok.Builder;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

/**
 * A Serenity BDD {@link Interaction} to perform GET requests. This interaction encapsulates the API
 * interaction for GET requests, sending a GET request to the specified resource path. It is
 * designed to be used within the Screenplay Pattern.
 */
@Builder
public class Get extends RestInteraction {
    private final String resource;

    /**
     * @param resource The resource path to send the GET request to.
     */
    public Get(String resource) {
        this.resource = resource;
    }

    /**
     * Performs the GET interaction as the given {@link Actor}. It constructs and sends a GET
     * request with the specified resource path.
     *
     * @param actor The {@link Actor} who performs the interaction.
     */
    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().get(as(actor).resolve(this.resource)).then().log().all();
    }

    /**
     * Creates an instrumented instance of the {@code Get} interaction. This is the recommended way
     * to instantiate interactions in Serenity BDD, ensuring proper integration with reporting and
     * execution.
     *
     * @param resource The resource path for the GET request.
     * @return A {@link Performable} interaction ready to be executed by an {@link Actor}.
     */
    public static Get to(String resource) {
        return instrumented(Get.class, resource);
    }
}

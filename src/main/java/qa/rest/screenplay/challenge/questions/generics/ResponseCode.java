package qa.rest.screenplay.challenge.questions.generics;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * A Serenity BDD {@link Question} to retrieve the HTTP status code from the
 * last API response.
 *
 * <p>
 * This question allows an actor to query the status code of the most recent
 * REST interaction,
 * which is typically used in assertions to verify the outcome of a request.
 *
 * <p>
 * Example Usage:
 *
 * <pre>{@code
 * actor.should(seeThat(ResponseCode.was(), equalTo(200)));
 * }</pre>
 */
public class ResponseCode implements Question<Integer> {

    /**
     * Provides a new instance of the {@link ResponseCode} question.
     *
     * <p>
     * This factory method is the standard way to instantiate a question in the
     * Screenplay
     * Pattern.
     *
     * @return A new instance of {@link ResponseCode}.
     */
    public static Question<Integer> was() {
        return new ResponseCode();
    }

    /**
     * {@inheritDoc}
     *
     * @param actor The actor asking the question.
     * @return The HTTP status code from the last Serenity REST response.
     */
    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}
package qa.rest.screenplay.challenge.questions.user;

import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserUpdateResult implements Question<Map<String, Object>> {

    public static Question<Map<String, Object>> wasSuccessful() {
        return new UserUpdateResult();
    }

    @Override
    public Map<String, Object> answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().get("");
    }
}

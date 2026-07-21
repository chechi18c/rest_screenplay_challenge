package qa.rest.screenplay.challenge.questions.user;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

/** Generic questions for any HTTP response in the project. */
public class ServerResponse {

    // Constructor privado para evitar que se instancie, ya que es una clase utilitaria/factory
    private ServerResponse() {}

    public static Question<Integer> statusCode() {
        return Question.about("the HTTP status code")
                .answeredBy(actor -> SerenityRest.lastResponse().statusCode());
    }

    // Aquí mismo puedes agregar otras preguntas genéricas para el futuro
    public static Question<String> contentType() {
        return Question.about("the response content type")
                .answeredBy(actor -> SerenityRest.lastResponse().contentType());
    }
}

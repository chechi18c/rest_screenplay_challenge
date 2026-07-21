package qa.rest.screenplay.challenge.questions.user;

import java.util.List;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

/** Preguntas genéricas para extraer el cuerpo (body) de cualquier respuesta de API. */
public class ResponseBody {

    // Constructor privado para evitar que la clase sea instanciada
    private ResponseBody() {}

    /**
     * Extrae todo el cuerpo de la respuesta como un mapa (Ideal para un solo objeto JSON).
     * Reemplaza a tu antiguo UserUpdateResult.
     */
    public static Question<Map<String, Object>> asMap() {
        return Question.about("the response body as a map")
                .answeredBy(actor -> SerenityRest.lastResponse().jsonPath().get(""));
    }

    /**
     * Extrae el cuerpo de la respuesta como una lista de mapas. Reemplaza a tu antiguo
     * GetUserResult.
     */
    public static Question<List<Map<String, Object>>> asList() {
        return Question.about("the response body as a list")
                .answeredBy(actor -> SerenityRest.lastResponse().jsonPath().getList(""));
    }

    /**
     * Extrae una lista desde un nodo específico del JSON (ej. "data"). Muy útil si la lista no está
     * en la raíz del JSON.
     *
     * @param path La ruta del nodo JSON (ej. "data")
     */
    public static Question<List<Map<String, Object>>> asListFromPath(String path) {
        return Question.about("the response list from path: " + path)
                .answeredBy(actor -> SerenityRest.lastResponse().jsonPath().getList(path));
    }

    /**
     * BONUS PRO: Extrae la respuesta y la mapea automáticamente a cualquier clase modelo (POJO).
     *
     * @param modelClass La clase del modelo (ej. GetUserResponse.class)
     */
    public static <T> Question<T> as(Class<T> modelClass) {
        return Question.about("the response body as " + modelClass.getSimpleName())
                .answeredBy(actor -> SerenityRest.lastResponse().as(modelClass));
    }
}

package qa.rest.screenplay.challenge.factory;

import qa.rest.screenplay.challenge.models.request.CreateUserRequest;

/**
 * Factory class responsible for constructing {@link CreateUserRequest} objects, specifically
 * tailored for creation flows. This class provides static methods to create user request payloads,
 * simplifying the creation process and ensuring consistency across user creation attempts.
 */
public final class UserFactory {

    private UserFactory() {
        throw new UnsupportedOperationException("Factory class cannot be instantiated");
    }

    /**
     * Creates a {@link CreateUserRequest} payload with the given name, email and role.
     *
     * @param name The user's name.
     * @param job The user's job.
     * @return A {@link CreateUserRequest} object populated with the provided credentials.
     */
    public static CreateUserRequest withData(String name, String job) {
        return CreateUserRequest.builder().name(name).job(job).build();
    }
}

package qa.rest.screenplay.challenge.utils.data;

import net.datafaker.Faker;

public class DataGenerator {

    private static final Faker faker = new Faker();

    private DataGenerator() {}

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateRandomName() {
        return faker.name().fullName();
    }

    public static String generateRandomJob() {
        return faker.job().title();
    }

    public static String generateRandomRole() {
        return faker.options().option("admin", "user", "guest");
    }
}

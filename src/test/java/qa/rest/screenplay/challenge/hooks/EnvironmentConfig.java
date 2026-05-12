package qa.rest.screenplay.challenge.hooks;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

/**
 * Utility class for retrieving environment-specific configuration properties defined in Serenity's
 * 'serenity.conf' file. This class provides methods to access properties like base URLs and custom
 * configurations based on the active Serenity environment.
 */
public class EnvironmentConfig {

    /** Private constructor to prevent instantiation of this utility class. */
    private EnvironmentConfig() {}

    /**
     * Initializes a static instance of {@link EnvironmentVariables} to access system and
     * Serenity-specific environment variables.
     */
    private static final EnvironmentVariables variables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    /**
     * Retrieves the base URL for the currently active environment. The 'base.url' property is
     * typically defined within the 'environments' section of the 'serenity.conf' file (e.g.,
     * 'environments.default.base.url').
     *
     * @return The base URL as a String.
     */
    public static String getBaseUrl() {
        return EnvironmentSpecificConfiguration.from(variables).getProperty("base.url");
    }

    /**
     * Retrieves a custom property from the Serenity environment configuration. This method allows
     * fetching any property specified by its full path in the 'serenity.conf' file.
     *
     * @param path The full path to the property (e.g., "my.custom.property").
     * @return The value of the custom property as a String.
     */
    public static String getCustomProperty(String path) {
        return EnvironmentSpecificConfiguration.from(variables).getProperty(path);
    }
}

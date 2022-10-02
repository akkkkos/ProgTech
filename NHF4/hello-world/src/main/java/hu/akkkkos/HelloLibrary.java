package hu.akkkkos;

/**
 * Library used for generating greeting text based upon name and language.
 */
public final class HelloLibrary {
    private HelloLibrary() {
    }
    /***
     * Generating greeting text based upon name and language.
     *
     * @param name The name the response should contain.
     * @param lang The language the response should be translated into.
     * @return The generated string.
     */

    public static String genResponse(final String name, final String lang) {
        String result = "Szia, ";
        if (lang.equals("eng")) {
            result = "Hello, ";
        } else if (lang.equals("haw")) {
            result = "Aloha, ";
        }
        result += name + "!";
        return result;
    }

}

package hu.akkkkos;

import static hu.akkkkos.HelloLibrary.genResponse;

public final class Main {
    private Main() {
    }

    /***
     * Getting input from user as arguments and greeting the user.
     * @param args Input arguments from the command line.
     */
    public static void main(final String[] args) {
        if (args.length == 0) {
            System.out.println("Nincs elég argumentum!");
        } else {

            String lang = setLanguage(args);

            if (lang.equals("N/A")) {
                System.out.println("Ismeretlen nyelv! (hun, eng, haw)");
            } else {
                String result = genResponse(args[0], lang);
                System.out.println(result);
            }
        }
    }
    private static String setLanguage(final String[] args) {
        String lang;
        if (args.length == 1) {
            lang = "hun";
        } else {
            switch (args[1]) {
                case "eng":
                    lang = "eng";
                    break;
                case "hun":
                    lang = "hun";
                    break;
                case "haw":
                    lang = "haw";
                    break;
                default:
                    lang = "N/A";
                    break;
            }
        }
        return lang;
    }
}

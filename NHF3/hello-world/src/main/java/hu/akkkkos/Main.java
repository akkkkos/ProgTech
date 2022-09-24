package hu.akkkkos;

import static hu.akkkkos.HelloLibrary.genResponse;

public final class Main {
    private Main() {
    }

    /***
     * Getting input from user as arguments and greeting the user.
     * @param args Input arguments from the terminal
     */
    public static void main(final String[] args) {
        if (args.length == 0) {
            System.out.println("Nincs elég argumentum!");
        } else {
            String lang = "N/A";
            if (args.length == 1) {
                lang = "hun";
            } else {
                if (args[1].equals("eng")) {
                    lang = "eng";
                } else if (args[1].equals("hun")) {
                    lang = "hun";
                } else if (args[1].equals("haw")) {
                    lang = "haw";
                }
            }

            if (lang.equals("N/A")) {
                System.out.println("Ismeretlen nyelv! (hun, eng, haw)");
            } else {
                String result = genResponse(args[0], lang);
                System.out.println(result);
            }
        }
    }
}

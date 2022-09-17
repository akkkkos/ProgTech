package hu.akkkkos;

import static hu.akkkkos.HelloLibrary.Hello;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) System.out.println("Nincs elég argumentum!");
        else {
            String lang = "N/A";
            if (args.length == 1) lang = "hun";
            else {
                if (args[1].equals("eng")) lang = "eng";
                else if (args[1].equals("hun")) lang = "hun";
                else if (args[1].equals("haw")) lang = "haw";
            }

            if (lang.equals("N/A")) System.out.println("Ismeretlen nyelv! (hun, eng, haw)");
            else {
                String result = Hello(args[0], lang);
                System.out.println(result);
            }
        }
    }
}
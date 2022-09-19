package hu.akkkkos;

public class HelloLibrary {
    public static String Hello(String name, String lang)
    {
        String result = "Szia, ";
        if (lang.equals("N/A") || lang.equals("hun")) result = "Szia, ";
        else if (lang.equals("eng")) result = "Hello, ";
        else if (lang.equals("haw")) result = "Aloha, ";
        result += name + "!";
        return result;
    }
}

package hu.akkkkos;

import org.junit.jupiter.api.Test;
import static hu.akkkkos.HelloLibrary.genResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloLibraryTest {
    @Test
    public void testHunLanguageShouldReturnWithSzia() {
        String result = genResponse("Csaba","hun");
        String expected = "Szia, Csaba!";
        assertEquals(result,expected);
    }

    @Test
    public void testEngLanguageShouldReturnWithHello() {
        String result = genResponse("Csaba","eng");
        String expected = "Hello, Csaba!";
        assertEquals(result,expected);
    }

    @Test
    public void testHawLanguageShouldReturnWithAloha() {
        String result = genResponse("Csaba","haw");
        String expected = "Aloha, Csaba!";
        assertEquals(result,expected);
    }
}

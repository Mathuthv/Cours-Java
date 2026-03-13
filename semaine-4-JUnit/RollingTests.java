//package src.test.java;

//import src.main.java.Rolling;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RollingTests {
    @Test
    void testGetRandomBounds() {
        int result = Rolling.getRandom(1, 6);
        // On vérifie la postcondition : le résultat doit être dans l'intervalle
        assertTrue(result >= 1 && result <= 6);
    }

    @Test
    void testRollingRandomReturnsPositive() {
        // Postcondition : le nombre de lancers doit être > 0
        int rolls = Rolling.rolling_random(7);
        assertTrue(rolls > 0);
    }

}

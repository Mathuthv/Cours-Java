package io.github.oliviercailloux.contracts;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import io.github.oliviercailloux.contracts.Multiplier;

public class MultiplierTests {
    @Test
    void testMultiply() {
        // On configure les opérandes
        Multiplier.setGeneralMode();
        Multiplier.setFirstOperand(3);
        Multiplier.setSecondOperand(4);
        
        // On vérifie que 3 * 4 = 12
        assertEquals(12, Multiplier.multiply(), "La multiplication de 3 par 4 devrait donner 12");
    }
}
    
package io.github.oliviercailloux.contracts;

// Importation statique des méthodes de test
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour Multiplier.
 * Le nom finit par "Tests" pour être reconnu par Maven.
 */
public class MultiplierTests {

    @Test
    void testMultiplyGeneralMode() {
        // Test d'une multiplication classique en mode général
        Multiplier.setGeneralMode();
        Multiplier.setFirstOperand(3);
        Multiplier.setSecondOperand(4);
        // assertEquals(attendu, actuel)
        assertEquals(12, Multiplier.multiply(), "3 * 4 devrait être 12");
        
        // Test avec un nombre négatif (autorisé en mode général)
        Multiplier.setFirstOperand(-3);
        assertEquals(-12, Multiplier.multiply(), "-3 * 4 devrait être -12");
    }

    @Test
    void testPositiveModeException() {
        // On active le mode positif
        Multiplier.setPositiveMode();
        
        // On vérifie que le contrat (précondition) lance bien l'exception
        // si on essaie de mettre un nombre négatif
        assertThrows(IllegalStateException.class, () -> {
            Multiplier.setFirstOperand(-5);
        }, "Le mode positif devrait interdire les opérandes négatifs");
        
        // On vérifie que le zéro est aussi interdit (strictement positif)
        assertThrows(IllegalStateException.class, () -> {
            Multiplier.setSecondOperand(0);
        });
    }

    @Test
    void testPositiveResultModeSuccess() {
        // En mode Positive Result, les opérandes peuvent être négatifs tant que le produit est > 0
        Multiplier.setGeneralMode(); // Reset d'abord
        Multiplier.setFirstOperand(-2);
        Multiplier.setSecondOperand(-5);
        Multiplier.setPositiveResultMode();
        
        // (-2) * (-5) = 10 (Strictement positif)
        assertEquals(10, Multiplier.multiply());
    }

    @Test
    void testPositiveResultModeFailure() {
        Multiplier.setGeneralMode();
        Multiplier.setFirstOperand(-2);
        Multiplier.setSecondOperand(5); // Résultat sera -10
        Multiplier.setPositiveResultMode();
        
        // On vérifie que le contrat de sortie (postcondition) est respecté
        // Un résultat négatif doit faire échouer le multiply()
        assertThrows(IllegalStateException.class, () -> {
            Multiplier.multiply();
        });
    }
}
package org.rmartin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test für den Rechtschreibtrainer
 * @author Raphael Martin
 * @version 2024-09-20
 */
public class RechtschreibtrainerTESTS {

    private Rechtschreibtrainer trainer;
    @DisplayName("Vor jedem Test muss ein Rechtschreibtrainer existierten")
    @BeforeEach
    public void setUp() {
        trainer = new Rechtschreibtrainer();
    }

    @DisplayName("Es wird geprüft ob auch wirklich ein Paar ausgewählt wird")
    @Test
    public void testWaehleZufaelligesPaar_NonEmptyList() {
        trainer.waehleZufaelligesPaar();
        assertNotNull(trainer.getAusgewaehltesPaar(), "Ein zufälliges Paar sollte ausgewählt worden sein.");
    }
    @DisplayName("Es wird geprüft ob eine passende Exception geworfen wird, sollte die Liste doch mal leer sein")
    @Test
    public void testWaehleZufaelligesPaar_EmptyList() {
        trainer.getWortBildPaare().clear(); // Leere die Liste

        assertThrows(NullPointerException.class, () -> trainer.waehleZufaelligesPaar(), "Eine leere Liste sollte eine NullPointerException werfen.");
    }
    @DisplayName("Es wird geprüft ob die Statistik bei richtiger Eingabe passt")
    @Test
    public void testRateWort_CorrectGuess() {
        trainer.waehleZufaelligesPaar();
        WortBildPaar paar = trainer.getAusgewaehltesPaar();
        boolean result = trainer.rateWort(paar.getWort());
        assertTrue(result, "Die Eingabe sollte korrekt sein.");
        assertEquals("Stats - Gesamt: 1, Richtig: 1, Falsch: 0", trainer.statistik(), "Ein richtiger Versuch sollte gezählt werden.");
    }
    @DisplayName("Es wird geprüft ob die Statistik bei falscher Eingabe passt")
    @Test
    public void testRateWort_IncorrectGuess() {
        trainer.waehleZufaelligesPaar();
        boolean result = trainer.rateWort("falschesWort");
        assertFalse(result, "Die Eingabe sollte falsch sein.");
        assertEquals("Stats - Gesamt: 1, Richtig: 0, Falsch: 1", trainer.statistik(), "Ein falscher Versuch sollte gezählt werden.");
    }
    @DisplayName("Es wird geprüft ob die Statistik bei verschiedenen Eingaben passt")
    @Test
    public void testStatistik() {
        trainer.waehleZufaelligesPaar();
        trainer.rateWort("falschesWort");
        trainer.rateWort(trainer.getAusgewaehltesPaar().getWort());
        String expectedStats = "Stats - Gesamt: 2, Richtig: 1, Falsch: 1";
        assertEquals(expectedStats, trainer.statistik(), "Die Statistik sollte korrekt sein.");
    }
}

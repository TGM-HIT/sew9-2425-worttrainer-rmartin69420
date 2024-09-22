package org.rmartin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testfälle für die Benutzeroberfläche
 * @author Raphael Martin
 * @version 2024-09-22
 */
public class GUITESTS {

    private GUI gui;
    @DisplayName("Erstellen der GUI vor den Tests")
    @BeforeEach
    public void setUp() {
        gui = new GUI();
    }
    @DisplayName("Prüft ob GUI geladen wird")
    @Test
    public void testStartTrainerWirdGeladen() {
        //Prüft ob Trainer geladen wurde
        assertNotNull(gui);
    }
    @DisplayName("Prüft ob bei einer Nutzereingabe ein Ergebnis zurückkommt")
    @Test
    public void testZeigeStatistikUndBildUndAbfrage() {
        // Simuliert die Eingabe des Benutzers
        String result = gui.zeigeStatistikUndBildUndAbfrage(true);

        //schaut ob eine Art von Antwort zurückkam
        assertNotNull(result);
    }
    @DisplayName("Testet, ob der Trainer korrekt funktioniert und Statistiken anzeigt")
    @Test
    public void testTrainerStats() {
        String statistik = gui.getTrainer().statistik();
        assertNotNull(statistik);
        assertTrue(statistik.contains("Gesamt:"));
    }
}

package org.rmartin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

/**
 * Testen der JSON Listen Konvertierungen
 * @author Raphael Martin
 * @version 2024-09-21
 */
public class JSONTESTS {
    private JSON json;
    private Rechtschreibtrainer trainer;
    @DisplayName("Klassen im vorhinein erstellen und schon Paar auswählen")
    @BeforeEach
    public void setUp() {
        json = new JSON();
        trainer = new Rechtschreibtrainer();
        trainer.waehleZufaelligesPaar();
    }
    @DisplayName("Es wird geprüft ob ein Rechtschreibtrainer erfolgreich gespeichert und dann wieder geladen werden kann")
    @Test
    public void testSaveAndLoad() {
        // Speichern des aktuellen Trainers in JSON-Datei
        json.save(trainer);

        // Datei sollte existieren
        File file = new File("trainer_data.json");
        assertTrue(file.exists(), "Die Datei trainer_data.json sollte existieren!");

        // Laden des Trainers aus der JSON-Datei
        Rechtschreibtrainer geladenerTrainer = json.load();

        // Überprüfung, ob der geladene Trainer nicht null ist
        assertNotNull(geladenerTrainer, "Geladener Trainer sollte nicht null sein!");

        // Überprüfung, ob der Trainer korrekt geladen wurde
        assertEquals(trainer.getWortBildPaare().size(), geladenerTrainer.getWortBildPaare().size(),
                "Die Anzahl der WortBildPaare sollte übereinstimmen.");
        assertEquals(trainer.getAusgewaehltesPaar().getWort(),
                geladenerTrainer.getAusgewaehltesPaar().getWort(),
                "Das ausgewählte WortBildPaar sollte dasselbe sein.");
    }
    @DisplayName("Es wird getestet dass ein default Rechtschreibtrainer geladen wird, wenn die file nicht gefunden wird")
    @Test
    public void testLoadFileNotFound() {
        // Datei löschen, falls vorhanden
        File file = new File("trainer_data.json");
        if (file.exists()) {
            file.delete();
        }

        // Versuchen, Trainer zu laden, wenn die Datei nicht existiert
        Rechtschreibtrainer geladenerTrainer = json.load();

        // Sicherstellen, dass ein leerer Trainer stattdessen zurückgegeben wird
        assertNotNull(geladenerTrainer, "Es sollte ein neuer Rechtschreibtrainer erstellt werden, wenn die Datei nicht existiert.");
    }
}

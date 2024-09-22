package org.rmartin;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Benutzeroberfläche zum verwenden des Worttrainers
 * @author Raphael Martin
 * @version 2024-09-22
 */
public class GUI {
    private Rechtschreibtrainer trainer;
    private Speicherstrategie speicher;

    private boolean firstguess;

    /**
     * Standartkonstruktor für die GUI. Trainer wird aus file geladen
     */
    public GUI() {
        speicher = new JSON();
        this.trainer = speicher.load();
        firstguess = true;
    }

    /**
     * Worttrainer wird gestartet und zeigt ihn mittels JOptionPane an
     */
    public void start() {
        trainer.waehleZufaelligesPaar();
        boolean letzterVersuchErfolgreich = false;

        while (true) {
            // Zeigt das Bild und die Statistik in einem Panel und frage nach dem Wort
            String wort = zeigeStatistikUndBildUndAbfrage(letzterVersuchErfolgreich);
            firstguess = false;
            if (wort == null || wort.isEmpty()) {
                // Beendet das Programm, wenn nichts eingegeben wurde
                break;
            }

            // Prüft, ob das Wort richtig ist
            letzterVersuchErfolgreich = trainer.rateWort(wort);
        }

        // Speichern des Zustands vor dem Beenden
        Speicherstrategie speicher = new JSON();
        speicher.save(trainer);
        JOptionPane.showMessageDialog(null, "Programm beendet. Daten wurden gespeichert.");
    }

    /**
     * Zeigt Statistik, Bild und Abfrage in einem Panel an
     */
    public String zeigeStatistikUndBildUndAbfrage(boolean letzterVersuchErfolgreich) {
        WortBildPaar aktuellesPaar = trainer.getAusgewaehltesPaar();
        String bildURL = aktuellesPaar.getBildURL();

        // Baut die Nachricht zusammen
        String nachricht = "<html>" + trainer.statistik();
        if (firstguess) {
        } else if (!letzterVersuchErfolgreich){
            nachricht += "<br>Der letzte Versuch war falsch.</html>";
        } else {
            nachricht += "<br>Der letzte Versuch war richtig!</html>";
        }

        // Erstellt das Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Fügt die Statistik als JLabel hinzu
        JLabel labelText = new JLabel(nachricht);
        panel.add(labelText);

        try {
            // Ladet und skaliere das Bild
            URL url = new URL(bildURL);
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImg);

            // Fügt das Bild als JLabel hinzu
            JLabel labelImage = new JLabel(icon);
            panel.add(labelImage);
        } catch (Exception e) {
            // Fallback, falls das Bild nicht geladen werden kann
            panel.add(new JLabel("(Bild konnte nicht geladen werden)"));
        }

        // Fügt das Eingabefeld für das Wort hinzu
        JTextField wortFeld = new JTextField(20);
        panel.add(new JLabel("Bitte das Wort eingeben:"));
        panel.add(wortFeld);

        // Zeigt das Panel in einem JOptionPane-Dialog an
        int option = JOptionPane.showConfirmDialog(null, panel, "Bild und Wortabfrage", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Gibt das eingegebene Wort zurück oder null, wenn der Nutzer abbricht
        if (option == JOptionPane.OK_OPTION) {
            return wortFeld.getText();
        } else {
            return null; // Benutzer hat abgebrochen
        }
    }

    public Rechtschreibtrainer getTrainer() {
        return trainer;
    }
}

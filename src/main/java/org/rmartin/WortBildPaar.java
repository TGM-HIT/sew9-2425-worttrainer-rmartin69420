package org.rmartin;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Ein Bild mit einer passenden Beschreibung als Lösung
 * @author Raphael Martin
 * @version 2024-09-20
 */
public class WortBildPaar {
    private String wort;
    private String bildURL;

    /**
     * Konstruktor für ein Wort mit dessen Bild URL
     * @param wort Das Wort
     * @param bildURL Der URL des Bildes
     */
    public WortBildPaar(String wort, String bildURL) {
        if (this.checkWort(wort)) {
            this.wort = wort;
        } else{
            throw new NullPointerException("Bitte gültiges Wort eingeben!");
        }
        if (WortBildPaar.isValid(bildURL)){
            this.bildURL = bildURL;
        } else{
            throw new IllegalArgumentException("Bitte gib einen gültigen Link ein!");
        }
    }

    /**
     * Es wird gecheckt ob das Wort valide ist
     * @param wort Das Wort
     * @return Ob es valide ist oder nicht
     */
    public boolean checkWort(String wort){
        if (wort != null) {
            return true;
        } else{
            return false;
        }
    }

    /**
     * Es wird gechekt ob der URL valide ist
     * @param bildURL Der URL
     * @return ob er valide ist oder nicht
     */
    public static boolean isValid(String bildURL){
        try {
            new URL(bildURL).toURI(); // checkt Aufbau des URL
            return true;
        } catch (MalformedURLException | IllegalArgumentException | URISyntaxException | NullPointerException e) {
            return false;
        }
    }

    /**
     * Getter für das Wort
     * @return das Wort
     */
    public String getWort() {
        return wort;
    }

    /**
     * Setter für das Wort
     * @param wort das neue Wort
     */
    public void setWort(String wort) {
        this.wort = wort;
    }

    /**
     * Getter für den URL
     * @return den URL
     */
    public String getBildURL() {
        return bildURL;
    }

    /**
     * Setter für den URL
     * @param bildURL den neuen URL
     */
    public void setBildURL(String bildURL) {
        this.bildURL = bildURL;
    }
}

package org.rmartin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Übernimmt die Logik des Wort checkens
 * @author Raphael Martin
 * @version 2024-09-20
 */
public class Rechtschreibtrainer {
    private ArrayList<WortBildPaar> wortBildPaare;
    private WortBildPaar ausgewaehltesPaar;
    private int versucheGesamt;
    private int versucheRichtig;
    private int versucheFalsch;



    /**
     * Konstruktor für den Trainer, es werden eigene Paare erstellt
     */
    public Rechtschreibtrainer(){
        wortBildPaare = new ArrayList<>();
        wortBildPaare.add(new WortBildPaar("Amadeus", "https://img1.wsimg.com/isteam/ip/a2084964-e52e-4dd5-879e-4247b3041b95/Amadeus.png/:/cr=t:6.53%25,l:0%25,w:100%25,h:86.93%25/rs=w:365,h:487,cg:true"));
        wortBildPaare.add(new WortBildPaar("Mann", "https://static.wikia.nocookie.net/listofdeaths/images/7/70/Patrick_Bateman.webp/revision/latest?cb=20220422182540"));
        wortBildPaare.add(new WortBildPaar("Hot dog", "https://c8.alamy.com/compde/a1nb6c/daschund-dog-in-hot-dog-kostum-verkleidet-a1nb6c.jpg"));
        wortBildPaare.add(new WortBildPaar("Kacper", "https://c8.alamy.com/comp/R04P00/an-elderly-polish-man-with-a-beard-and-pipe-wearing-traditional-clothing-in-the-town-of-zakopone-poland-europe-R04P00.jpg"));
        wortBildPaare.add(new WortBildPaar("Spongebob", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2D5kwPWqew0Xot0t9vDwMibR4cssV6fvPPjp1hB_m2c5-QqfitDL1RpVaq3RsxS4oH3Y&usqp=CAU"));
        versucheGesamt = 0;
        versucheRichtig = 0;
        versucheFalsch = 0;
    }

    /**
     * Wählt ein zufällige Paar von der Liste aus und speichert es
     */
    public void waehleZufaelligesPaar(){
        if (!wortBildPaare.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(wortBildPaare.size()); // generates a random index
            ausgewaehltesPaar = wortBildPaare.get(randomIndex); // sets the randomly selected pair
        } else {
            throw new NullPointerException("Leere Liste!");
        }
    }

    /**
     * Das eingegebene Wort wird mit der Lösung verglichen. Bei falscheingabe bleibt das Bild
     * ansonsten geht es zum nächsten.
     * @param wort Geratene Wort
     * @return ob es richtig erraten wurde
     */
    public boolean rateWort(String wort){
        this.versucheGesamt++;
        if(wort.equals(this.ausgewaehltesPaar.getWort())){
            this.versucheRichtig++;
            this.waehleZufaelligesPaar();
            return true;
        } else {
            this.versucheFalsch++;
            return false;
        }
    }

    /**
     * Statistik zu dem aktuellen Punktestand
     * @return die Statistik
     */
    public String statistik(){
        return "Stats - Gesamt: " + this.versucheGesamt + ", Richtig: " + this.versucheRichtig + ", Falsch: " + this.versucheFalsch;
    }

    /**
     * Das aktuelle Paar wird zurückgegeben
     * @return aktuelle Paar
     */
    public WortBildPaar getAusgewaehltesPaar() {
        return ausgewaehltesPaar;
    }
}

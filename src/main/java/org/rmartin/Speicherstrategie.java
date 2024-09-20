package org.rmartin;

/**
 * Speicherstrategie-Interface für das Speichern und Laden von RechtschreibTrainer
 * @author Raphael Martin
 * @version 2024-09-20
 */
interface Speicherstrategie {
    /**
     * Speichern von einer Rechtschreibtrainer Liste
     * @param trainer Der Trainer
     */
    void save(Rechtschreibtrainer trainer);

    /**
     * Laden eines Rechtschreibtrainers basiert auf einer Liste
     * @return den Trainer
     */
    Rechtschreibtrainer load();
}
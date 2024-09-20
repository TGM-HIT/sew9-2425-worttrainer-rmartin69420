package org.rmartin;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * JSON-Klasse, die die Speicherstrategie implementiert und
 * den RechtschreibTrainer in JSON speichert und lädt.
 */
public class JSON implements Speicherstrategie {

    private static final String FILE_NAME = "trainer_data.json";

    /**
     * Speichert Daten eines Rechtschreibtrainers in eine JSON Liste
     * @param trainer Der Trainer
     */
    @Override
    public void save(Rechtschreibtrainer trainer) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = new Gson();
            gson.toJson(trainer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ladet Daten von einer Liste in einen Rechtschreibtrainer rein
     * @return Den Rechtschreibtrainer
     */
    @Override
    public Rechtschreibtrainer load() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Gson gson = new Gson();
            Type trainerType = new TypeToken<Rechtschreibtrainer>() {}.getType();
            return gson.fromJson(reader, trainerType);
        } catch (IOException e) {
            e.printStackTrace();
            return new Rechtschreibtrainer(); // Rückgabe eines neuen Trainers im Fehlerfall
        }
    }
}
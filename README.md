### README

# Rechtschreibtrainer mit grafischer Oberfläche

## Projektübersicht

Dieses Programm ist ein **Rechtschreibtrainer**, der dem Benutzer Wort-Bild-Paare präsentiert und ihn auffordert, das richtige Wort zu dem angezeigten Bild einzugeben. Die Benutzeroberfläche wurde mit **JOptionPane** erstellt, sodass der Benutzer innerhalb eines einzigen Dialogfensters die aktuelle Statistik, das Bild und eine Eingabemöglichkeit sieht.

Das Programm bietet:
- **Zufällige Wort-Bild-Paare**: Der Benutzer sieht ein Bild und muss das passende Wort eingeben.
- **Statistiken**: Zeigt die Anzahl der Versuche, der richtigen und falschen Eingaben.
- **Bildanzeige im GUI**: Die Bilder werden skaliert und zusammen mit der Abfrage in einem einzigen Dialogfenster angezeigt.
- **Persistenz der Daten**: Beim Programmstart werden die gespeicherten Daten geladen, und beim Beenden wird der aktuelle Fortschritt gespeichert.

## Funktionalität

1. **Starten des Trainers**: Beim Start des Programms wird überprüft, ob gespeicherte Daten vorliegen. Falls ja, wird der vorherige Fortschritt geladen. Ansonsten wird ein neuer Trainer mit vordefinierten Wort-Bild-Paaren erstellt.
2. **Eingabe des Wortes**: Für jedes zufällig ausgewählte Bild gibt der Benutzer das zugehörige Wort ein.
3. **Statistiken**: Nach jedem Versuch wird angezeigt, ob die Eingabe richtig oder falsch war, sowie eine Übersicht der bisherigen Versuche.
4. **Programm beenden**: Durch eine leere Eingabe kann der Benutzer den Trainer verlassen, und der Fortschritt wird gespeichert.

## Technologien

Das Programm nutzt folgende Technologien und Werkzeuge:
- **Java**: Programmiersprache zur Entwicklung des Trainers und der GUI.
- **JOptionPane**: Für die grafische Benutzeroberfläche.
- **JUnit 5**: Für Unit-Tests zur Sicherstellung der Funktionalität.
- **Gradle**: Build-Management-Tool zur Verwaltung der Abhängigkeiten und des Projekts.
- **JSON**: Zur Persistierung der Daten.

## Installation und Ausführung

1. Stelle sicher, dass **Gradle** installiert ist.
2. Lade das Projekt herunter und navigiere im Terminal in das Projektverzeichnis.
3. Führe folgenden Befehl aus, um das Programm zu starten:
   ```bash
   gradle run
   ```

## Tests

Das Projekt enthält **JUnit 5**-Testfälle, um die wichtigsten Funktionalitäten des Trainers und der GUI zu testen. Um die Tests auszuführen, verwende den folgenden Befehl:
```bash
gradle test
```

## Zu beachten als Anwender

- Beim Start des Programms sollte eine funktionierende Internetverbindung bestehen, um die Bilder aus den URLs zu laden.
- Die Eingabe erfolgt in einem Pop-up-Fenster (JOptionPane). Achte darauf, dass keine leeren Eingaben gemacht werden, wenn du das Programm weiter nutzen möchtest.
- Die Bilder im Trainer werden automatisch skaliert. Sollte ein Bild nicht geladen werden können, wird ein Fallback-Text angezeigt.

---

Dieses Programm bietet eine einfache Möglichkeit, das Schreiben und Erkennen von Wörtern zu trainieren, unterstützt durch eine intuitive grafische Oberfläche.

# Aufgabe 8: Wahlen

## Thema: Referenzdatentypen, Arrays, Klassen

# Aufgabenstellung

Du wirst damit betraut, Auswertungen für verschiedene unterschiedliche Wahlen anzufertigen. Zum Glück wurde der härteste Teil dieser Aufgabe bereits erledigt: Jemand hat die Stimmen bereits ausgezählt und die resultierenden Daten in einem dreidimensionalen Array abgebildet.

Die drei Dimensionen des Arrays korrespondieren mit den folgenden Werten:

- Die erste Dimension unterscheidet zwischen den verschiedenen Wahlen [Wahlnummer].
- Die zweite Dimension fasst die Stimmabgaben aller Wähler zusammen.
- Die dritte Dimension gibt die Präferenzen eines Wählers an (Erstwahl, Zweitwahl,..).

Ein einzelner Wähler kann also mehrere Präferenzen angeben und Du musst verschiedene Auszählungsmethoden implementieren, eine davon wird die Präferenzenreihenfolge beachten.

### Mehrheitswahlrecht (first pass the post)

Dies ist der üblichste Weg einer Abstimmung: Nur die Erstwahl jedes Wählers wird herangezogen und ermittelt wird die Reihenfolge der Kandidaten gemäß der Häufigkeit ihrer erhaltenen Stimmen.

Sieht eine Wahl so aus

- Kandidat A erhält 2 Stimmen
- B: 4 Stimmen
- C: 0 Stimmen
- D: 3 Stimmen
- E: 5 Stimmen

würde als Wahlergebnis die Reihenfolge [E, B, D, A, C] ermittelt werden.

### Rangfolgewahl (instant runoff)

Diese Abstimmung besteht aus mehreren Runden von Mehrheitswahlen. Nach jeder Runde wird der Kandidat entfernt, der am wenigsten Stimmen erhalten hat. Dies wird so lange durchgeführt, bis ein einzelner Kandidat mehr als 50% der Stimmen erhalten hat (das gilt auch, wenn nur ein Kandidat übrig geblieben ist).

Betrachten wir eine Wahl mit den drei Kandidaten A, B und C und den 7 mit römischen Zahlen gekennzeichneten Wählern:

    I:   [A,B,C]
    II:  [C]
    III: [A]
    IV:  [A,C,B]
    V:   [C]
    VI:  [C,B]
    VII: [B,A]

Nach dem Mehrheitswahlrecht erhalten wir folgende Werte:

- A: 3 Stimmen
- B: 1 Stimme
- C: 3 Stimmen

Würde nur das Mehrheitswahlrecht gelten, so wäre diese Wahl unentschieden. In der Rangfolgewahl aber wird jetzt der Kandidat mit den wenigsten Stimmen eliminiert, in diesem Fall ist das B. Daraus entsteht eine andere Verteilung der Stimmen:

    I:   [A, C]
    II:  [C]
    III: [A]
    IV:  [A,C]
    V:   [C]
    VI:  [C]
    VII: [A]

Zählen wir wieder die Mehrheiten aus, kommen wir zu:

- A: 4 Stimmen
- B: 0 Stimmen
- C: 3 Stimmen

Der Wähler, der B als Erstwahl hatte, wählte mit der Zweitstimme A und entscheidet so die Wahl. A hat jetzt mehr als 50% der Stimmen das Gesamtergebnis dieser Wahl resultiert in [A, C, B].

Um die Implementierung einfach zu halten, soll bei der Instant-Runoff-Wahl nicht beachtet werden, in welcher Reihenfolge die Verlierer ausscheiden.
Stattdessen werden die Eliminierungen in den Wahldurchgängen durchgeführt, bis eine Mehrheit und somit ein Wahlsieg ermittelt wurde. Die dann bestehende Stimmenzahlen werden derart interpretiert, dass Kandidaten mit gleicher Stimmenanzahl in der Reihenfolge ihrer Indizes aufgeführt werden (so wie es in unserer Implementierung auch beim Mehrheitswahlrecht gilt).

## Zu erfüllende Vorgaben

Lade Dir die gegebenen Source- und Test-Dateien herunter. Die Klassen des Projekts sind noch nicht vollständig implementiert, sondern es existieren Daten und Methodenköpfe ohne ihre Rümpfe. Lies die Kommentare sorgfältig und implementiere jede Methode, die eine "@todo"-JavaDoc-Annotation enthält. Wir empfehlen nachdrücklich, die Klassen in der Reihenfolge der folgenden Erklärungen und die Methoden in der Reihenfolge ihres Auftretens zu implementieren und die bereits implementierten Methoden in den weiteren Methoden zu nutzen.

- Wie schon erwähnt, wurden die Stimmabgaben bereits gezählt und in der Klasse `Data` zur Verfügung gestellt. Du musst sicherstellen, dass die erhobenen Daten während der Laufzeit unter keinen Umständen verändert werden können.
- Da für die Verarbeitung der Arrays sehr spezielle Operationen notwendig sind, werden diese in einer einzelnen Klasse `ArrayUtils` zusammengefasst. Keine Methode in dieser Klasse darf die Werte verändern, die sie mit ihrem Parameter erhält.
- Die Klasse `Election` enthält die Routinen, die zur Auswertung einer Wahl notwendig sind. Die Methoden aus `ArrayUtils` werden hier sehr hilfreich sein.
- Die Klasse `Ueb08` übernimmt die Interaktion mit dem Benutzer. Dies ist die einzige Klasse, in der eine Nutzung von `System.out` oder `Scanner` erlaubt ist. Diese Klasse muss mindestens drei Methoden enthalten:
  - `int chooseElection()` Teilt dem Nutzer mit, wie viele Wahlen verfügbar sind und fordert zur Eingabe der ID einer dieser Wahlen auf. Mit der Eingabe von "-1" beendet der Nutzer die Auswahl und Auswertung. Gibt der Nutzer eine ungültige Nummer ein, erfolgt die Eingabeaufforderung erneut. Rückgabewert der Methode ist die gültige Wahl des Nutzers. Die Aus- und Eingabe sieht dann in etwa so aus:

            Die Daten von 7 Wahlen sind vorhanden. 
            Geben Sie die Nummer einer Wahl (0 - 6) ein oder -1 zum Beenden. 
            1337
            Die Daten von 7 Wahlen sind vorhanden.
            Geben Sie die Nummer einer Wahl (0 - 6) ein oder -1 zum Beenden.
            6

  - `void printElectionResults(int[][] result)` gibt die Ergebnisse einer Wahl auf `System.out` aus. Die Anzahl der Leerzeichen, die die Ergebnisse von den Namen trennt, soll per default 15 betragen, müssen aber zur Kompilationszeit veränderbar sein (Konstante nutzen).

            1) E. Herms      : 5
            2) A. Gebäudchen : 4
            3) G. Kayak      : 3
            4) M. Riema      : 2
            5) E. Cola       : 1

  - `void main(String[] args)` Fragt den Nutzer wiederholt nach der zu analysierenden Wahl und gibt die Ergebnisse dieser Wahl nach beiden Auszählmethoden aus. Der Nutzer kann die Abfrage durch die Eingabe von "-1" beenden. Die Parameter der `main`-Methode werden nicht genutzt.

### In dieser und allen folgenden Übungen gilt:

In jeder zu erstellenden Klasse dürfen als `private` deklarierte Methoden zugefügt werden, jedoch keine `public`-Methoden! Auf `private`-Methoden dürfen nur Methoden der eigenen Klasse zugreifen.

Verwendet keine Euch bekannten Methoden aus irgendeiner Bibliothek, sondern benutzt nur die im Tutorium bis zu diesem Zeitpunkt vorgestellten Mechanismen und Methoden oder gesondert in der Aufgabenstellung erlaubten Methoden. Auch wenn es immer geschicktere und kürzere Möglichkeiten gibt, das Programm in Java zu erstellen, so sollen explizit die gerade im Tutorium vorgestellten Themen geübt werden.

## Abnahmetest

In diesem Repo findet ihr drei Testdateien.

## Hilfe

Alle TODOs eines Projektes kann man sich in dem Fenster "Action Items" (hervorrufbar durch [Alt + 6]) anschauen und von dort mit Anklicken in die entsprechende Codezeile springen.

Denkt daran, dass das Ergebnis einer integer-Division immer ganzzahlig ist. Führt man also "2 / 10" aus, so erhält man "0" und nicht "0.2f". Um ein Fließkommaergebnis zu erhalten, muss mindestens einer der Operanden eine Gleitkommazahl sein.

Um die Anzahl der Elemente in einem Array zu erfahren, kann length benutzt werden (Beispiel: `count = arrayVar.length;`).

Ein Array kann durch das Anwenden von `clone()` kopiert werden (Beispiel: `int[] arrayNew = arrayOld.clone();`). Dies erzeugt allerdings keine tiefe Kopie, was zum Beispiel bei mehrdimensionalen Arrays erforderlich ist.

Greift man auf einen Arrayplatz mit einem ungültigen Indexwert zu, so erhält man eine `java.lang.ArrayIndexOutOfBoundsException`. Die rot angezeigte Fehlermeldung tritt nicht unbedingt in der erwarteten zeitlichen Abfolge der Programmausgaben auf, da hierfür ein anderer Ausgabekanal (`System.err` statt `System.out`) bedient wird, aber in den Folgezeilen der Fehlermeldung ist genau angegeben, an welcher Stelle im Sourcecode dieser Fehler entstand.

Da ihr bereits genug mit Stringformatierung gearbeitet habt, bieten wir euch den print-Befehl, um Zeit zu sparen.
```           
 System.out.format("%2d) %-14s: %d%n", i, candidateName, voteCount);
```

**Viel Erfolg!**
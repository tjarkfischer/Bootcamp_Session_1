# Aufgabenpool:

### Solltet ihr alle Aufgaben aus eurer Session abgeschlossen haben, könnt ihr euch gern an  diesem Aufgabenpool bedienen und versuchen, die Aufgaben zu lösen.
# 🚀🚀🚀

### Aufgabenverzeichnis:
*** check ✅ your Challenges ***

* - [ ] [FizzBuzz 👊](#FizzBuzz)
* - [ ] [Stringculator 🧮](#Stringculator)
* - [ ] [Stringionary📚](#Stringionary)
* - [ ] [Modulonary🔢](#Modulonary)

*Die Aufgaben sind nicht nach Schwierigkeit geordnet
___
## FizzBuzz👊
### Aufgabenbeschreibung:
Schreibe ein Programm, welches die Zahlen von 1 bis 100 printet. Dabei sollen folgende Fälle berücksichtigt werden:
* Wenn die Zahl durch 3 teilbar ist, printe statt der Zahl ein `Fizz`.
* Wenn die Zahl durch 5 teilbar ist, printe statt der Zahl ein `Buzz`.
* Wenn die Zahl durch 3 sowie durch 5 teilbar ist, printe statt der Zahl ein `FizzBuzz`.

### Erweiterungen
* Erweitere die Ausnahmen zum Beispiel mit Zahlen der Fibonacci-Reihe, oder mit Primzahlen.

### Beispiel:
```
1
2
Fizz
4
Buzz
Fizz
7
...
13
14
FizzBuzz
16
17
```
___
## Stringculator🧮
### Aufgabenbeschreibung:
Schreibe ein Programm, welches 2 Zahlen in Form eines Strings als Input nimmt und das Ergebnis, ebenfalls als String, wieder zurückgibt.
### Hinweise:
* Ist ein Input leer, berücksichtige ihn als 0.

### Erweiterungen:
* Im ersten Schritt wird nur die Addition der Strings berücksichtigt. Als Erweiterung währe eine Implementierung weiterer Operanten möglich.

### Beispiel:
```
Input1, Input2 --> Output:
"6", "4" --> "10"
"3", "8" --> "11"
"", "" --> "0"
"4", "" --> "4"
```
___
## Stringionary📚
### Aufgabenbeschreibung:
Schreibe ein Programm, welches einen String akzeptiert und alle Groß- und Kleinbuchstaben in diesem String zählt.

<details>
<summary>Lösungshinweise</summary>
<br>
- Zwei hilfreiche Stringmethoden sind ".isupper()" und ".islower()"
</details>

### Erweiterungen:
* Eine mögliche Erweiterung wäre die Zählung aller Satzzeichen oder nur die Zählung von Sonderzeichen oder Leerzeichen.
### Beispiel:
```
Originaler String: Hallo ihr neuen Auszubild*innen, wie gefällt euch das Python Bootcamp?
Anzahl der Großbuchstaben: 4
Anzahl der Kleinbuchstaben: 54
```
___
## Modulonary🔢
### Aufgabenbeschreibung:
Schreibe ein Programm, welches über eine Zahlenfolge iteriert und bei jeder Zahl bestimmt, ob es sich um eine gerade oder eine ungerade Zahl handelt.

<details><summary>Lösungshinweise</summary>
<br>
- Um diese Aufgabe zu lösen ist die Nutzung des Modulos sehr hilfreich.
</details>

### Beispiel:
```
0 even
1 odd
2 even
```
---
## Getränkeautomat🥤
### Aufgabenbeschreibung:
Schreibe ein Programm, mit welchem du mit einem Getränkeautomat chatten kannst, der dir ein Getränk deiner Wahl ausgibt.
### Hinweis
* Erstelle eine Getränkeliste, die der Automat dir wiedergeben kann.
* Baue verschiedene Auswahlmöglichkeiten ein, um zwischen den verschiedenen Menüs des Automaten zu wechseln.

### Beispiel:
```
Automat: Wie kann ich dir behilflich sein?
Auswahlmöglichkeiten:
1. Getränkekarte
2. Getränkebestellung
3. Abbruch
>> 1
Automat: Hier findest du eine Übersicht über alle meine Getränke:
1. Cola
2. Spezi
3. RedBull
Wähle ein Getränk oder gehe Zurück zur Übersicht:
>> 2
Automat: Hier ist eine Spezi für dich, lass es dir schmecken!
```

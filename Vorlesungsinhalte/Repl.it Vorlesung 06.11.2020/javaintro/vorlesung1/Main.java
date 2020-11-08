package javaintro.vorlesung1; // wir gruppieren alle für dieses Beispiel verwendeten Klassen im Paket "javaintro.vorlesung1"

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        /*
         * Grundlagen
         */
        // Java ist statisch typisiert, im Gegensatz zu Python, das dynamisch typisiert ist
        // -> wir müssen Java mitteilen, welchen Typ es bei einer Variable, als Rückgabewert usw. zu erwarten hat
        String text; // Deklaration: "Sagt" Java, dass es eine Variable vom Typ der Klasse "String" gibt. Hat noch keinen Wert!
        text = "Hello World"; // Initialisierung: "Sagt" Java, dass die Variable "text" den Wert "Hello World" erhält.
        String text2 = "Hello World 2"; // Deklaration und Initialisierung kann man auch in einer Zeile vornehmen
        // text = 1; // Das geht nicht, weil 1 ein Integer ist, Java aber einen String für die Variable "text" erwartet!

        // Basistypen
        byte einByte = 123; // Werte: -128 bis 127
        short kurzeGanzzahl = -12345; // Werte: -32,768 bis 32,767
        int ganzzahl = 9382; // Werte: -2,147,483,648 bis 2,147,483,647
        long grosseGanzzahl = 28387827871L; // Werte: -9,223,372,036,854,775,808 bis 9,223,372,036,854,775,807 ("L" am Ende beachten!)
        float kommazahl = 4.5f; // einfache Genauigkeit, 6 bis 7 Nachkommastellen ("f" am Ende beachten!)
        double genauereKommazahl = 4.5; // doppelte Genauigkeit, 15 Nachkommastellen
        boolean wahrheitswert = true; // oder "false"
        char buchstabe = 'A'; // ein einzelner Buchstabe (mit '' statt "" wie bei Strings)

        String zeichenkette = "Hello World"; // kein "echter" Basistyp, verhält sich teilweise wie einer (siehe Exkurs zu Strings vs. Basistypen)
        String alternativInitialisierteZeichenkette = new String("Hello World"); // "String" ist eine Klasse, lässt sich also auch wie ein "normales" Objekt über den Konstruktor initialisieren

        System.out.println("Wert von Variable zeichenkette" + zeichenkette); // gibt "Hello World" an der Konsole aus

        /*
         * Arrays (Listen)
         */
        int[] integerArray = new int[5]; // ein "statisches" Array, das Platz für genau 5 Elemente (Index 0 bis 4) besitzt
        integerArray[1] = 5; // an der zweiten Stelle des Arrays speichern wir den Wert 5
        System.out.println("Länge des Arrays integerArray: " + integerArray.length); // erwartete Ausgabe: 5 (da 5 Elemente "Platz" im Array haben)

        int[] integerArrayMitWerten = {1, 2, 5, 8, 12, 42}; // ein "statisches" Array, das Platz für genau 6 Elemente (Index 0 bis 5) besitzt und mit den Elementen 1, 2, 5, 8, 12, 42 initialisiert wurde
        System.out.println("Länge des Arrays integerArrayMitWerten: " + integerArrayMitWerten.length); // erwartete Ausgabe: 6 (da Array mit 6 Elementen initialisiert wurde)

        // Auch hier ist nicht immer im Vorhinein (also während der Programmierung) bekannt, wie viele Elemente das Array enthalten soll
        ArrayList<String> zeichenkettenArray = new ArrayList<>(); // mit Hilfe der Java-Klasse "ArrayList" lässt sich ein dynamisches Array erstellen
        zeichenkettenArray.add("A");
        zeichenkettenArray.add("B");
        // ...
        System.out.println("Länge der ArrayList zeichenkettenArray: " + zeichenkettenArray.size()); // gibt die Anzahl der Elemente im zeichenketteArray aus (in diesem Fall 2)
        zeichenkettenArray.remove("B"); // entfernt "B" aus dem Array
        // -> dadurch lässt sich die "Dynamik" einer Python-Liste erzielen, d.h. zur Programmlaufzeit können (theoretisch) beliebig viele Elemente zur ArrayList hinzugefügrt werden

        /*
         * Beispiel: Modellierung von Spielern
         */
        // Wir haben in den Python-Vorlesungen pro "Eigenschaft" bzw. Attribut eines Spielers eine eigene Variable angelegt
        String player1_name = "Max";
        String player2_name = "Moritz";

        // ... für die Punktzahl
        int player1_score = 0;
        int player2_score = 0;

        // Das ist nicht besonders dynamisch, wir wissen nicht immer im Vorhinein, wie viele Spieler wir benötigen werden
        // Außerdem ist das fehleranfällig, da man immer an das Anlegen von jeder Variable für jede Eigenschaft denken muss

        // Eine Alternative wäre die "Zusammenfassung" von den Eigenschaften in Arrays (Listen)
        String[] player_names = {"Max", "Moritz"};
        int[] player_scores = {0, 0};
        // Allerdings benötigt man auch hier eine Konvention, z.B. "alle Eigenschaften von Spieler i befinden sich an Index i des jeweiligen Eigenschaftsarrays
        // -> das ist ebenfalls fehleranfällig und für Dritte schwer zu verstehen

        System.out.println(); // leere Zeile als Abstandshalter

        // Lösung: Wir können ein "Objekt" wie z. B. einen Spieler auch einfach als eine Klasse, d.h. eine "Vorlage" für ein Spieler-Objekt modellieren
        // Dann sind pro Spieler alle seine Eigenschaften/Attribute und Methoden ("was er tun kann") sauber zusammengefasst
        // Aus dieser Klasse können dann theoretisch unendlich viele Spieler-Objekte mit unterschiedlichen Eigenschaftswerten erstellt werden
        Fahrzeug auto1 = new Fahrzeug(); // ein neues Fahrzeug, die Referenz wird in der Variable "auto1" gespeichert
        auto1.preis = 1000; // Das Attribut "preis" für das "auto1" hat den Wert 1000
        auto1.name = "Auto 1"; // Das Attribut "name" für das "auto1" hat den Wert "Auto 1"

        Fahrzeug auto2 = new Fahrzeug(); // ein weiteres Fahrzeug, die Referenz wird in der Variable "auto2" gespeichert
        auto2.name = "Auto 2";
        auto2.preis = 500;

        System.out.println(); // leere Zeile als Abstandshalter

        Spieler spieler1 = new Spieler("Max", 22, 1); // für die Klasse Spieler haben wir einen weiteren Konstruktor definiert, der drei Parameter entgegennimmt (siehe Spieler.java)
        //spieler1.name = "Max"; // dies wird nicht mehr unbedingt, da wir den Namen des spieler1 bereits bei der Erstellung über "new" mitgegeben haben
        spieler1.score = 1100;
        spieler1.beitreten();

        System.out.println("Ist spieler1 online? " + spieler1.isOnline); // Ausgabe: true

        Spieler spieler2 = new Spieler("Moritz", 21, 2);
        // spieler2.name = "Moritz"; // dies wird nicht unbedingt benötigt, da wir den Namen des spieler1 bereits bei der Erstellung über "new" mitgegeben haben
        spieler2.score = 200;

        System.out.println("Ist spieler1 online? " + spieler1.isOnline); // Ausgabe: true
        System.out.println("Ist spieler2 online? " + spieler2.isOnline); // Ausgabe: false (Standard-Wert)

        spieler2.beitreten(); // nun tritt auch spieler2 bei

        System.out.println("Ist spieler1 online? " + spieler1.isOnline); // Ausgabe: true
        System.out.println("Ist spieler2 online? " + spieler2.isOnline); // Ausgabe: true

        System.out.println(); // leere Zeile als Abstandshalter

        System.out.println("Der Name von spieler1 ist: " + spieler1.name); // der Wert des Attributs "name" des Objekts "spieler1" des Typs/der Klasse "Spieler" ist "Max"
        System.out.println("Der Name von spieler2 ist: " + spieler2.name); // der Wert des Attributs "name" des Objekts "spieler1" des Typs/der Klasse "Spieler" ist "Moritz"

        System.out.println(); // leere Zeile als Abstandshalter

        System.out.println("Die Punktzahl für spieler1 vor dem Kauf von auto1 ist: " + spieler1.score); // spieler1 hat auto1 gekauft, also ist die Score 1100 - 1000 = 100
        System.out.println("Kauf von auto1 für spieler1 möglich? " + spieler1.fahrzeugKaufen(auto1)); // die erwartete Ausgabe ist "true", da "spieler1.score >= 1000"
        System.out.println("Die Punktzahl für spieler1 nach dem Kauf von auto1 ist: " + spieler1.score); // spieler1 hat auto1 gekauft, also ist die Score 1100 - 1000 = 100
        spieler1.fahrzeugKaufen(auto2); // die erwartete Ausgabe ist "false", da "spieler1.score" nach dem Kauf des ersten Autos nur noch 100 beträgit

        System.out.println(); // leere Zeile als Abstandshalter

        // Über eine for-Schleife lassen wir uns alle Fahrzeuge des spieler1-Objekts ausgeben
        System.out.println("Folgende Fahrzeuge sind im Besitz von " + spieler1.name + ":");
        for (Fahrzeug fahrzeug : spieler1.fahrzeuge) { // diese Notation für "für jedes Element des Arrays spieler1.fahrzeuge" kann bei ArrayLists verwendet werden
            System.out.println(fahrzeug.toString()); // die Methode "toString()" haben wir in der Fahrzeug-Klasse (Fahrzeug.java) definiert
        }

        System.out.println(); // leere Zeile als Abstandshalter

        // Alternative über eine "klassische" for-Schleife
        System.out.println("(KLASSISCHE FOR-SCHLEIFE) Folgende Fahrzeuge sind im Besitz von " + spieler1.name + ":");
        // int i = 0 -> initialisiere die Zählervariable i (Typ: int) mit 0
        // i < spieler1.fahrzeuge.size() -> führe die Schleife aus, solange i kleiner als die Anzahl der Elemente in der Fahrzeuge-ArrayList von spieler1 sind
        // i++ -> inkrementiere nach jedem Durchlauf um 1 (gleichbedeutend mit i = i + 1;)
        for (int i = 0; i < spieler1.fahrzeuge.size(); i++) {
            Fahrzeug fahrzeug = spieler1.fahrzeuge.get(i); // das Fahrzeug-Objekt an Index i der ArrayList holen
            System.out.println(fahrzeug.toString());
        }

        System.out.println(); // leere Zeile als Abstandshalter

        System.out.println("Die Punktzahl für spieler1 ist: " + spieler1.score); // spieler1 hat auto1 gekauft, also ist die Score 1100 - 1000 = 100
        System.out.println("Die Punktzahl für spieler2 ist: " + spieler2.score); // spieler2 hat noch kein Fahrzeug gekauft, da die Methode "fahrzeugKaufen(Fahrzeug fahrzeug);" noch nicht aufgerufen wurde

        spieler2.fahrzeugKaufen(auto1); // spieler1.score < 1000 -> Ausgabe ist "false"
        spieler2.fahrzeugKaufen(auto2); // spieler1.score < 500 -> Ausgabe ist "false"

        System.out.println("Die Punktzahl für spieler1 ist: " + spieler1.score); // spieler1 hat weiterhin nur auto1 gekauft, also ist die Score 1100 - 1000 = 100
        System.out.println("Die Punktzahl für spieler2 ist: " + spieler2.score); // spieler2 konnte sich kein Auto leisten, also ist die Score weiterhin 200

        System.out.println(); // leere Zeile als Abstandshalter

        /*
         * Weiteres Beispiel für die Vorteile von z. B. ArrayLists im Vergleich zu den "statischen" Array über die []-Notation
         */
        ArrayList<Spieler> spielerListe = new ArrayList<>(); // wir initialisieren eine leere ArrayList (.size() -> 0)
        for (int i = 0; i < 100; i++) { // diese Schleife läuft 100 mal durch (i = 0 bis i = 99)
            // in jedem Durchlauf wird der ArrayList ein weiteres Spieler-Objekt hinzugefügt mit folgenden Attributwerten:
            // name:  "Test" + i -> z. B. "Test 1"
            // alter: 20
            // startnummer: i + 1 -> z. B. 2
            spielerListe.add(new Spieler("Test " + i, 20, (i + 1)));
            // zusätzlich setzen wir die Punktzahl (score) des jeweiligen Spielers auf den Wert von i
            spielerListe.get(i).score = i;
        }

        System.out.println("Es wurden " + spielerListe.size() + " Spieler-Objekte in der ArrayList spielerListe abgespeichert."); // Ausgabe: 100, da wir 100 Elemente zur ArrayList hinzugefügt haben
        System.out.println("Die Punktzahl vom Spieler an Index 50 der spielerListe ist: " + spielerListe.get(50).score); // das Spieler-Objekt am Index 50 der ArrayList besitzt den Attributwert "50" für die Punktzahl
    }
}

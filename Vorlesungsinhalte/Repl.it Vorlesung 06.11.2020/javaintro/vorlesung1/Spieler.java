package javaintro.vorlesung1; // wir gruppieren alle für dieses Beispiel verwendeten Klassen im Paket "javaintro.vorlesung1"

import java.util.List;
import java.util.ArrayList;

class Spieler {
  /*
   * Attribute eines Spielers
   */
  String name;
  int score = 0; // ist initial immer 0 (Verwendung als Spiel-Währung)
  int alter;
  int startnummer;
  int anzahlSiege = 0; // ist initial immer 0
  int anzahlNiederlagen = 0; // ist initial immer 0
  boolean isOnline = false; // true, false (initial ist ein Spieler offline)
  List<Fahrzeug> fahrzeuge = new ArrayList<>(); // initial eine leere ArrayList, d.h. eine Liste mit 0 Elementen

  /*
   * Methoden eines Spielers
   */
  // Konstruktor (wird bei der Erstellung eines Objekts der Klasse "Spieler" mit z. B. new Spieler("Max", 22, 1); aufgerufen)
  Spieler(String name, int alter, int startnummer) {
    this.name = name; // wir setzen das Attribut "name" des neuen Objekts = dem Parameter "name"
    this.alter = alter; // wir setzen das Attribut "alter" des neuen Objekts = dem Parameter "alter"
    this.startnummer = startnummer; // wir setzen das Attribut "startnummer" des neuen Objekts = dem Parameter "startnummer"
  }

  // Beim Aufruf dieser Methode auf einem Spieler-Objekt wird das Attribut "isOnline" auf "true" gesetzt, d.h. der Spieler ist danach online
  void beitreten() {
    this.isOnline = true;
  }

  // Beim Aufruf dieser Methode auf einem Spieler-Objekt wird das Attribut "isOnline" auf "false" gesetzt, d.h. der Spieler ist danach offline
  void verlassen() {
    this.isOnline = false;
  }

  // Beim Aufruf dieser Methode wird das als Parameter übergebene Objekt der Klasse "Fahrzeug" der Fahrzeug-ArrayList des Spieler-Objekts hinzugefügt
  boolean fahrzeugKaufen(Fahrzeug fahrzeug) {
    if(this.score >= fahrzeug.preis){ // aber nur, wenn Spieler-score >= Fahrzeugpreis ist (dann gebe true zurück, ansonsten false)
      this.score -= fahrzeug.preis; // Preis des Fahrzeugs von der Score (~ dem Geld) des Spielers subtrahieren
      this.fahrzeuge.add(fahrzeug); // Fahrzeug der Liste "fahrzeuge" hinzufügen

      return true; // Kauf war erfolgreich => true zurückgeben
    } else{
      return false; // Kauf war nicht erfolgreich => false zurückgeben
    }
  }
}
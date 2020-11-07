import java.util.List;
import java.util.ArrayList;

class Spieler {
  // Attribute eiens Spielers
  String name;
  int score = 0; // als Geld benutzen
  int alter;
  int startnummer;
  int anzahlSiege = 0;
  int anzahlNiederlagen = 0;
  boolean isOnline = false; // true, false
  List<Fahrzeug> fahrzeuge = new ArrayList<>();

  // Methoden
  Spieler(String name, int alter, int startnummer) {
    this.name = name;
    this.alter = alter;
    this.startnummer = startnummer;
  }

  void beitreten() {
    this.isOnline = true;
  }

  void verlassen() {
    this.isOnline = false;
  }

  boolean fahrzeugKaufen(Fahrzeug fahrzeug) {
    // fahrzeug den Fahrzeugen des Spielers hinzufügen
    // aber nur, wenn Spieler-score >= Fahrzeugpreis ist (dann gebe true zurück, ansonsten false)
    if(this.score >= fahrzeug.preis){
      this.score -= fahrzeug.preis;
      fahrzeuge.add(fahrzeug);
      return true;
    } else{
      return false;
    }
  }
}
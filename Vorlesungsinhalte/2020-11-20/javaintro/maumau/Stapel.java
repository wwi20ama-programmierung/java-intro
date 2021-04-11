package javaintro.maumau;

import java.util.ArrayList;
import java.util.Collections;

public class Stapel {
  // Attribute
  private ArrayList<Karte> karten = new ArrayList<>();

  // Methoden
  public void addKarte(Karte karte) {
    this.karten.add(karte);
  }

  public void removeKarte(Karte karte) {
    this.karten.remove(karte);
  }

  // Gebe für ein Stapel-Objekt alle darin gespeicherten Karten als ArrayList zurück
  public ArrayList<Karte> getKarten() {
    return this.karten;
  }

  public Karte getObereKarte() {
    return this.karten.get(this.karten.size() - 1);
  }

  public Karte getAtIndex(int index) {
    return this.karten.get(index);
  }

  public int getSize() {
    return this.karten.size();
  }

  public void clearKarten() {
    this.karten.clear();
  }

  public void mischen() {
    // siehe Dokumentation: https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Collections.html#shuffle(java.util.List)
    Collections.shuffle(this.karten);

    // hierüber können wir bei mehrmaligem Ausführen von mischen() prüfen, ob sich jeweils die erste Karte der this.karten-ArrayList ändert = es wurde gemischt
    // System.out.println(this.karten.get(0));
  }

  // Falls der Kartenstapel leer ist, legen wir alle Karten vom Ablagestapel auf den Kartenstapel und mischen neu
  public void neuMischen(Stapel ablagestapel) {
    if(this.isStapelEmpty()) {
      // Ablagestapel auf dem Kartenstapel "speichern"
      this.karten.addAll(ablagestapel.getKarten());
      // Kartenstapel mischen
      this.mischen();
      // Ablagestapel leeren
      ablagestapel.clearKarten();
    }
  }

  // Hilfsmethode, erspart uns den Weg über die ArrayList (von anderen Objekten aus)
  // Außerdem sollte ein Stapel "ermitteln" können, ob er gerade leer ist.
  public boolean isStapelEmpty() {
    return this.karten.isEmpty();
  }

  public void ziehen(Stapel zielstapel) {
    if(this.isStapelEmpty()) {
      // ... dann können wir nichts ziehen und beenden die Methode
      return;
    }

    Karte untereKarte = this.karten.get(0); // Ist nicht die oberste, sondern die unterste Karte (da Index 0 zuerst hinzugefügt) -> aus Python-Beispiel übernommen
    zielstapel.addKarte(untereKarte);
    this.karten.remove(untereKarte);
  }

  // Solange "ziehen" aufrufen, bis der Spieler 6 neue Karten auf der Hand (= Stapel) hat
  public void geben(Stapel zielstapel) {
    if(this.karten.size() < 6) {
      return;
    }

    for(int i = 0; i < 6; i++) {
      this.ziehen(zielstapel);
    }
  }

  // Karten auf dem Stapel aufgelistet an der Konsole ausgeben
  // (wird für das "Präsentieren" der Spielerhand verwendet)
  public void listKarten() {
    for(int i = 0; i < this.karten.size(); i++) {
      Karte karte = this.karten.get(i);
      System.out.println((i + 1) + ". " + karte.getSymbol() + " " + karte.getWert()); // z. B. "1. Herz Bube"
    }

    // Alternative über foreach-Loop hat den "Nachteil", dass wir manuell einen "counter" hinzufügen müssen,
    // weil wir dem Spieler die Auswahlmöglichkeiten ("Kartennummern") für die Eingaben anzeigen wollen

    /*
    int counter = 1;
    for(Karte dieKarte : this.karten) {
      System.out.println((counter + 1) + ". " + dieKarte.getSymbol() + " " + dieKarte.getWert()); // z. B. "1. Herz Bube"
      counter++;
    }
    */
  }
}
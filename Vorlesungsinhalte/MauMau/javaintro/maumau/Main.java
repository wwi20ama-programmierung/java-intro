package javaintro.maumau;

class Main {
  public static void main(String[] args) {
    // Zwei Spieler initialisieren (Annahme: vorerst nur zwei Spieler unterstützt)
    Spieler spieler1 = new Spieler("Rotkäppchen");
    Spieler spieler2 = new Spieler("Böser Wolf");

    // Spiel-Objekt erzeugen
    Spiel spiel = new Spiel();

    // Aktuellen Spieler setzen ("wer anfängt")
    spiel.setAktuellerSpieler(spieler1);

    // Kartenstapel initialiseren und mit allen 32 Karten füllen
    Stapel kartenstapel = new Stapel();
    spiel.stapelInitialisieren(kartenstapel);

    // Ablagestapel initialisieren
    Stapel ablagestapel = new Stapel();

    // TODO: Weiteren Code aus dem Python-Projekt übertragen und adaptieren
    //  (https://github.com/wwi20ama-programmierung/python-intro/blob/main/Vorlesungsinhalte/2020-10-23_MauMau/maumau.py)
  }
}
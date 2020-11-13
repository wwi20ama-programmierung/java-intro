package javaintro.maumau;

public class Spiel {
  // Attribute

  // wir speichern den aktuellen Spieler im Spiel, da es zu jeder Zeit nur einen geben kann.
  // Folglich würde es keinen Sinn machen, wenn jeder Spieler (= jedes Spieler-Objekt) ein Attribut "aktuellerSpieler" hätte
  private Spieler aktuellerSpieler;

  // Methoden
  public Spieler getAktuellerSpieler() {
    return this.aktuellerSpieler;
  }

  public void setAktuellerSpieler(Spieler spieler) {
    this.aktuellerSpieler = spieler;
  }

  // "Hilfsmethode" zum Initialisieren der vorgegeben Spielkarten
  public void stapelInitialisieren(Stapel stapel) {
    // Wir erhalten als Parameter die Stapel-Referenz, d.h. wir können über addKarte() dem Stapel-Objekt neue Elemente hinzufügen

    // Schreibweise 1: Deklaration und Initialisierung getrennt von Übergabe an Methode
    Karte karte1 = new Karte("Kreuz", "Sieben");
    stapel.addKarte(karte1);
    // Schreibweise 2: inline (Initialisierung und Übergabe an Methode in einem Schritt)
    stapel.addKarte(new Karte("Kreuz", "Acht"));
    stapel.addKarte(new Karte("Kreuz", "Neun"));
    stapel.addKarte(new Karte("Kreuz", "Zehn"));
    stapel.addKarte(new Karte("Kreuz", "Bube"));
    stapel.addKarte(new Karte("Kreuz", "Dame"));
    stapel.addKarte(new Karte("Kreuz", "König"));
    stapel.addKarte(new Karte("Kreuz", "Ass"));

    stapel.addKarte(new Karte("Pik", "Sieben"));
    stapel.addKarte(new Karte("Pik", "Acht"));
    stapel.addKarte(new Karte("Pik", "Neun"));
    stapel.addKarte(new Karte("Pik", "Zehn"));
    stapel.addKarte(new Karte("Pik", "Bube"));
    stapel.addKarte(new Karte("Pik", "Dame"));
    stapel.addKarte(new Karte("Pik", "König"));
    stapel.addKarte(new Karte("Pik", "Ass"));

    stapel.addKarte(new Karte("Herz", "Sieben"));
    stapel.addKarte(new Karte("Herz", "Acht"));
    stapel.addKarte(new Karte("Herz", "Neun"));
    stapel.addKarte(new Karte("Herz", "Zehn"));
    stapel.addKarte(new Karte("Herz", "Bube"));
    stapel.addKarte(new Karte("Herz", "Dame"));
    stapel.addKarte(new Karte("Herz", "König"));
    stapel.addKarte(new Karte("Herz", "Ass"));

    stapel.addKarte(new Karte("Karo", "Sieben"));
    stapel.addKarte(new Karte("Karo", "Acht"));
    stapel.addKarte(new Karte("Karo", "Neun"));
    stapel.addKarte(new Karte("Karo", "Zehn"));
    stapel.addKarte(new Karte("Karo", "Bube"));
    stapel.addKarte(new Karte("Karo", "Dame"));
    stapel.addKarte(new Karte("Karo", "König"));
    stapel.addKarte(new Karte("Karo", "Ass"));
  }
}
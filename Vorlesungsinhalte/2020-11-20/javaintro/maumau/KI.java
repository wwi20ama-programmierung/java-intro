package javaintro.maumau;

// Der KI-Spieler erbt alle Attribute und Methoden vom "normalen" (menschlichen) Spieler
public class KI extends Spieler {

  // Konstruktor
  public KI(String name) {
    super(name); // wir rufen den Konstruktor der Elternklasse ("Spieler") auf
    System.out.println(this.name);
  }

  // Wir ergänzen die KI-Klasse mit einer weiteren Methode (im Vergleich zur Elternklasse "Spieler")
  public void getNextAction() {
    // ermitteln, welche Züge der Computerspieler durchführen kann

    // AUFGABE: Implementieren Sie einen Computerspieler, der selbstständig eine Auswahl trifft (Karte legen falls möglich, ansonsten ziehen) wenn er an der Reihe ist

  }
}
package javaintro.vorlesung1; // wir gruppieren alle für dieses Beispiel verwendeten Klassen im Paket "javaintro.vorlesung1"

class Fahrzeug {
  String name;
  double preis; // brutto

  // diese Variable ist "static", wird also nicht pro mit "new" initialisiertem Objekt gespeichert, sondern für ALLE Objekte der Klasse "Fahrzeug"
  public static int anzahlInitialisierteFahrzeuge = 0;

  Fahrzeug() {
    anzahlInitialisierteFahrzeuge++; // zähle die Anzahl der initialisierten Fahrzeuge um 1 hoch
    // da "this" immer auf das Objekt und nicht auf die Klasse verweist, ist ein Zugriff über "this.anzahlInitialisierteFahrzeuge" ungültig
    System.out.println("Anzahl initialisierte Fahrzeuge: " + anzahlInitialisierteFahrzeuge);
  }

  public void setName(String name) {
    this.name = name.toLowerCase();
  }

  public String getName() {
    return this.name;
  }

  public void setBruttoPreis(double preis) {
    this.preis = preis;
  }

  public void setNettoPreis(double nettoPreis) {
    this.preis = nettoPreis * 1.16;
  }

  public String toString() {
    return "Das Fahrzeug heißt " + this.name + " und hat den Preis = " + this.preis;
  }
}
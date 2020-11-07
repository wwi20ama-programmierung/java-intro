// package dhbw.autospiel;

class Fahrzeug {
  String name;
  double preis; // brutto

  public static int anzahlInitialisierteFahrzeuge = 0;

  Fahrzeug() {
    anzahlInitialisierteFahrzeuge++;
    System.out.println("Anzahl initialisierte Fahrzeuge : " + anzahlInitialisierteFahrzeuge);
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
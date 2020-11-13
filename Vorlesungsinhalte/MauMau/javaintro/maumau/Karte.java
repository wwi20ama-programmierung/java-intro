package javaintro.maumau;

public class Karte {
  // Attribute
  private String symbol;
  private String wert; // Wert als String, damit Bube, Dame, König, Ass auch abgebildet werden können

  // Konstruktor
  Karte(String symbol, String wert) {
    this.symbol = symbol;
    this.wert = wert;
  }
}


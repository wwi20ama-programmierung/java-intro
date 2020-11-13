package javaintro.maumau;

public class Spieler {
  // Attribute
  private String name;
  private Stapel hand = new Stapel(); // die "hand" ist auch "nur" ein Stapel, weshalb wir diese über ein Stapel-Objekt abgeben

  // Konstruktor
  Spieler(String name) {
    this.name = name;
  }
}
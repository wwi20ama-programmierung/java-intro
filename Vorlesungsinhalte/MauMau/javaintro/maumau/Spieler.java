package javaintro.maumau;

public class Spieler {
  private String name;
  private Stapel hand = new Stapel();
  // boolean istAktuellerSpieler;

  Spieler(String name) {
    this.name = name;
  }
}
package javaintro.maumau;

class Main {
  public static void main(String[] args) {
    Spieler spieler1 = new Spieler("Rotkäppchen");
    Spieler spieler2 = new Spieler("Böser Wolf");

    Spiel spiel = new Spiel();
    spiel.setAktuellerSpieler(spieler1);

    Stapel kartenstapel = new Stapel();
    spiel.stapelInitialisieren(kartenstapel);

    Stapel ablagestapel = new Stapel();

    kartenstapel.mischen();
    kartenstapel.mischen();
    kartenstapel.mischen();
    kartenstapel.mischen();
    kartenstapel.mischen();
    
  }
}
package javaintro.maumau;

public class Spiel {
  private Spieler aktuellerSpieler;

  public Spieler getAktuellerSpieler() {
    return this.aktuellerSpieler;
  }

  public void setAktuellerSpieler(Spieler spieler) {

  }

  public void stapelInitialisieren(Stapel stapel) {
    Karte karte1 = new Karte("Kreuz", "Sieben");
    stapel.addKarte(karte1);
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
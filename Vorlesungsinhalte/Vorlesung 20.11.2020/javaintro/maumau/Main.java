package javaintro.maumau;

class Main {
    public static void main(String[] args) {
        // Neues Spiel erzeugen
        Spiel maumau = new Spiel();

        // Spieler erzeugen
        Spieler spieler1 = new Spieler("Rotkäppchen");
        Spieler spieler2 = new Spieler("Böser Wolf");
        Spieler spieler3 = new Spieler("Max");

        // Die Spieler dem Spiel hinzufügen
        maumau.addSpieler(spieler1);
        maumau.addSpieler(spieler2);
        maumau.addSpieler(spieler3);

        // Spiel starten
        maumau.start();

        // Den folgenden auskommentierten Code haben wir in die Spiel-Klasse verschoben:
        // maumau.setAktuellerSpieler(spieler1);

        // Karten- und Ablagestapel initialisieren, mischen usw.
        // Stapel kartenstapel = new Stapel();
        // maumau.stapelInitialisieren(kartenstapel);

        // Stapel ablagestapel = new Stapel();
        // kartenstapel.mischen();

        // Karten an Spieler austeilen
        // kartenstapel.geben(spieler1.getHand());
        // kartenstapel.geben(spieler2.getHand());
        // maumau.gebeKarten(spieler1.getHand());
        // maumau.gebeKarten(spieler2.getHand());

        // System.out.println(kartenstapel.getKarten().size());
        // System.out.println(spieler1.getHand().getKarten().size());
        // kartenstapel.ziehen(ablagestapel);

        // System.out.println(kartenstapel.getKarten().size()); // 19
        // System.out.println(ablagestapel.getKarten().size()); // 1

        /*
        while (spieler1.getHand().getSize() != 0 && spieler2.getHand().getSize() != 0) {
          maumau.zug();

          if(maumau.getAktuellerSpieler() == spieler1) {
            maumau.setAktuellerSpieler(spieler2);
          } else {
            maumau.setAktuellerSpieler(spieler1);
          }
        }

        if(spieler1.getHand().getSize() == 0) {
          System.out.println(spieler1.getName() + " hat das Spiel gewonnen.");
        } else {
          System.out.println(spieler2.getName() + " hat das Spiel gewonnen.");
        }
        */
    }
}
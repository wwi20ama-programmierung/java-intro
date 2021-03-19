package javaintro.weihnachtsmann.lebewesen;

import javaintro.weihnachtsmann.geschenke.Wunsch;
import javaintro.weihnachtsmann.geschenke.Auto;
import javaintro.weihnachtsmann.geschenke.Geschenk;
import javaintro.weihnachtsmann.geschenke.Schuh;
import javaintro.weihnachtsmann.geschenke.Spiel;

import java.util.ArrayList;

public class Weihnachtsmann extends Lebewesen {
    private final int ENERGIE = 150;
    private final int ENERGIEVERBRAUCH = 10;
    private ArrayList<Wunsch> wuensche = new ArrayList<>();

    public Weihnachtsmann() {
        this.name = "Weihnachtsmann"; // Der Weihnachtsmann hat immer den gleichen Namen
        this.energie = ENERGIE;
    }


    @Override
    public void regenerieren() {
        System.out.println("Der Weihnachtsmann macht ein Nickerchen.");
        this.energie = ENERGIE;
    }

    @Override
    public void bewegen() {
        System.out.println("Der Weihnachtsmann bewegt sich!");
        this.energie -= ENERGIEVERBRAUCH;
    }

    public void wunschlisteEmpfangen(Kind kind) {
        if (kind.isBrav()) {
            this.wuensche.addAll(kind.getWuensche()); // alle Wünsche der Merkliste des Weihnachtsmanns hinzufügen
        } else {
            System.out.println(kind.getName() + " war nicht brav und darf sich deshalb nichts vom Weihnachtsmann wünschen!");
        }
    }

    public ArrayList<Wunsch> getAlleWuensche() {
        return this.wuensche;
    }

    public Geschenk verzaubern(Wunsch wunsch) {

        switch (wunsch.getArt()) {
            case "Auto":
                return new Auto(wunsch);
            case "Schuh":
                return new Schuh(wunsch);
            case "Spiel":
                return new Spiel(wunsch);
            // case "Kleidungsstück":
            //  return new Kleidungsstueck(wunsch);
            default:
                System.out.println("Es gibt keine Spezialisierungsklasse für den Wunsch: " + wunsch.getArt());
                return new Geschenk(wunsch);
        }

    /*if(wunsch.getArt().equals("javaintro.weihnachtsmann.geschenke.Auto")) {
      return new javaintro.weihnachtsmann.geschenke.Auto(wunsch);
    } else if(wunsch.getArt().equals("javaintro.weihnachtsmann.geschenke.Schuh")) {
      return new javaintro.weihnachtsmann.geschenke.Schuh(wunsch);
    } else if(wunsch.getArt().equals("javaintro.weihnachtsmann.geschenke.Spiel")) {
      return new javaintro.weihnachtsmann.geschenke.Spiel(wunsch);
    } else {
      System.out.println("Es gibt keine Spezialisierungsklasse für den Wunsch: " + wunsch.getArt());
      return new javaintro.weihnachtsmann.geschenke.Geschenk(wunsch);
    }*/
    }
}
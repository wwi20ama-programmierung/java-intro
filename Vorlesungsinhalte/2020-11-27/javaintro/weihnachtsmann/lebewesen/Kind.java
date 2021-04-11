package javaintro.weihnachtsmann.lebewesen;

import javaintro.weihnachtsmann.geschenke.Wunsch;

import java.util.ArrayList;

public class Kind {
    private String name;
    private boolean isBrav = false;
    private String adresse;
    private ArrayList<Wunsch> wuensche = new ArrayList<>();
    private char geschlecht;

    public Kind(String name, boolean isBrav, String adresse, char geschlecht) {
        this.name = name;
        this.isBrav = isBrav;
        this.adresse = adresse;
        this.geschlecht = geschlecht;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public char getGeschlecht() {
        return this.geschlecht;
    }

    public boolean isBrav() {
        return this.isBrav;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Wunsch> getWuensche() {
        return this.wuensche;
    }

    public void wuenschen(String name, String art) {
        Wunsch neuerWunsch = new Wunsch(name, art, this); // Wir "verknüpfen" das neue Wunsch-Objekt mit dem Kind-Objekt, für das wir "wuenschen" aufrufen ("this")
        this.wuensche.add(neuerWunsch);
    }

    public void wunschlisteSenden(Weihnachtsmann weihnachtsmann) {
        weihnachtsmann.wunschlisteEmpfangen(this);
    }
}
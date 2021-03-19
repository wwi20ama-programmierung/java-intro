package javaintro.weihnachtsmann.geschenke;

import javaintro.weihnachtsmann.lebewesen.Kind;

// Wir wollen weiterhin neue Objekte der Klasse "Geschenk" initialisieren können, falls wir sie nicht spezialisieren (also Auto, Schuh oder Spiel zuordnen) können
public class Geschenk {
    // Attribute sind protected, damit sie auch für die Subklassen sichtbar sind
    protected String schleifenFarbe;
    protected Wunsch wunsch;

    public Geschenk(Wunsch wunsch) {
        this.wunsch = wunsch;

        // Schleifenfarbe anhand des Geschlechts des Kinds ermitteln (über das Wunsch-Objekt)
        Kind wuenschendesKind = wunsch.getKind();
        if (wuenschendesKind.getGeschlecht() == 'm') { // '' statt "", da es sich beim Attribut um einen Char und keinen String handelt
            this.schleifenFarbe = "blau";
        } else {
            this.schleifenFarbe = "rosa";
        }

        System.out.println("Ein neues Geschenk für " + wuenschendesKind.getName() + " mit einer Schleife in " + this.schleifenFarbe + " wurde gezaubert!");
    }

    public Wunsch getWunsch() {
        return this.wunsch;
    }
}
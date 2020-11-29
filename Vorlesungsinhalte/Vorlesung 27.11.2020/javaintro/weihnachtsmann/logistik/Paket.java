package javaintro.weihnachtsmann.logistik;

import javaintro.weihnachtsmann.geschenke.Geschenk;

public class Paket {
    private Geschenk geschenk;
    private int gewicht;

    public Paket(Geschenk geschenk) {

        this.geschenk = geschenk;

        // Da für die "switch"-Anweisungen die möglichen Werte bereits zur Kompilierungszeit ermittelbar sein müssen,
        // können wir nicht die Klasse als Unterscheidungsmerkmal verwenden und benutzen stattdessen den Klassennamen:
        Class konkreteKlasse = geschenk.getClass();
        String klassenname = konkreteKlasse.getSimpleName();

        switch (klassenname) {
            case "Schuh":
                this.gewicht = 2;
                break;
            case "Auto":
                this.gewicht = 10;
                break;
            case "Spiel":
                this.gewicht = 1;
                break;
            case "Geschenk":
                this.gewicht = 5;
                break;
        }
    }

    public int getGewicht() {
        return this.gewicht;
    }

    /**
     * Ermittelt die Adresse, an die das Paket geliefert werden soll:
     * Paket -> Geschenk -> Wunsch -> Kind -> adresse: String
     */
    public String getAdresse() {
        // Ausführliche Form:
        // Wunsch wunsch = this.geschenk.getWunsch();
        // Kind kind = wunsch.getKind();
        // String adresse = kind.getAdresse();
        // return adresse;

        // Kurzform:
        return this.geschenk.getWunsch().getKind().getAdresse();
    }
}
package javaintro.weihnachtsmann;

import javaintro.weihnachtsmann.geschenke.Wunsch;
import javaintro.weihnachtsmann.lebewesen.Kind;
import javaintro.weihnachtsmann.geschenke.Auto;
import javaintro.weihnachtsmann.logistik.Paket;

class Main {
    public static void main(String[] args) {
        Kind kind1 = new Kind("Lisa", true, "Hauptstraße 21, 68159 Mannheim", 'w');
        Kind kind2 = new Kind("Max", false, "Hauptstraße 21, 68159 Mannheim", 'm');

        Wunsch wunsch1 = new Wunsch("Blaues ferngesteuertes Auto", "Auto", kind1);
        Auto geschenk = new Auto(wunsch1);
        Paket paket1 = new Paket(geschenk);

        System.out.println(paket1.getGewicht());
    }
}
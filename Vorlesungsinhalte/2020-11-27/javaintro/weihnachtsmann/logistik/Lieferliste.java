package javaintro.weihnachtsmann.logistik;

import java.util.ArrayList;

public class Lieferliste {
    private ArrayList<Paket> pakete = new ArrayList<>();

    public void addPaket(Paket paket) {
        this.pakete.add(paket);
    }

    public int getGesamtgewicht() {
        int gesamtgewicht = 0;

        for (Paket paket : this.pakete) {
            gesamtgewicht += paket.getGewicht();
        }

        return gesamtgewicht;
    }
}
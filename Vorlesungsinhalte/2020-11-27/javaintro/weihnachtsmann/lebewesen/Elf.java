package javaintro.weihnachtsmann.lebewesen;

import javaintro.weihnachtsmann.geschenke.Geschenk;
import javaintro.weihnachtsmann.logistik.Paket;

public class Elf extends Lebewesen {
    private final int ENERGIE = 100;
    private final int ENERGIEVERBRAUCH = 5;

    public Elf(String name) {
        this.name = name;
        this.energie = ENERGIE;
    }


    @Override
    public void regenerieren() {
        System.out.println("Der Elf macht ein Päuschen.");
        this.energie = ENERGIE;
    }

    @Override
    public void bewegen() {
        System.out.println("Der Elf wuselt herum!");
        this.energie -= ENERGIEVERBRAUCH;
    }

    public void fuettern(Rentier rentier) {
        rentier.regenerieren();
    }

    public Paket verpacken(Geschenk geschenk) {
        return new Paket(geschenk);
    }
}
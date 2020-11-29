package javaintro.weihnachtsmann.lebewesen;

public class Rentier extends Lebewesen {
    private final int ENERGIE = 1000;
    private final int ENERGIEVERBRAUCH = 50;

    public Rentier(String name) {
        this.name = name; // Name wird von "Lebewesen" geerbt und ist auch für "Rentier" sichtbar (da "protected")
        this.energie = ENERGIE;
    }


    @Override
    public void regenerieren() {
        System.out.println("Das Rentier frisst.");
        this.energie = ENERGIE;
    }

    @Override
    public void bewegen() {
        System.out.println("Das Rentier " + this.name +  " rennt und fliegt.");
        this.energie -= ENERGIEVERBRAUCH;
    }
}
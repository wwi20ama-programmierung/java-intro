package javaintro.maumau;

public class Spieler {
    // Attribute
    protected String name;
    private Stapel hand = new Stapel(); // die "hand" ist auch "nur" ein Stapel, weshalb wir diese über ein Stapel-Objekt abgeben

    // Konstruktor
    Spieler(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Stapel getHand() {
        return this.hand;
    }
}
package javaintro.maumau.ki;

public class Spieler {
    // Attribute
    protected String name;
    private Stapel hand = new Stapel(); // die "hand" ist auch "nur" ein Stapel, weshalb wir diese über ein Stapel-Objekt abgeben

    public boolean isKI = false; // Alternative zur Verwendung von .getClass()

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
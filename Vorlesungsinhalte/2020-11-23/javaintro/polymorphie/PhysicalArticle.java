package javaintro.polymorphie;

public class PhysicalArticle extends BaseArticle {
    int stock;

    PhysicalArticle(String name, int stock) {
        super(name);
        this.stock = stock;
    }

    // Nur für PhysicalArticle-Objekte verwendbar
    String getDetails() {
        return "Ich bin ein PhysicalArticle mit einem Bestand von " + this.stock + " und heiße " + this.name;
    }
}
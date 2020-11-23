package javaintro.polymorphie;

public class BaseArticle {
    String name;

    BaseArticle(String name) {
        this.name = name;
    }

    // Für BaseArticle-Objekte und Objekte aller Subklassen verwendbar, die sie nicht überschreiben
    String getDetails() {
        return "Ich bin ein BaseArticle und heiße " + this.name;
    }
}

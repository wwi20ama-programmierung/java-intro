package javaintro.onlineshop.vererbung;

// Ein "normaler" Artikel, der alle Attribute und Methoden besitzt, die alle davon erbenden Artikel-Klassen teilen
public class Article {
    // Da "private" nur für "Article"-Objekte und nicht für davon erbende Objekte ("PhysicalArticle" und "DownloadArticle") sichtbar wäre, müssen wir hier "protected" verwenden (siehe Objektorientierungs-Basics)
    protected String name;

    // Alternativ könnten wir alle möglichen Attribute (also für "normale", physische und Download-Produkte) hier angeben und auf "null" oder "0" setzen.
    // Das macht es aber unübersichtlich.

    //  private int stock;
    //  private int bitrate;

    protected double price;
    protected Category category;

    // Das ist der Konstruktor für unsere "Basis-Klasse" Article
    Article(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        System.out.println("Ein neuer normaler Artikel wurde angelegt:" + this.name);
    }

    public double getPrice() {
        return this.price;
    }

    // Wird die Methode "getArticleDetails()" in der jeweiligen erbenden Klasse (Kindklasse) nicht überschrieben, wird diese aufgerufen
    public String getArticleDetails() {
        return this.name + " (" + this.price + " €)"; // z. B. "Smartphone (200.00 €)"
    }

    // Diese beiden folgenden Methoden aus der Vorlesung vom 13.11 funktionieren nun nicht mehr, da der Basisartikel keinen Bestand mehr hat.
    /*public void incrementStock() {
    this.stock++; // this.stock = this.stock + 1;
    }

    // = Artikel wurde in einen Warenkorb hinzugefügt
    public boolean decrementStock() {
    if(this.stock == 0) {
      return false; // Artikel nicht mehr verfügbar
    } else {
      this.stock--; // this.stock = this.stock - 1;
      return true;
    }
    }*/
}

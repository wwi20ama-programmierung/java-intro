package javaintro.onlineshop;

public class Article {
  // Attribute
  private String name;
  private int stock;
  private double price;
  private Category category; // wir haben festgelegt, dass ein Artikel immer genau einer Kategorie gehört

  // Konstruktor
  Article(String name, int stock, double price, Category category) {
    this.name = name;
    this.stock = stock;
    this.price = price;
    this.category = category;
  }

  public double getPrice() {
    return this.price;
  }

  public String getArticleDetails() {
    // "Hilfsmethode", damit wir
    // 1. Zugriff auf die private-Attribute von "außerhalb" des Objekts ermöglichen
    // 2. als Entwickler der Article-Klasse selbst bestimmen können, wie die Artikeldetails angezeigt werden sollen
    return this.name + " (" + this.price + " €) mit " + this.stock + " Einheiten im Lager.";
  }

  // = Artikel wurde aus einem Warenkorb entfernt
  public void incrementStock() {
    this.stock++; // Kurzform für: this.stock = this.stock + 1;
  }

  // = Artikel wurde in einen Warenkorb hinzugefügt
  public boolean decrementStock() {
    if(this.stock == 0) {
      return false; // Artikel nicht mehr verfügbar
    } else {
      this.stock--; // this.stock = this.stock - 1;
      return true;
    }
  }
}

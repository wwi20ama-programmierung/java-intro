package javaintro.onlineshop;

public class Category {
  // Attribute
  private String name;

  // Konstruktor
  Category(String name) {
    this.name = name;
  }

  // Methoden
  // Hinweis: hier wird nur ein Getter für das Attribut "name" benötigt
  public String getName() {
    return name;
  }
}
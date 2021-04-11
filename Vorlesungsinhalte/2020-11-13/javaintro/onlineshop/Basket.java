package javaintro.onlineshop;

import java.util.ArrayList;

public class Basket {
  // Attribute
  private ArrayList<Article> articles = new ArrayList<>(); // Initialisierung mit ArrayList bei Objekterzeugung

  // Methoden
  public void addArticle(Article article) {
    // Alternative: boolean successfulDecrement = article.decrementStock();
    // if(successfulDecrement) { // ... }

    // Nur den Bestand des Artikels um 1 reduzieren und den Artikel zum Warenkorb hinzufügen, wenn der Bestand > 0
    if(article.decrementStock()) {
      this.articles.add(article);
    }
  }

  // Entfernt den als Parameter übergebenen Artikel (Objekt-Referenz) von der this.articles-ArrayList
  public void removeArticle(Article article) {
    this.articles.remove(article);
    // da der Artikel nicht gekauft wurde, ist jetzt wieder eine Einheit mehr frei verfügbar
    article.incrementStock();
  }

  public void empty() {
    this.articles.clear();
  }

  public double getTotalValue() {
    // Statt den totalValue als Attribut eines Basket-Objekts zu definieren, berechnen wir dies dynamisch auf der Basis
    // der aktuell enthaltenen Artikel
    double totalValue = 0.0; // Summe ist natürlich erstmal 0.0 (Dezimalzahl, da der Typ "double" ist)

    // Alternative mit "regulärer" for-Schleife
    /* for(int i = 0; i < this.articles.size(); i++) {
      Article article = this.articles.get(i);
      totalValue += article.getPrice();
    } */

    // für jeden Artikel in this.articles
    for(Article article : this.articles) {
      // Preis für den Artikel erhalten
      // erhöhe totalValue um den Preis des Artikels
      // totalValue = totalValue + article.getPrice();
      totalValue += article.getPrice();
    }

    return totalValue;
  }

  public void listArticles() {
    // Für jeden im Warenkorb enthaltenen Artikel die Details ausgeben (über unsere "Hilfsmethode" getArticleDetails() des Artikelobjekts)
    for(Article article : this.articles) {
      System.out.println(article.getArticleDetails());
    }
  }
}
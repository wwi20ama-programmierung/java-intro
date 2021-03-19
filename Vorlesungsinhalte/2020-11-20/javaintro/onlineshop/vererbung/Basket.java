package javaintro.onlineshop.vererbung;

import java.util.ArrayList;

public class Basket {
    // Der Basket kann alle Artikel der Klasse "Article" und der erbenden (Kind-)Klassen beinhalten (also DownloadArticle und PhysicalArticle)
    private ArrayList<Article> articles = new ArrayList<>();

    public void addArticle(Article article) {
        // boolean successfulDecrement = article.decrementStock();
    /*if(article.decrementStock()) {
      this.articles.add(article);
    }*/
    }

    public void removeArticle(Article article) {
        this.articles.remove(article);

        // das ist nicht mehr generell möglich, da nur ein PhysicalArticle das Attribut "stock" (und damit die beiden Methoden "incrementStock()" und "decrementStock()") besitzt
        //article.incrementStock();
    }

    public void empty() {
        this.articles.clear();
    }

    public double getTotalValue() {
        double totalValue = 0.0;

        // für jeden Artikel in this.articles
        for (Article article : this.articles) {
            // Preis für den Artikel erhalten
            // erhöhe totalValue um den Preis des Artikels
            // totalValue = totalValue + article.getPrice();
            totalValue += article.getPrice();
        }

        return totalValue;
    }

    public void listArticles() {
        for (Article article : this.articles) {
            System.out.println(article.getArticleDetails());
        }
    }
}
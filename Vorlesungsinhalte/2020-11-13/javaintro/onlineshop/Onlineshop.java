package javaintro.onlineshop;

import java.util.ArrayList;

public class Onlineshop {
  // Attribute
  private String name;
  private ArrayList<Article> articles = new ArrayList<>();
  private ArrayList<Customer> customers = new ArrayList<>();

  // Konstruktor
  Onlineshop(String name) {
    this.name = name;
    // Ausgabe: Ein neuer Onlineshop "Testshop" wurde eröffnet
    System.out.println("Ein neuer Onlineshop \"" + this.name + "\" wurde eröffnet!");
    // Oder alternativ über String.format -> %s heißt "wird durch einen String ersetzt"
    // System.out.println(String.format("Ein neuer Onlineshop \"%s\" wurde eröffnet!", this.name));
  }

  // Methoden
  public void addArticle(Article article) {
    this.articles.add(article);
  }

  public void addCustomer(Customer customer) {
    this.customers.add(customer);
  }

  public void listArticles() {
    // Alternative 1: "reguläre" for-Schleife mit Zählervariable i
    /* for(int i = 0; i < this.articles.size(); i++) { // size = 5
      Article article = this.article.get(i);
      article.getArticleDetails();
    } */

    // Alternative 2: "for each"-Loop
    for(Article article : this.articles) { // für jeden article in der ArrayList this.articles ...
      System.out.println(article.getArticleDetails());
    }
  }
}

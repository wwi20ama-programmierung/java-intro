package javaintro.onlineshop.vererbung;

import java.util.ArrayList;

public class Onlineshop {
    private String name;
    // In der ArrayList<Article> können Objektreferenzen auf "Article"- sowie "PhysicalArticle"- und "DownloadArticle"-Objekte gespeichert werden.
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    Onlineshop(String name) {
        this.name = name;
        // Ein neuer Onlineshop "Testshop" wurde eröffnet
        System.out.println("Ein neuer Onlineshop \"" + this.name + "\" wurde eröffnet!");
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void listArticles() {
    /* for(int i = 0; i < this.articles.size(); i++) { // size = 5
      Article article = this.article.get(i);
      article.getArticleDetails();
    } */

        for (Article article : this.articles) {
            System.out.println(article.getArticleDetails());
        }
    }
}

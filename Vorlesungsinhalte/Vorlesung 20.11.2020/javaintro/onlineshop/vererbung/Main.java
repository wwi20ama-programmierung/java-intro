package javaintro.onlineshop.vererbung;

import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    // Ist für unser Beispiel nicht relevant, hatten wir aber im Onlineshop-Beispiel als notwendig erklärt
    Category dummyCategory = new Category("New Category");

    // Wir erzeugen drei Objekte:
    // 1x der Klasse "Article"
    Article normalerArticle = new Article("Normaler Artikel", 20.0, dummyCategory);

    System.out.println(); // Abstandshalter

    // 1x der Klasse "DownloadArticle" (die von "Article" erbt) -> Konstruktor von "DownloadArticle" und von "Article" wird aufgerufen (siehe Konsole)
    DownloadArticle downloadArticle = new DownloadArticle("Downloadartikel", 1.99, 320, dummyCategory);

    System.out.println(); // Abstandshalter

    // 1x der Klasse "PhysicalArticle" (die von "Article" erbt) -> Konstruktor von "PhysicalArticle" und von "Article" wird aufgerufen (siehe Konsole)
    PhysicalArticle physicalArticle = new PhysicalArticle("Physischer Artikel", 55.44, dummyCategory);

    System.out.println(); // Abstandshalter

    // Die ArrayList<Article> kann Objekte der Klasse Article und der Kindklassen (erbenden Klassen) "DownloadArticle" und "PhysicalArticle" speichern
    ArrayList<Article> articleList = new ArrayList<>();
    articleList.add(normalerArticle);
    articleList.add(downloadArticle);
    articleList.add(physicalArticle);

    // Wir sehen in der Konsole nach Ausführen des Codes, dass für jeden Artikel das Resultat der je (Kind-)Klasse überschriebene "getArticleDetails()"-Methode ausgegeben wird
    for(Article article : articleList) {
      System.out.println(article.getArticleDetails());
    }
  }
}
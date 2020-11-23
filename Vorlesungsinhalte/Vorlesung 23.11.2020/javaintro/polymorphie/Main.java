package javaintro.polymorphie;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // Polymorphie ("Vielgestaltigkeit")

        // Dynamische Polymorphie:
        // Zur Laufzeit entscheidet Java, welche Methode aufgerufen werden muss.
        // Obwohl alle Objekte als "BaseArticle"-Referenz in "articles" gespeichert sind, wird die pro (Sub-)Klasse definierte Methode aufgerufen
        ArrayList<BaseArticle> articles = new ArrayList<>();

        articles.add(new BaseArticle("Base Article"));
        articles.add(new DownloadArticle("Download Article.mp3", 320));
        articles.add(new PhysicalArticle("Physical Article", 22));
        articles.add(new SubscriptionArticle("Subscription Article"));

        for (BaseArticle article : articles) {
            // Für jedes Artikel-Objekt die Methode "getDetails()" aufrufen -> unterschiedliche Aufrufe:

            // Ausgabe: "Ich bin ein BaseArticle und heiße Base Article"
            // Ausgabe: "Ich bin ein DownloadArticle mit einer Bitrate von 320 kbit/s und heiße Download Article.mp3"
            // Ausgabe: "Ich bin ein PhysicalArticle mit einem Bestand von 22 und heiße Physical Article";
            // Ausgabe: "Ich bin ein BaseArticle und heiße Subscription Article" -> wurde in Subscription-Article nicht überschrieben und verwendet deshalb die Methode der Elternklasse (BaseArticle)
            System.out.println(article.getDetails());
        }

        System.out.println(); // Abstandshalter

        // Statische Polymorphie:
        // Der Compiler "erkennt" anhand von Methodennamen, Parameteranzahl, Parametertypen und Parameterreihenfolge (NICHT Parameternamen), welche Methode "gemeint" ist.
        DownloadArticle downloadArticle = new DownloadArticle("DownlOad Article", 320);
        System.out.println(downloadArticle.getDetails()); // "DownlOad Article .. 320 kbit/s"

        // Aufruf der Methode "setDetails(String,int)", da String und int übergeben werden
        downloadArticle.setDetails("Download Article", downloadArticle.getBitrate());
        System.out.println(downloadArticle.getDetails()); // "Download Article .. 320 kbit/s"

        // Aufruf der Methode "setDetails(String)", da nur String übergeben wird
        downloadArticle.setDetails("Herunterladbarer Artikel");
        System.out.println(downloadArticle.getDetails()); // "Herunterladbarer Artikel .. 320 kbit/s"
    }
}
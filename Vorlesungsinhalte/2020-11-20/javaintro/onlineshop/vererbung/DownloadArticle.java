package javaintro.onlineshop.vererbung;

// Dies ist eine spezialisierte Form der "Article"-Klasse.
// Durch "extends Article" erbt "DownloadArticle" alle Attribute und Methoden, die nicht als "private" markiert sind, von "Article"
public class DownloadArticle extends Article {
    // Ein "DownloadArticle"-Objekt besitzt das zusätzliche Attribut "bitrate" (z. B. für MP3s)
    private int bitrate = 128;

    // Ein "DownloadArticle"-Objekt wird über einen eigenen Konstruktor erzeugt
    public DownloadArticle(String name, double price, int bitrate, Category category) {
        // Zusätzlich rufen wir über "super()" den Konstruktor des Elternelements (Article) auf und müssen entsprechend die vom Article-Konstruktor geforderten Parameter übergeben ("weiterreichen")
        super(name, price, category);

        this.bitrate = bitrate;
        System.out.println("Neuer Downloadartikel");
    }

    // Wir überschreiben für alle DownloadArticle-Objekte die Methode "getArticleDetails()" und geben in dieser einen leicht veränderten Text (inkl. bitrate) aus
    public String getArticleDetails() {
        // mit super.getArticleDetails() können wir die Methode der Elternklasse (also ein "Article") aufrufen
        return super.getArticleDetails() + " mit einer Bitrate von: " + this.bitrate + " kbit/s"; // z. B. "Toller Song (1.99 €) mit einer Bitrate von: 320 kbit/s"
    }

    // Getter und Setter für die Bitrate
    public int getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }
}

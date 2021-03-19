package javaintro.onlineshop.vererbung;

// Dies ist eine spezialisierte Form der "Article"-Klasse.
// Durch "extends Article" erbt "PhysicalArticle" alle Attribute und Methoden, die nicht als "private" markiert sind, von "Article"
public class PhysicalArticle extends Article {
    // Wir fügen das zusätzliche Attribut "stock" hinzu, dass nur ein "PhysicalArticle"- (und nicht ein "Article")-Objekt besitzt
    private int stock = 0;

    // Ein "PhysicalArticle"-Objekt wird über einen eigenen Konstruktor erzeugt
    public PhysicalArticle(String name, double price, Category category) {
        // Zusätzlich rufen wir über "super()" den Konstruktor des Elternelements (Article) auf und müssen entsprechend die vom Article-Konstruktor geforderten Parameter übergeben ("weiterreichen")
        super(name, price, category);

        System.out.println("Neuer physischer Artikel");
    }

    // Wir überschreiben für alle PhysicalArticle-Objekte die Methode "getArticleDetails()" und geben in dieser einen komplett veränderten Text (inkl. stock) aus.
    public String getArticleDetails() {
        return "Einheiten im Bestand: " + this.stock + ", " + this.name + " (" + this.price + " €)";
    }

    // Hier können wir wieder "incrementStock()" und "decrementStock()" anbieten, da ein PhysicalArticle auch ein Attribut "stock" besitzt
    // = Artikel wurde aus einem Warenkorb entfernt
    public void incrementStock() {
        this.stock++; // this.stock = this.stock + 1;
    }

    // = Artikel wurde in einen Warenkorb hinzugefügt
    public boolean decrementStock() {
        if (this.stock == 0) {
            return false; // Artikel nicht mehr verfügbar
        } else {
            this.stock--; // this.stock = this.stock - 1;
            return true;
        }
    }
}
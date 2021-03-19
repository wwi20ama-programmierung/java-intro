package javaintro.maumau.ki;

public class Karte {
    // Attribute
    private String symbol;
    private String wert; // Wert als String, damit Bube, Dame, König, Ass auch abgebildet werden können

    // Konstruktor
    Karte(String symbol, String wert) {
        this.symbol = symbol;
        this.wert = wert;
    }

    // Methoden
    public String getSymbol() {
        return this.symbol;
    }

    public String getWert() {
        return this.wert;
    }

    public boolean pruefe(Karte andereKarte) {
        // In Python: return k1[0] == k2[0] or k1[1] == k2[1]
        return this.symbol.equals(andereKarte.getSymbol()) || this.wert.equals(andereKarte.getWert()); // Bei Strings zur Sicherheit immer .equals() anstatt == verwenden
    }
}
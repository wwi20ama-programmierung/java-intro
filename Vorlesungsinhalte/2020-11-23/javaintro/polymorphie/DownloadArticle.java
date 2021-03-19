package javaintro.polymorphie;

public class DownloadArticle extends BaseArticle {
    private int bitrate;

    DownloadArticle(String name, int bitrate) {
        super(name);
        this.bitrate = bitrate;
    }

    int getBitrate() {
        return this.bitrate;
    }

    // Nur für DownloadArticle-Objekte verwendbar
    String getDetails() {
        return "Ich bin ein DownloadArticle mit einer Bitrate von " + this.bitrate + " kbit/s und heiße " + this.name;
    }

    public void setDetails(String name) {
        this.name = name;
    }

    public void setDetails(int bitrate) {
        this.bitrate = bitrate;
    }

    public void setDetails(String name, int bitrate) {
        this.name = name;
        this.bitrate = bitrate;
    }

    // Der Rückgabetyp dient NICHT als Unterscheidungsmerkmal
    // -> "method setDetails(java.lang.String,int) is already defined in class javaintro.polymorphie.DownloadArticle"
  /* public String setDetails(String name, int bitrate) {
    this.name = name;
    this.bitrate = bitrate;
    return null;
  }*/
}
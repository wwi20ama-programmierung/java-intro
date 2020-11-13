package javaintro.maumau;

import java.util.ArrayList;
import java.util.Collections;

public class Stapel {
  // Attribute
  private ArrayList<Karte> karten = new ArrayList<>();

  // Methoden
  public void addKarte(Karte karte) {
    this.karten.add(karte);
  }

  public void mischen() {
    // siehe Dokumentation: https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Collections.html#shuffle(java.util.List)
    Collections.shuffle(this.karten);

    // hierüber können wir bei mehrmaligem Ausführen von mischen() prüfen, ob sich jeweils die erste Karte der this.karten-ArrayList ändert = es wurde gemischt
    System.out.println(this.karten.get(0));
  }
}
package javaintro.maumau;

import java.util.ArrayList;
import java.util.Collections;

public class Stapel {
  private ArrayList<Karte> karten = new ArrayList<>();

  public void addKarte(Karte karte) {
    this.karten.add(karte);
    // System.out.println(this.karten.size());
  }

  public void mischen() {
    Collections.shuffle(this.karten);
    // System.out.println(this.karten.get(0));
  }
}
public class Baum {
  private Knoten wurzel;

  public Baum() {
    wurzel = new Knoten();
  }

  // Liefert true, wenn der Baum leer ist.
  public boolean isEmpty() {
    return wurzel.isDummy();
  }

/* Iterative Variante von get */
/*
  // Sucht ein Element im Baum und liefert den engl. String.
  public String get(String de) {
        // Hilfsvariable für aktuellen Knoten, Start bei wurzel.
    Knoten aktuell = wurzel;

    // Suche den Knoten, in dem de steht.
    while (!aktuell.isDummy() && aktuell.de.compareTo(de) != 0) {
      // Wenn de < aktuell.links.de
      if (de.compareTo(aktuell.links.de) < 0)
      {
        aktuell = aktuell.links;
      }
      else
      {
        aktuell = aktuell.rechts;
      }
    }
    return aktuell.en;
  }
*/

/* Rekursive Variante von get */
  public String get(String de) {
    return wurzel.get(de).getEn();
  }

  // Fuegt ein Element zum Baum hinzu.
  public void put(String de, String en) {
    
    // Hilfsvariable für aktuellen Knoten, Start bei wurzel.
    Knoten aktuell = wurzel;

    // Suche den Knoten, in den eingefügt werden muss.
    while (!aktuell.isDummy()) {
      // Wenn de < aktuell.links.de
      if (de.compareTo(aktuell.getLinks().getDe()) < 0)
      {
        aktuell = aktuell.getLinks();
      }
      else
      {
        aktuell = aktuell.getRechts();
      }
    }
    aktuell.insertNew(de, en);
  }

  // Vertauscht die beiden angegebenen Knoten.
  // Anmerkung: Sollte eigentlich private sein,
  // ist zu Testzwecken public.
  // Knoten vertauschen macht die Sortierung
  // ("In-Order-Eigenschaft") kaputt.
  public void swap(Knoten k1, Knoten k2) {
    k1.swap(k2);
  }

  // Gibt alle Elemente des Baumes in In-Order-Reihenfolge aus.
  public void print() {
    wurzel.printTree();
  }

  // Entfernt das Element mit dem angegebenen de-Wert.
  public void remove(String de) {

    // 1. Knoten mit de-Wert suchen.

    // Solange der gefundene Knoten noch kein Blatt ist...
    // - In-Order-Nachfolger suchen.
    // - Vorgänger suchen, falls Nachfolger nicht existiert.
    // - Knoten mit Vorgänger/Nachfolger vertauschen.

    // Wenn der gefundene Knoten ein Blatt ist, zu einem Dummy machen.

  }

}



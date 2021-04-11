public class Knoten {
  
  // Sichtbarkeiten noch nicht festgelegt, dadurch sind die Attribute im Package sichtbar, die Baum-Klasse kann hier schreiben.
  // Das ist unsauber, später sollten wir einen Konstruktor oder Setter haben, die Werte schreiben.
  private String de;
  private String en;
  private Knoten links;
  private Knoten rechts;

  // Konstruktor, erzeugt einen Dummy.
  public Knoten() {
    de = "";
    en = "";
    links = null;
    rechts = null;
  }

  // Getter für de
  public String getDe() {
    return de;
  }

  // Getter für en
  public String getEn() {
    return en;
  }

  // Getter für linkes Kind
  Knoten getLinks() {
    return links;
  }

  // Getter für rechtes Kind
  Knoten getRechts() {
    return rechts;
  }

  // Fügt die Werte de und en ein, falls this ein Dummy ist.
  // Hilfsfunktion, damit de, en, links und rechts private sein können.
  void insertNew(String de, String en) {
    if (!isDummy()) { return; }
    this.de = de;
    this.en = en;
    this.links = new Knoten();
    this.rechts = new Knoten();
  }

  // Vertauscht die Werte von this mit denen von other
  void swap(Knoten other) {
    String temp_de = de;
    de = other.de;
    other.de = temp_de;
    String temp_en = en;
    de = other.en;
    other.en = temp_en;
  }

  // Liefert true, wenn der Knoten ein Dummy ist.
  public boolean isDummy() {
    return links == null && rechts == null;
  }

  // Liefert den Knoten mit dem angegebenen de-Wert.
  // Liefert einen Dummy, falls kein solcher de-Knoten existiert.
  public Knoten get(String de) {
    if (isDummy() || this.de.compareTo(de) == 0) {
      return this;
    }
    if (this.de.compareTo(de) < 0) {
      return links.get(de);
    }
    return rechts.get(de);
  }

  // Gibt den gesamten Baum aus.
  public void printTree() {
    // Zuerst den linken Teilbaum ausgeben,
    // dann die Wurzel ausgeben,
    // dann den rechten Teilbaum ausgeben.
  }


  // Hilfsfunktionen für's Löschen.

  // Liefert true, falls this ein Blatt ist.
  public boolean isLeaf() {
    // TODO
    return false;
  }

  // Macht this zu einem Dummy.
  public void makeDummy() {
    // TODO
  }

  // Liefert den In-Order-Nachfolger, oder null, falls dieser nicht existiert.
  Knoten getSuccessor() {
    // TODO
    return null;
  }

  // Liefert den In-Order-Vorgänger, oder null, falls dieser nicht existiert.
  Knoten getPredecessor() {
    // TODO
    return null;
  }


}
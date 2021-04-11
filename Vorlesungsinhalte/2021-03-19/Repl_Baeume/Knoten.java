public class Knoten {
  
  private String de;
  private String en;
  Knoten links;
  Knoten rechts;

  public Knoten() {
    de = "";
    en = "";
    links = null;
    rechts = null;
  }

  // Liefert true, wenn der Knoten ein Dummy ist.
  public boolean isDummy() {
    return links == null && rechts == null;
  }
}
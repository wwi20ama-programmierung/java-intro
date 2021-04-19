import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class Main {
  public static void main(String[] args) {

    // Beispielliste erzeugen.
    List<Integer> l1 = new ArrayList<>();
    l1.add(3);
    l1.add(6);
    l1.add(2);
    l1.add(9);
    l1.add(4);
    l1.add(25);
    l1.add(17);
    l1.add(42);
    l1.add(38);
    
    // Die Methode forEach() benutzen, um ein Lambda auf jedes
    // Element der Liste anzuwenden.
    // Hier: Ausgabe vom doppelten bzw. der Hälfte des Elements.
    l1.forEach((el) -> {System.out.println(2 * el) ; } );
    l1.forEach((el) -> {System.out.println(el / 2) ; } );

    // Hier: Einfügen der Hälfte jedes Elements in eine zweite Liste.
    List<Integer> l2 = new ArrayList<>();
    l1.forEach((el) -> {l2.add(el / 2) ; } );
    System.out.println(l2);
    /// Aufgabe: Überlegen Sie sich, wie eine explizite Klasse
    /// für dieses Lambda aussehen müsste. Hinweis: Sie müssen
    /// irgendwie l2 in die Klasse bringen.

    // Sortieren einer Liste mit Hilfe von Lambdas:
    l1.sort((x,y) -> { return x - y; });
    l1.sort((x,y) -> { return y - x; });

    // Sortieren einer Liste mit einem explizit definierten
    // Comparator-Objekt. Die obigen Lambdas wurden implizit zu
    // Comparator-Objekten gemacht.
    l1.sort(new SortierKriterium()); // Def. s.u.
    System.out.println(l1);
    /// Aufgabe: Schreiben Sie ein Lambda oder einen Comparator,
    /// mit der eine Liste von Zahlen so sortiert, dass
    /// sie zuerst alle geraden geraden Zahlen in absteigender
    /// Reihenfolge und dann alle ungeraden Zahlen in aufsteigender
    /// Reihenfolge enthält.
  }
}



// Definition des expliziten Comparator-Objekts für's Sortieren (s.o.).
class SortierKriterium implements Comparator<Integer> {
  public int compare(Integer x, Integer y) {
    return y - x;
  }
}
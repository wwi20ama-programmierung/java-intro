import java.util.ArrayList;
import java.util.List;


class Main {
  public static void main(String[] args) {

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

    System.out.println(l1);
    System.out.println(verdoppeln(l1));
    System.out.println(halbieren(l1));
    System.out.println(nur_gerade(l1));
  }

/*
  public static List<Integer> verdoppeln(List<Integer> l) {
    List<Integer> result = new ArrayList<>();

    for (Integer i : l) { result.add(2*i); }
    
    return result;
  }
*/
/*
  // Variante mit expliziter Instanz von Verdoppeln.
  public static List<Integer> verdoppeln(List<Integer> l) {
    return map(new Verdoppeln(), l);
  }
  */
  // Variante mit anonymer Funktion (Lambda)
  public static List<Integer> verdoppeln(List<Integer> l) {
    return map((result, i) -> { result.add(2*i); } , l);
  }

  public static List<Integer> halbieren(List<Integer> l) {
    return map(new Halbieren(), l);
  }
  
  public static List<Integer> nur_gerade(List<Integer> l) {
    return map(new NurGerade(), l);
  }

  public static List<Integer> map(Operation op, List<Integer> l) {
    List<Integer> result = new ArrayList<>();
    for (Integer i : l) { op.evaluate(result, i); }
    return result;
  }
}


interface Operation {
  public void evaluate(List<Integer> result, Integer i);
}

/*
class Verdoppeln implements Operation {
  public void evaluate(List<Integer> result, Integer i) {
    result.add(2*i);
  }
}
*/

class Halbieren implements Operation {
  public void evaluate(List<Integer> result, Integer i) {
    result.add(i/2);
  }
}

class NurGerade implements Operation {
  public void evaluate(List<Integer> result, Integer i) {
    if (i % 2 == 0) { result.add(i); }
  }
}




/** Aufgabe:
 Entsprechungen für die folgenden List-Comprehensions als Funktionen schreiben:

 l1 = [3,6,2,9,4,25,17,42,38]

# List Comprehension erzeugt eine neue Liste mit l1 als Vorlage:
l2 = [2*i for i in l1]
l3 = [i / 2 for i in l1]
l4 = [i // 2 for i in l1]

h = [5,2,17,25,33]
l5 = [i for i in l1 if i in h]
l6 = [i for i in l1 if i % 2 == 0]

**/








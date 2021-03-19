import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.ArrayList;

enum Sprache {
  DE, EN, FR
}

class Main {
  public static void main(String[] args) {

//    Map<String, String> m1 = new HashMap<>();
    Map<String, String> m1 = new TreeMap<>();
    m1.put("Lampe", "lamp");
    m1.put("Ball", "ball");
    m1.put("Auto", "car");

    System.out.println(m1);
    System.out.println(m1.get("Auto"));

    Map<String, ArrayList<String>> m2 = new HashMap<>();
    m2.put("Lampe", new ArrayList<String>());
    m2.get("Lampe").add("lamp");
    m2.get("Lampe").add("bulb");
    m2.get("Lampe").add("light bulb");

    System.out.println(m2);
    System.out.println(m2.get("Lampe"));
    System.out.println(m2.get("Lampe").get(1));

    Map<String, Map<Sprache, String>> m3 = new HashMap<>();
    m3.put("Haus", new HashMap<>());
    m3.get("Haus").put(Sprache.EN, "house");
    m3.get("Haus").put(Sprache.FR, "maison");
    
    System.out.println(m3);
    System.out.println(m3.get("Haus").get(Sprache.FR));
  }
}
class Main {
  public static void main(String[] args) {
    Baum b1 = new Baum();
    System.out.println(b1.isEmpty());
    
    b1.put("Haus", "house");
    System.out.println(b1.isEmpty());

    System.out.println(b1.get("Haus")); // Soll "house" auf die Konsole schreiben.
    System.out.println(b1.get("abc"));  // Soll "" auf die Konsole schreiben.

  }
}
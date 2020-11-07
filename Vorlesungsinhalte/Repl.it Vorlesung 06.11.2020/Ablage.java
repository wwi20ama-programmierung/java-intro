 /*
    // Deklarieren und Initialisierung auf einmal
    String test = "Hello";
    System.out.print(test + "\n");
    test = "World";
    System.out.print(test);
    // sysout

    int eineZahl = 6;
    float eineFliesskommazahl = 6.1f;
    double einDouble = 1.2;
    char einBuchstabe = 'A';
    byte einByte = 100;

    System.out.println(eineZahl);
    // eineZahl = "6";
    System.out.println(eineZahl);

    int[] arrayAnIntegern = new int[6];
    int[] direktInitialisiertesArrayAnIntegern = {1, 4, 6, 8};
    int[][][] komplexesArrayAnIntegern = new int[4][5][6];

    // arrayAnIntegern[7] = 7;
    ArrayList<String> dynamischesArray = new ArrayList<>();
    dynamischesArray.add("Hello");
    dynamischesArray.add("World");

    for(String element : dynamischesArray) {

    }

    for(int i = 0; i < dynamischesArray.size(); i++) {
      System.out.println(dynamischesArray.get(i));
    }

    // for(i in range(0, len(direktInitialisiertesArrayAnIntegern)))
    for(int i = 0; i < direktInitialisiertesArrayAnIntegern.length; i++) {
      System.out.println(direktInitialisiertesArrayAnIntegern[i]);
    }

    // AUFGABE
    // Alle Argumente (args) an der Konsole ausgeben, die der Benutzer beim Aufruf des Programms mitgibt (selbst wenn keine mitgegeben werden).
    // Hinweis:
    // javac Main.java (-> Kompilieren)
    // java Main arg1 arg2 arg3 ... (-> Ausführen)
*/

 /* if(args.length != 0) {
        for(int i = 0; i<args.length;i++)
        {
          System.out.println(args[i]);
        }
  } else {
        System.out.println("Es gibt keine Argumente(args)");
      }*/

      /*String string1 = null; // Referenz: 1
      String string2 = ""; // Referenz: 2
      String string3 = string1;
      int zahl = 3;
      int neueZahl = zahl;

      // string1 == string2
      if(string1 != null) {
        System.out.println("Stimmt");
      } else {
        System.out.println("Stimmt nicht");
      }
    }*/

    /*
    def primzahltest(x):
  if x <= 1:
    return False # Falls die Zahl 1 oder kleiner ist, brauchen wir nicht weiter testen, es kann keine Primzahl sein
  else:
    for i in range(2, x): # ansonsten probieren wir, die Zahl durch alle Zahlen von 2 bis zu 'n - 1' zu teilen und schauen, ob der Rest 0 ergibt (bedeutet 'ist teilbar')
      if x % i == 0:
        return False
  return True
  */

 /*   int zuPruefendeZahl = 6;
    if(zuPruefendeZahl <= 1) {
      System.out.println("Zahl ist <= 1");
      return;
    } else {
      for(int i = 2; i < zuPruefendeZahl; i++) { // range(2,x) = [2, 3, ..., x - 1]
        if(zuPruefendeZahl % i == 0) {
          System.out.println("Keine Primzahl, da teilbar durch " + i);
          return;
        }
      }

      System.out.println(zuPruefendeZahl + " ist eine Primzahl");
    }  
  }*/
# Objektorientierte Programmierung (OOP)
## Bisherige Programmstruktur
In den Python-Vorlesungen haben wir pro "Eigenschaft" bzw. Attribut eines Spielers eine eigene Variable angelegt.
Dadurch, dass wir beispielsweise ein Spiel bereits im Vorhinein auf zwei Spieler eingeschränkt haben, wussten wir, welche Variablen wir wann evaluieren müssen.

In Java könnte das für zwei Spieler, die einen Namen (`name`) und eine Punktzahl (`score`) haben, so aussehen:
```java
String player1_name = "Max";
String player2_name = "Moritz";

int player1_score = 0;
int player2_score = 0;
```

Möchten wir nun am Ende eines Spieldurchlaufs den Gewinner herausfinden und entsprechend an der Konsole ausgeben, könnte das so aussehen:
```java
if(player1_score > player2_score) {
    System.out.println(player1_name + " hat gewonnen!");
} else if(player1_score == player2_score) {
    System.out.println("Beide Spieler haben gewonnen!");
} else {
  System.out.println(player2_name + " hat gewonnen!");
}
```
Der Code funktioniert natürlich und tut auch was er soll, allerdings ist er nicht erweiterbar und sehr fehleranfällig.
Der Entwickelnde muss z. B. immer aufpassen, dass bei der richtigen `score` auch der richtige `name` ausgegeben wird.
Zudem ist dieser Aufbau nicht dynamisch erweiterbar.
Ein dritter und vierter Spieler können als weitere Variablen hinzugefügt werden, aber wie sieht es bei einer vorher nicht genau definierten Anzahl an Spielern aus?
 
Eine Alternative wäre die "Zusammenfassung" von den Eigenschaften in Arrays (`ArrayList`), in diesem Beispiel in `player_names` und `player_scores`.
```java
String[] player_names = {"Max", "Moritz"};
int[] player_scores = {0, 0};
```
Allerdings benötigen wir auch hier eine Konvention, beispielsweise über den Array-Index, um die verschiedenen Attribute für einen `Spieler` herauszufinden.

Viel kompakter und damit strukturierter, weniger fehleranfällig und erweiterbarer wäre es, wenn wir definieren können, welche Attribute (und Methoden) ein Spieler _generell_ unterstützt.
Diese "Vorlage" können wir dann nutzen, um beliebig viele Spieler mit diesen Attributen und Methoden, allerdings anderen Attributswerten, zu erstellen.

## Konzept
Das Prinzip, in einer "Vorlage" oder "Blaupause" zu definieren, welche Attribute und Methoden eine Entität wie ein `Spieler` besitzt, existiert und nennt sich **Objektorientierung**.
Alles lässt sich als ein Objekt modellieren, unabhängig davon, ob es ein physisches Objekt (z. B. ein Fahrzeug) oder eine konzeptionelle Entität (z. B. eine Regel oder ein Kurs) ist, da sich für jedes Objekt die Attribute, Methoden und Beziehungen zu anderen Objekten definieren lassen, die zum "Funktionieren" bzw. Abbilden des Objekts notwendig sind.

Wichtig ist: Es gibt immer verschiedene Wege zum Ziel und deshalb nicht "die" richtige Modellierung zur Realisierung eines Programms bzw. zum Lösen eines Problems.
Trotzdem macht es Sinn, sich an akzeptierte Vorgehensweisen, Konventionen und Visualisierungen zu halten, um die Verständlichkeit und Übersichtlichkeit zu erhöhen sowie die Interoperabilität mit anderer Software und Programmierenden zu erhalten.

Zudem kann sich der Detaillierungs- und damit der Modellierungsgrad je nach Anwendung und Zeitpunkt ändern.
Reicht es beispielsweise vorerst aus, ein `Fahrzeug`-Objekt mit den zwei Integer-Attributen `farbe` (als hexadezimalen Wert) und `anzahlRaeder` zu versehen, müssen für einen anderen Anwendungsfall z. B. jedes Rad separat erfasst werden, um den jeweiligen Reifendruck zu speichern.
Dazu würde sich dann die Modellierung von `anzahlRaeder` als `Array` an `Rad`-Objekten anbieten.

### Vorteile


## Visualisierung
Für die Visualisierung von Klassen mit ihren Attributen, Methoden und Beziehungen wird häufig die Unified Modeling Language (UML) für die Erstellung von Klassendiagrammen verwendet.
Jede Klasse ist durch einen "Kasten" repräsentiert, der je eine Sektion für Attribute und Methoden enthält. Dabei werden auch die jeweiligen Typen angegeben, 
Diese Visualisierung ist unabhängig von einer konkreten Programmiersprache, erleichtert aber trotzdem die Kommunikation mit anderen Programmierenden sowie Nicht-Programmierenden.

![Beispiel für ein Klassendiagramm](includes/UMLKlassendiagramm.png)

Für ein (einfaches) Rennspiel könnte das Beispiel so aussehen:

![Beispiel für ein Klassendiagramm](includes/Spieler und Fahrzeuge.png)

Durch das `+` bzw. `-` vor den Attributen und Methoden lässt sich zusätzlich die Sichtbarkeit festlegen. Mehr dazu im Abschnitt [Modifikatoren](#modifikatoren).

## Klassen in Java
### `class`

In der Regel wird pro Klasse in Java eine neue `.java`-Datei angelegt, die den gleichen Namen wie die in ihr enthaltene Klasse besitzt.
Zudem beginnen Klassen per Konvention mit einem Großbuchstaben, wohingegen Variablen mit einem Kleinbuchstaben beginnen.
Wie in allen Programmiersprachen sollte man sprechende Namen für alle Entitäten verwenden.
Man verwendet englische Begriffe, um Umlaute und anderen Sonderzeichen zu vermeiden sowie die Verständlichkeit für Mitentwickelnde anderer Nationalitäten zu ermöglichen.
Damit auch längere Variablennamen lesbar bleiben, greift man häufig auf die sogenannte `lowerCamelCase`-Schreibweise zurück: 

```java
class VeryLongYetReadablelassName {
    // Attribute und Methoden
}
```

```java
VeryLongYetReadablelassName variableWithAVeryLongYetReadableClassName = new VeryLongYetReadablelassName();
```

### Attribute
Ein Attribut beschreibt eine Eigenschaft eines Objekts. Sie werden in der "Vorlage", also in der Klasse, definiert und können für jedes Objekt einen anderen Wert besitzen.
Ein Objekt ist somit eine "Gruppierung" an Attributswerten.

```java
// Definition der Klasse "Player"
class Player {
    String name; // noch nicht initialisiert
    int score = 0; // mit 0 initialisiert
}
```

Wir haben also eine Klasse `Player` definiert, die zwei Attribute besitzt: `name` vom Typ `String` und `score´ vom Typ `int`` .
Jedes Objekt, das nun über die `new`-Anweisung aus dieser Klasse erzeugt wird, besitzt nun seine eigenen Werte für `name` und `score`.

```java
// Verwendung der Klasse Player
Player playerOne = new Player();
playerOne.name = "Max"; // setzt das Attribut "name" des Objekts "playerOne" vom Typ/der Klasse "Player" auf den Wert "Max"
playerOne.score += 50; // erhöht die "score" von "playerOne" um 50

System.out.println(playerOne.name + " : " + playerOne.score); // Ausgabe: "Max : 50"
```

Dies kann man einfach ausprobieren, indem man ein weiteres Objekt der Klasse `Player` erzeugt:
```java
// Verwendung der Klasse Player
Player playerTwo = new Player();
playerTwo.name = "Moritz";
playerTwo.score = 100;

System.out.println(playerTwo.name + " : " + playerTwo.score); // Ausgabe: "Moritz : 100"
``` 

### Methoden
Natürlich besitzt ein Objekt nicht nur Eigenschaften, sondern kann auch Aktionen ausführen.
Dafür verwendet man Methoden, also Funktionen für ein Objekt.
Diese werden ebenfalls in der Klasse definiert und können pro Objekt aufgerufen werden:

```java
// Definition der Klasse "Player"
class Player {
    String name; // noch nicht initialisiert

    void displayName() {
        System.out.println("Hello " + this.name + "!");
    }
}
```

```java
// Verwendung der Klasse Player
Player playerOne = new Player();
playerOne.name = "Max";

playerOne.displayName(); // Ausgabe: "Hello Max!"
```

```java
// Verwendung der Klasse Player
Player playerTwo = new Player();
playerTwo.name = "Moritz";

playerTwo.displayName(); // Ausgabe: "Hello Moritz!"
```

Für jedes Objekt wird jeweils der Wert des Objektattributs `name` ausgegeben, d.h `playerOne` kann die Attribute von `playerTwo` nicht ohne Weiteres sehen oder modifizieren.

### `this`-Referenz
In der vorherigen Sektion [Methoden](#methoden) haben wir das Schlüsselwort `this` verwendet, um auf den Attributwert des jeweiligen Objekts, also `playerOne` bzw. `playerTwo` zuzugreifen.
`this` zeigt immer auf das Objekt selbst, über das der Aufruf der Methode stattfindet.
Daraus folgt, dass bei einem Aufruf von `playerOne.displayName()` das `this` im Methodenrumpf niemals auf das Objekt `playerTwo` verweisen kann.

Java "versteht" auch ohne `this` häufig, dass z. B. mit `name` in der Methode `displayName` das Attribut `name` gemeint ist.
Trotzdem ist es einfacher verständlich, wenn `this` bei Attributen und Methodenaufrufen im eigenen Objekt verwendet wird, da dadurch Missverständnisse vermieden werden können, wie folgendes Beispiel zeigt:

```java
public class Player {
    String name;
    
    void setName(String name) {
        name = name;
    }
}
```

Welche Variable ist hier mit `name` gemeint, der Parameter der Methode `setName` oder das Attribut `name`?
Beide `name`s verweisen hier auf den Parameter der Methode, weshalb sich der Wert des Attributs `name` nicht ändert.
 
Dies ist allerdings nicht ohne weitere Analysen ersichtlich, deshalb sollte man solche Anweisungen wie folgt schreiben:

```java
public class Player {
    String name;
    
    void setName(String name) {
        this.name = name;
    }
}
``` 

Aus dieser Anweisung wird sofort klar, dass im Attribut `name` des Objekts ( `this`), auf dem `setName` aufgerufen wird, der Wert des Parameters `name` gespeichert werden soll.

### Vergleiche von Objekten
Hinweis: Für den Spezialfall `String`-Objekte siehe [Exkurs: Strings vs. Basistypen](../Exkurse/Strings%20vs.%20Basistypen.md).

Objekte sind in Java immer Referenzen auf Speicheradressen.
Dies lässt sich visualisieren, wenn man ein Objekt einer Klasse über `System.out.println()` an der Konsole ausgeben lässt.
Man erhält dann eine ähliche Ausgabe wie `Klassenname@6ff3c5b5` anstatt einem Wert. 
Aus diesem Grund lassen sie sich nur bedingt mit dem bekannten Gleichheitsoperator `==` vergleichen.

Für viele Klassen, die bereits mit Java ausgeliefert werden, ist eine `toString()`-Methode definiert, die eine String-Repräsentation des Objekts erstellt, die entsprechend an der Konsole ausgegeben wird.
Bei diesen wird evtl. nicht die Referenz, sondern eine Zeichenkette an der Konsole ausgegeben.

```java
// Definition der Klasse "Person"
class Person {
    String name;
}
```

Im folgenden Beispiel besitzen beide Objekte der Klasse `Person` den gleichen Wert für das Attribut `name`, allerdings handelt es sich um zwei verschiedene Objekte.
Die Variable `person1` besitzt eine andere Referenz als `person2`. 

```java
// Verwendung der Klasse "Person"
Person person1 = new Person();
person.name = "Max";

Person person2 = new Person();
person.name = "Max";
```

Vergleich man die beiden Objekte auf Gleichheit (`person1 == person2`), so ist das Resultat `false`, da die damit verglichenen Speicheradressen unterschiedlich sind.

![Java Stack und Heap](includes/Objektreferenzen.png)

Anders verhält es sich, wenn man `person2` den "Wert" von `person2` zuweist.
In diesem Fall verweisen beide Referenzen auf den gleichen Speicherbereich, in dem ein Objekt der Klasse `Person` mit dem Wert `"Max"` für das Attribut `name` abgelegt ist. 
Folglich ergibt die Prüfung auf Gleichheit (`person1 == person2`) `true`.
```java
// Verwendung der Klasse "Person"
Person person1 = new Person();
person.name = "Max";

Person person2 = person1;
```

Detailliertere Informationen zum Thema Objektreferenzierung sowie Stack und Heap finden Sie bei [Baeldung](https://www.baeldung.com/java-stack-heap).

## Datenkapselung (Encapsulation)
### Modifikatoren
### Getter und Setter
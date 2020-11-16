# Objektorientierte Programmierung (OOP)
## Inhaltsverzeichnis
- [Bisherige Programmstruktur](#bisherige-programmstruktur)
- [Konzept](#konzept)
- [Visualisierung](#visualisierung)
- [Klassen in Java](#klassen-in-java)
    - [`class`](#class)
    - [Attribute](#attribute)
    - [Methoden](#methoden)
    - [`this`-Referenz](#this-referenz)
    - [Vergleiche von Objekten](#vergleiche-von-objekten)
- [Datenkapselung (Encapsulation)](#datenkapselung-encapsulation)
    - [Zugriffsmodifikatoren ](#zugriffsmodifikatoren)
    - [Getter und Setter](#getter-und-setter)

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
Das Prinzip, in einer "Vorlage" oder "Blaupause" zu definieren, welche Attribute und Methoden eine Entität wie ein `Spieler` besitzt, existiert und nennt sich **Objektorientierung** bzw. Objektorientierte Programmierung und wird häufig als Gegensatz zur (zuvor erläuterten) prozeduralen Programmierung gesehen.
Alles lässt sich als ein Objekt modellieren, unabhängig davon, ob es ein physisches Objekt (z. B. ein Fahrzeug) oder eine konzeptionelle Entität (z. B. eine Regel oder ein Kurs) ist, da sich für jedes Objekt die Attribute, Methoden und Beziehungen zu anderen Objekten definieren lassen, die zum "Funktionieren" bzw. Abbilden des Objekts notwendig sind.

Wichtig ist: Es gibt immer verschiedene Wege zum Ziel und deshalb nicht "die" richtige Modellierung zur Realisierung eines Programms bzw. zum Lösen eines Problems.
Trotzdem macht es Sinn, sich an akzeptierte Vorgehensweisen, Konventionen und Visualisierungen zu halten, um die Verständlichkeit und Übersichtlichkeit zu erhöhen sowie die Interoperabilität mit anderer Software und Programmierenden zu erhalten.

Zudem kann sich der Detaillierungs- und damit der Modellierungsgrad je nach Anwendung und Zeitpunkt ändern.
Reicht es beispielsweise vorerst aus, ein `Fahrzeug`-Objekt mit den zwei Integer-Attributen `farbe` (als hexadezimalen Wert) und `anzahlRaeder` zu versehen, müssen für einen anderen Anwendungsfall z. B. jedes Rad separat erfasst werden, um den jeweiligen Reifendruck zu speichern.
Dazu würde sich dann die Modellierung von `anzahlRaeder` als `Array` an `Rad`-Objekten anbieten.

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
Man erhält dann eine ähnliche Ausgabe wie `Klassenname@6ff3c5b5` anstatt einem Wert. 
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
In der Programmierung ist es üblich, dass Code in "Modulen" organisiert wird, um die Wiederverwendung zu erhöhen.
Ist beispielsweise ein Modul, das aus unterschiedlichen Klassen besteht, für eine Datenbankverbindung entwickelt worden, kann man dieses einfach einbinden und verwenden, anstatt alle Funktionen neu zu programmieren.
Dies erhöht die Entwicklungsgeschwindigkeit und die Sicherheit, da sich Experten auf ihre Module und Funktionalitäten konzentrieren können.
Gleichzeitig verringert es die Fehleranfälligkeit, v.a. durch Reduzierung der Komplexität des Programms.
 
Häufig ist es nicht erwünscht, dass andere Entwickelnde beispielsweise die Attribute eines Objekts selbst setzen.
Zusätzlich zur Kontrolle über das Setzen von Attributwerten kann man eine verständliche Schnittstelle über Methoden definieren, die von anderen Klassen bzw. Modulen verwendet werden muss.

Beispielsweise haben Sie eine Klasse `Product` implementiert, die nun in einer Shop-Applikation verwendet werden soll.
Das Produkt hat einen Namen und einen Preis, der den Nettopreis des Produkts speichert.

```java
class Product {
    String name;
    double price;
}
``` 

Eine andere Person, die Ihre Klasse `Product` für die Entwicklung der Shop-Applikation verwenden möchte, geht nun mangels Informationen davon aus, dass das Attribut `price` den Bruttopreis beinhaltet und implementiert dies entsprechend.

```java
Product product = new Product();
product.name = "Smartphone";
product.price = 119.0; // statt einem Nettopreis von 100.00 €
```

Folglich würden alle weiteren Berechnungen, die das Attribut `price` verwenden, mit dem falschen Preis rechnen.
Dies lässt sich verhindern, indem man sogenannte Zugriffsmodifikatoren verwendet.

### Zugriffsmodifikatoren
Im `Product`-Beispiel können wir Java mitteilen, dass wir die beiden Attribute `name` und `price` vor anderen Klassen "verstecken" möchten.
Dafür verwenden wir den Modifikator `private`, der vor der Angabe des Typs eines Attributs (oder auch einer Methode oder Klasse) geschrieben wird.

```java
class Product {
    private String name;
    private double price;
}
```

Die andere Person, die unsere Klasse nun zur Erzeugung neuer `Product`-Objekte verwendet, bekommt beim Setzen der Attribute eine Fehlermeldung angezeigt, da diese nicht von außen sichtbar und modifizierbar sind, beispielsweise:

```sh
Main.java:8: error: price has private access in Product
product.price = 100.0;
       ^
1 error
compiler exit status 1
```

Es gibt dazu auch weitere Zugriffsmodifikatoren, die zur Einschränkung der Sichtbarkeit verwendet werden können:

| Zugriffsart | Java-Schlüsselwort | Notation in UML-Klassendiagrammen | Beschreibung | Beispiel |
| :--- | :--- | :--- | :--- | :--- |
| Öffentlich | `public` | `+` | Für alle Objekte im Programm zugreifbar | `public String name;` |
| Package | `<leer>` | `~` | Standardsichtbarkeit in Java (bei keinen weiteren Angaben) | `String name;` | 
| Protected | `protected` | `#` | Für Objekte der eigenen Klasse und von Subklassen (siehe Vererbung) zugreifbar | `protected String name;` |
| Privat | `private` | `-` | Nur für Objekte der eigenen Klasse zugreifbar | `private String name;` |

Dadurch können Sie als Entwickelnder der Klasse `Product` festlegen, wie die Attribute `name` und `price` verändert bzw. ausgelesen werden dürfen.

Dafür verwendet man sogenannte Zugriffs- (`Getter`) und Änderungsmethoden (`Setter`), die Attributwerte zurückgeben (`get`) oder setzen (`set`).
Diese definieren nach "außen", d.h. für andere Klassen oder Pakete, welche Attribute wie ausgelesen oder geändert werden können.
Dadurch wird die tatsächliche Implementierung der Methoden bzw. der "innere Aufbau" der Klasse versteckt.
Solange folglich die Methodensignaturen (Rückgabetyp, Name, Parameter) gleich bleiben, lässt sich die Klasse weiterhin nutzen, auch wenn sich die Implementierung der Attribute und Methoden geändert hat.  

### Getter
Über einen Getter kann man bestimmen, wie ein Attribut des Objekts zurückgegeben werden soll.
Im Falle des Products kann es beispielweise Sinn machen, je eine Methode für Brutto- und Nettopreis anzubieten.
Da der Getter auch außerhalb der Klasse verwendet werden soll, muss er die Sichtbarkeit `package` oder `public` besitzen.

```java
public class Product {
    private String name;
    private double price;

    public double getNetPrice() {
        return this.price;
    }
    
    public double getGrossPrice() {
        return this.price * 1.19;
    }
}
```

Durch dieses Konzept lassen sich auch sprechende Namen für die Methoden verwenden, die dem Verwendenden beim Verständnis der "fremden" Entwicklungen helfen.

Als weiteres Beispiel dient eine Klasse `Customer`, die den vollständigen Namen zurückgeben soll, obwohl Vor- und Nachname separat über den Konstruktor gesetzt (und gespeichert) werden müssen.
```java
public class Customer {
    private String firstname;
    private String lastname;
    
    // Konstruktor
    public Product(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Getter für den vollständigen Namen
    public String getFullName() {
        return this.firstname + " " + this.lastname;
    }
}
```

### Setter
Analog zum Getter ermöglicht der Setter beispielsweise die Validierung der Eingabe, bevor die als Parameter übergebenen Werte tatsächlich einen Attributwert überschreibt.
Möchte man verhindern, dass z. B. das Attribut `name` eines Objekts der `Product`-Klasse mit einem leeren String versehen wird, kann man dies über einen Setter abfangen:

```java
public class Product {
    private String name;
    private double price;

    public void setName(String name) {
        if(name.equals("")) {
            System.out.println("Ein leerer Produktname ist nicht erlaubt. Der Wert wurde nicht gespeichert.");
        } else {
            this.name = name;
        }
    }
}
``` 

Zusätzlich muss beachtet werden, dass bei strikter Befolgung des Prinzips der Datenkapselung (fast) alle Attribute `private` oder `protected`, also für andere Klassen nicht sichtbar sind.
Daher muss für jedes Attribut, dass auslesbar bzw. modifizierbar sein soll, ein Getter bzw. Setter definiert werden.
Als Namenskonvention verwendet man die beiden Begriffe `get` und `set` und hängt in der bekannten `lowerCamelCase`-Schreibweise den Attributnamen an, z. B. `getName` oder `setPrice`. 

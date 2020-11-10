# Aufgabe: Onlineshop
## Anforderungen
Der Onlineshop bietet Artikel aus den unterschiedlichsten Kategorien an.
Ein Kunde kann sich mit seinem vollständigen Namen und seiner E-Mailadresse registrieren und anschließend Waren einkaufen.
Jeder Kunde, der für den Onlineshop registriert ist, kann auch dort einkaufen. 

Der Kunde kann sich das gesamte Sortiment des Onlineshops anzeigen lassen.

Während des Einkaufs legt der Kunde beliebig viele Artikel in seinen Warenkorb ab oder entfernt sie wieder daraus.
Er kann auch den gesamten Warenkorb leeren.
Jeder Artikel ist nur in einer begrenzten Anzahl verfügbar.
Beim Besuch des Warenkorbs wird dem Kunde der Gesamtwert der darin enthaltenen Artikel angezeigt.

Beim Bezahlen im Warenkorb wird der "ausstehende Rechnungsbetrag" des Kunden um den Wert des Warenkorbs erhöht.

## Hinweise
- Die Verwendung des Onlineshops kann in der `main`-Methode einer `Main`-Klasse "simuliert" werden, indem nacheinander die entsprechenden Objekte erstellt und die Methoden aufgerufen werden (Ausnahme siehe [Fortgeschrittene Erweiterung](#fortgeschrittene-erweiterung)).
- Es müssen nicht alle Anforderungen (z. B. Warenbestand) auf einmal erfüllt werden.
Vorerst können auch erst einmal nur die entsprechenden Attribute deklariert werden.
- Verwenden Sie für Preisangaben die Datentypen `float` oder `double`.
- Für die Umsetzung empfiehlt sich die Strukturierung des Onlineshops in (mindestens) vier Klassen.

## Fortgeschrittene Erweiterung
Ergänzen Sie das Projekt mit einer Steuermöglichkeit über die Konsole.
Der Benutzende kann in einem (Text-)Menü auswählen, ob er dem Warenkorb Artikel hinzufügen, Artikel entfernen, bezahlen oder beenden möchte.
Es bietet sich an, die Steuerungslogik in (mindestens) eine weitere Klasse zu verlagern.

Beispiel:
```
Herzlich Willkommen im Onlineshop!

Folgende Artikel finden Sie momentan in unserem Sortiment:
1. Laptop (575.00 €)
2. Smartphone (422.90 €)
3. Ladegerät für Smartphone (25.00 €)
4. Laptoptasche Stoff (49.99 €)

Was möchten Sie tun?
Geben Sie "k" für "kaufen", "w" für "Warenkorb" oder "e" für "beenden" ein.
>> k

Geben Sie die Artikelnummer (1. - 4.) oder "a" zum Abbrechen ein:
>> 1

Sie haben Ihrem Warenkorb den Artikel "Laptop" für 575.00 € hinzugefügt.
Geben Sie "k" für "kaufen", "w" für "Warenkorb" oder "b" für "beenden" ein.
>> w
 
In Ihrem Warenkorb befinden sich 1 Artikel im Gesamtwert von 575.00 €.
Geben Sie "z" für "zurück", "l" für "leeren", b" für "bezahlen" oder "e" für "beenden" ein.
>> b

Der Betrag in Höhe von 575.00 € wird von Ihrem Bankkonto abgebucht.
Geben Sie "k" für "kaufen" oder "e" für "beenden" ein.
>> e

Vielen Dank für Ihren Einkauf im Onlineshop! Bis zum nächsten Mal!
```

Über ein Objekt der Klasse [`Scanner`](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Scanner.html) lassen sich Benutzereingaben einlesen.
Beispielsweise liest die Methode `.next()` die Benutzereingabe als `String` ein, während `nextInt()` die Eingabe (falls möglich) als `int` konvertiert.

**Beispiel:**
```java
Scanner consoleInput = new Scanner(System.in); // System.in = von Konsole einlesen
System.out.println("Was möchten Sie tun?");
String eingabeString = consoleInput.next();
int eingabeInt = consoleInput.nextInt();
```

## Tipps zum Vorgehen
1. Beginnen Sie mit der Visualisierung der Problemstellung, z. B. indem Sie die einzelnen "Komponenten" des Onlineshops als Liste aufschreiben.
2. Überlegen Sie sich, aus welchen Objekte (Klassen) der Onlineshop besteht, welche Eigenschaften und Funktionen diese haben und wie sie untereinander in Beziehung stehen.
3. Übertragen Sie Ihre "Komponenten" in eine strukturierte Visualisierungsart, bestenfalls in ein UML-Klassendiagramm (z. B. mit [draw.io](https://draw.io)).
4. Erweitern Sie Schritt für Schritt das Klassendiagramm mit Datentypen, Rückgabetypen und Sichtbarkeiten.
5. Fangen Sie mit einer kompakten Klasse an, die erst einmal nicht von anderen Klassen abhängig ist.
6. Schreiben Sie sich die benötigten Schritte in einer Methode erst einmal als Text in Kommentaren hin und übersetzen Sie diesen erst später in Code.
7. Schreiben Sie zuerst die Methodensignaturen (Sichtbarkeit, Rückgabetyp, Methodenname, erwartete Parameter) und ergänzen Sie dann sukzessive den Methodenrumpf. 
8. Überlegen Sie sich, welche Attributwerte zulässig sind und welche nicht und weisen Sie den Benutzer auf Eingabefehler etc. hin.
9. Sollten Sie an einer Stelle nicht weiterkommen, geben Sie beispielsweise einen festen Wert zurück, sodass Sie an anderer Stelle weiterarbeiten können.  
9. Fragen Sie, falls etwas unklar ist oder nicht funktionieren sollte. :smile:

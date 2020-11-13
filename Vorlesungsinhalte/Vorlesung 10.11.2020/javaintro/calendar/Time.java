package javaintro.calendar;

class Time {
    // hier wählen wir "int" als Datentyp und lassen dabei die führenden Nullen (z.B. 2:2 statt 02:02) außer Acht
    private int hours;
    private int minutes;

    // Mit "final" definieren wir Konstanten, d.h. deren Werte dürfen sich nach erstmaliger Initialisierung nicht mehr ändern
    // Dadurch verhindern wir Tipp- und Copy- und Paste-Fehler und können zentral an einer Stelle den "echten" Wert pflegen.
    // Objekt-Referenzen die in "final"-Variablen gespeichert sind, können allerdings weiterhin verwendet und "modifiziert" werden,
    // solange sich die Referenz (die tatsächlich in der Variable gespeicher ist) nicht ändert.
    private final static String AM = "a. m."; // AM, am, ante meridiem
    private final static String PM = "p. m."; // PM, pm, post meridiem

    public Time(int hours, int minutes) {
        // damit 24 Uhr wieder zu 0 Uhr wird:
        this.hours = hours % 24;
        this.minutes = minutes;
    }

    String getIn24hFormat() {
        // erwartetes Format: // 2:34
        return this.hours + ":" + this.minutes;
    }

    String getIn12hFormat() {
        // erwartetes Format: 12:34 a.m. (siehe z. B. https://de.wikipedia.org/wiki/2-mal-12-Stunden-Z%C3%A4hlung)
        // 00:00 -> 12:00 a. m.
        // 01:00 - 11:59 ->  a. m.
        // 12:00 - 12:59 -> 12:00 p. m.
        // 13:00 - 23:59 -> p. m.

        String period = ""; // könnte auch "Suffix" heißen, beinhaltet "a. m." oder "p. m."
        // Wir benötigen eine lokale Variable, da das Überschreiben von this.hours nachfolgende Bearbeitungsschritte mit dem Objekt beeinflussen würde.
        // Setzen wir z. B. this.hours bei 0 auf 12 (da 12 a. m.), würde der nächste Aufruf von "getIn24hFormat();" 12 Uhr statt 0 Uhr ausgeben
        int hoursIn12hFormat;

        // Option 1: getrennte if-elseif-else
        /* if(this.hours < 12) {
            period = Time.AM;
        } else {
            period = Time.PM;
        }

        hoursIn12hFormat = this.hours;
        if(this.hours == 0) {
            hoursIn12hFormat = 12;
        } else if(this.hours > 0 && this.hours < 13) {
            hoursIn12hFormat = this.hours; // diesen Fall fangen wir bereits über die Initialisierung ab
        } else {
            hoursIn12hFormat = this.hours - 12;
        } */

        // Option 2: Conditional Operator (inline)
        period = this.hours < 12 ? Time.AM : Time.PM;
        hoursIn12hFormat = (this.hours % 12 == 0) ? 12 : (this.hours > 12) ? this.hours - 12 : this.hours;

        // Option 3: kombinierte if-elseif-else
        /* if(this.hours == 0) {
            hoursIn12hFormat = 12;
            period = Time.AM;
        } else if(this.hours > 0 && this.hours <= 11) {
            hoursIn12hFormat = this.hours;
            period = Time.AM;
        } else if(this.hours == 12) {
            hoursIn12hFormat = 12; // oder this.hours;
            period = Time.PM;
        } else if(this.hours > 12 && this.hours <= 23) {
            hoursIn12hFormat = this.hours - 12;
            period = Time.PM;
        } else {
            System.out.println("Das ist keine gültige Zeitangabe!");
            return null; // wir können den Datumsstring nicht zusammenbauen
        }*/

        // Option 4: "Alte" Switch-Notation
        /* switch (this.hours) {
            case 0:
                hoursIn12hFormat = 12;
                period = Time.AM;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                hoursIn12hFormat = this.hours;
                period = Time.AM;
                break;
            case 12:
                hoursIn12hFormat = 12;
                period = Time.PM;
                break;
            case 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23: // alternative Schreibweise, funktioniert in manchen Java-Versionen evtl. nicht
                hoursIn12hFormat = this.hours - 12;
                period = Time.PM;
                break;
            default:
                System.out.println("Das ist keine gültige Zeitangabe!");
                return null; // wir können den Datumsstring nicht zusammenbauen
        } */

        // Option 5: Neue Switch-Notation
        // Hinweis: Erst verfügbar ab Java SDK Version 14 (siehe https://openjdk.java.net/jeps/361)
        /* switch (this.hours) {
            case 0 -> {
                hoursIn12hFormat = 12;
                period = Time.AM;
            }
            case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 -> {
                hoursIn12hFormat = this.hours;
                period = Time.AM;
            }
            case 12 -> {
                hoursIn12hFormat = 12;
                period = Time.PM;
            }
            case 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 -> {
                hoursIn12hFormat = this.hours - 12;
                period = Time.PM;
            }
            default -> {
                System.out.println("Das ist keine gültige Zeitangabe!");
                return null; // wir können den Datumsstring nicht zusammenbauen
            }
        } */

        return hoursIn12hFormat + ":" + this.minutes + " " + period; // die minutes bleiben für beide Formate gleich
    }

    // Wir verwenden hierfür eine statische ("static") Methode, da wir den Test auf der Klasse und nicht auf jedem Objekt
    // einzeln ausführen möchten, da wir keine Objektattribute benötigen, sondern mehrere Objekte der Klasse "Time" zum Testen erzeugen.
    public static void selfTest() {
        System.out.println("\nSelbsttest der Klasse \"Time\" gestartet.");
        for(int i = 0; i <= 24; i++) { // wir wollen "24:xx" auch testen
            Time time = new Time(i, 11 + i);
            System.out.println("Zeit im 12h-Format: " + time.getIn12hFormat());
            System.out.println("Zeit im 24h-Format: " + time.getIn24hFormat());
            System.out.println(); // Abstandshalter
        }
        System.out.println("Selbsttest der Klasse \"Time\" beendet.\n");
    }
}

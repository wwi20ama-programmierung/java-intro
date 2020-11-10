package javaintro.calendar;

/**
 * Alternative zu "Date"-Klasse mit der Verwendung von "int" statt "String" für die Attribute
 */
class DateWithInt {
    private int day;
    private int month;
    private int year;

    // 01.01.2020 -> day: 1, month: 1, year: 2020
    DateWithInt(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        System.out.println("Neues Objekt vom Typ DateWithInt erstellt: " + this.day + "." + this.month + "." + this.year);
    }

    public void setDay(int day) {
        if(day <= 31) { // Hinweis: zur Vereinfachung vernachlässigen wir 28./29./30./31.
            this.day = day;
        } else {
            System.out.println(day + " ist kein valider Tag!");
        }
    }

    // Hinweis: Der Rückgabewert dieser Methode bleibt String, da wir hier nicht nur die Attribute (Typ "int"),
    // sondern einen String, der diese enthält, zurückgeben
    String getInGermanFormat() {
        return this.day + "." + this.month + "." + this.year;
        // return this.day + "." + this.month + "." + this.year;
    }

    // Hinweis: Der Rückgabewert dieser Methode bleibt String, da wir hier nicht nur die Attribute (Typ "int"),
    // sondern einen String, der diese enthält, zurückgeben
    String getInUSFormat() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    boolean isLeapYear() {
        if(this.year % 4 == 0) {
            return true;
        } else {
            return false;
        }
        // return (yearAlsInteger % 4 == 0);
    }
}

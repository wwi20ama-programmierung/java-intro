package javaintro.calendar;

class Time {
    // hier wählen wir "int" als Datentyp und lassen dabei die führenden Nullen (z.B. 2:2 statt 02:02) außer Acht
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    String getIn24hFormat() {
        // erwartetes Format: // 2:34
        return this.hours + ":" + this.minutes;
    }

    String getIn12hFormat() {
        // erwartetes Format: 12:34 a.m. (siehe https://de.wikipedia.org/wiki/2-mal-12-Stunden-Z%C3%A4hlung)
        // TODO
        return "";
    }
}

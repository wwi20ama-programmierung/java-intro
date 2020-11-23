package javaintro.maumau.ki;

class Main {
    public static void main(String[] args) {
        // Neues Spiel erzeugen
        Spiel maumau = new Spiel();

        // Spieler erzeugen
        Spieler spieler1 = new Spieler("Rotkäppchen");
        KI spieler2 = new KI("Böser Wolf");

        // Die Spieler dem Spiel hinzufügen
        maumau.addSpieler(spieler1);
        maumau.addSpieler(spieler2);

        // Spiel starten
        maumau.start();

        // Überprüfung für den alternativen Ansatz (mit Boolean statt getClass()):
        System.out.println("Ist KI-Spieler? " + spieler1.isKI); // false
        System.out.println("Ist KI-Spieler? " + spieler2.isKI); // true
    }
}
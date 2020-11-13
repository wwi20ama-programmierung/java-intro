package javaintro.onlineshop;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // Konsoleneingabe
    Scanner consoleInput = new Scanner(System.in); // System.in = von Konsole einlesen
    System.out.println("Was möchten Sie tun?"); // Wir können nicht einfach wie bei Python unsere "Frage" input() übergebe, deshalb geben wir sie vorher aus
    // String eingabeString = consoleInput.next(); // entspricht in Python input(), also der Abfrage der Benutzereingabe als String
    // int eingabeInt = consoleInput.nextInt(); // entspricht in Python int(input()), also der Abfrage der Benutzereingabe und direkter Konvertierung zu int
    // System.out.println("Der Benutzer hat den String " + eingabeString + " eingegeben und den Integer " + eingabeInt);

    // Onlineshop-Objekt erzeugen
    Onlineshop technikShop = new Onlineshop("Technik-Shop");

    // Kategorien erzeugen
    Category categoryLaptops = new Category("Laptops");
    Category categorySmartphone = new Category("Smartphones");
    Category categoryAccessoires = new Category("Accessoires");

    // Artikel erzeugen und mit Kategorien "verknüpfen" (durch Übergeben der Referenzen als Parameter)
    Article articleMacBook = new Article("Apple MacBook", 14, 2601.89, categoryLaptops);
    Article articleThinkPad = new Article("Lenovo ThinkPad", 28, 1720.0, categoryLaptops);
    Article articleiPhone = new Article("Apple iPhone", 50, 999.99, categorySmartphone);
    Article articleCharger = new Article("Charger", 200, 25.00, categoryAccessoires);
    Article articleCase = new Article("Smartphone Case", 0, 5.00, categoryAccessoires);

    // Kunden erzeugen
    Customer customerHans = new Customer("Hans", "Wurst", "hans.wurst@email.com");
    Customer customerMax = new Customer("Max", "Mustermann", "max@mustermann.com");
    Customer customerErika = new Customer("Erika", "Mustermann", "erika@mustermann.com");

    // Sortiment für Onlineshop pflegen
    technikShop.addArticle(articleMacBook);
    technikShop.addArticle(articleThinkPad);
    technikShop.addArticle(articleiPhone);
    technikShop.addArticle(articleCharger);
    technikShop.addArticle(articleCase);

    // Zur Kontrolle alle Artikel für den "Technik-Shop" an der Konsole ausgeben lassen
    technikShop.listArticles();

    // Kunden zu Onlineshop hinzufügen
    technikShop.addCustomer(customerHans);
    technikShop.addCustomer(customerMax);
    technikShop.addCustomer(customerErika);

    // Aufgabe: Kunde "Hans Wurst" kauft ein MacBook und ein Ladegerät
    // Schritt 1: Hans fügt "MacBook" dem Warenkorb hinzu
    customerHans.getBasket().addArticle(articleMacBook);
    // Schritt 2: Hans fügt "Ladegerät" dem Warenkorb hinzu
    customerHans.getBasket().addArticle(articleCharger);
    // Schritt 3: Wir überprüfen, ob beide Artikel im Warenkorb sind
    customerHans.getBasket().listArticles(); // MacBook, Charger
    // Schritt 4: Hans bezahlt die Artikel in seinem Warenkorb
    customerHans.checkout();

    // Kunde "Erika Mustermann" kauft iPhone und Smartphone-Hülle
    customerErika.getBasket().addArticle(articleiPhone);
    customerErika.getBasket().addArticle(articleCase);

    System.out.println(); // Abstandshalter

    customerErika.getBasket().listArticles(); // Erwartete ausgegebene ArtikeL: iPhone (da Case out of stock)

    customerErika.checkout();

    System.out.println(); // Abstandshalter

    // Artikel im Onlineshop erneut auflisten
    technikShop.listArticles();
  }
}
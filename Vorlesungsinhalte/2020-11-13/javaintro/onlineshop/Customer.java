package javaintro.onlineshop;

public class Customer {
  // Attribute
  private String firstname;
  private String lastname;
  private String email;
  private double invoicingValue = 0.0;
  private Basket basket = new Basket();

  // Konstruktor
  Customer(String firstname, String lastname, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
  }

  // Methoden
  public Basket getBasket() {
    return this.basket;
  }

  // Hinweis: Rückgabewert ist boolean, um in Zukunft z. B. gegen Kreditlimit des Kunden zu prüfen (Kauf erfolgreich ja/nein)
  public boolean checkout() {
    // invoicingValue um Warenkorbwert erhöhen
    this.invoicingValue = this.invoicingValue + this.basket.getTotalValue();
    // Warenkorb leeren
    this.basket.empty();
    
    return true; // im Moment darf der Kunde so viel kaufen wie er/sie möchte
  }
}
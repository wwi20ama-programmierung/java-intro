package javaintro.onlineshop.vererbung;

public class Customer {
    private String firstname;
    private String lastname;
    private String email;
    private double invoicingValue = 0.0;
    private Basket basket = new Basket();

    Customer(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Basket getBasket() {
        return this.basket;
    }

    public boolean checkout() {
        // invoicingValue um Warenkorbwert erhöhen
        this.invoicingValue = this.invoicingValue + this.basket.getTotalValue();
        // Warenkorb leeren
        this.basket.empty();

        return true; // boolean nur, weil wir später evtl. auf Kreditwürdigkeit/-rahmen prüfen möchten
    }
}
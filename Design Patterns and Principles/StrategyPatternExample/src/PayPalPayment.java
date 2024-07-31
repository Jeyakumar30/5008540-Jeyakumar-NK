public class PayPalPayment implements PaymentStrategy {
    @SuppressWarnings("unused")
    private String email, password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal.");
    }
}
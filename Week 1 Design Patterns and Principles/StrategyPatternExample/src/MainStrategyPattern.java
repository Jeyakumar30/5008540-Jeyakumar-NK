public class MainStrategyPattern {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("9012-1704-5678-3456", "Jeyakumar", "302");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(930.00);

        PaymentStrategy payPalPayment = new PayPalPayment("nkjeyakumar@gmail.com", "jeyakumar50080");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(270.00);
    }
}
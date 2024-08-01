public class MainAdapterPattern {
    public static void main(String[] args) {
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        payPalProcessor.processPayment(8100.00);
        stripeProcessor.processPayment(1250.00);
    }
}
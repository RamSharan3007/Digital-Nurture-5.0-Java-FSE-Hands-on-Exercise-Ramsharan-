public class AdapterPatternExample 
{
    interface PaymentProcessor {
        void processPayment(double amount);
    }
    static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }
    static class StripeGateway {
        public void executePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through Stripe.");
        }
    }
    static class RazorpayGateway {
        public void pay(double amount) {
            System.out.println("Processing payment of $" + amount + " through Razorpay.");
        }
    }
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPalGateway;
        public PayPalAdapter(PayPalGateway payPalGateway) {
            this.payPalGateway = payPalGateway;
        }
        @Override
        public void processPayment(double amount) {
            payPalGateway.makePayment(amount);
        }
    }
    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripeGateway;
        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }
        @Override
        public void processPayment(double amount) {
            stripeGateway.executePayment(amount);
        }
    }
    static class RazorpayAdapter implements PaymentProcessor {
        private RazorpayGateway razorpayGateway;
        public RazorpayAdapter(RazorpayGateway razorpayGateway) {
            this.razorpayGateway = razorpayGateway;
        }
        @Override
        public void processPayment(double amount) {
            razorpayGateway.pay(amount);
        }
    }
    public static void main(String[] args) {
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();
        RazorpayGateway razorpayGateway = new RazorpayGateway();

        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
        PaymentProcessor razorpayAdapter = new RazorpayAdapter(razorpayGateway);

        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
        razorpayAdapter.processPayment(300.0);
    }
        
}

package behavioral.strategy;
public class StrategyDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        
        // Using PayPal strategy
        context.setPaymentStrategy(new PaypalPayment("user@example.com"));
        context.executePayment(100.0);
        
        // Switching to crypto strategy
        context.setPaymentStrategy(new CryptoPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        context.executePayment(250.0);
    }

}

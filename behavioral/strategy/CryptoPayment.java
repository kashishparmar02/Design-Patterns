package behavioral.strategy;
public class CryptoPayment implements PaymentStrategy {
    private String walletAddress;
    
    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using crypto wallet: " + 
                          walletAddress.substring(0, 6) + "...");
    }
}

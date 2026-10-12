package subsystem;

public class PaymentSystem {
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("[PaymentSystem] Error: Invalid payment amount (" + amount + "$)!");
            return false;
        }
        System.out.println("[PaymentSystem] Payment successful: " + amount + "$");
        return true;
    }

    public void refundPayment(double amount) {
        System.out.println("[PaymentSystem] Refund processed: " + amount + "$");
    }
}
package subsystem;

import java.util.HashMap;
import java.util.Map;

public class PaymentSystem {
    private final Map<String, Integer> balances;

    public PaymentSystem(Map<String, Integer> startBalances) {
        this.balances = new HashMap<>(startBalances);
    }

    public void charge(String customer, int price) throws CoffeeException {
        Integer balance = balances.get(customer);
        if (balance == null) {
            throw new CoffeeException("PaymentSystem: unknown customer '" + customer + "'");
        }
        if (balance < price) {
            throw new CoffeeException("PaymentSystem: '" + customer + "' has only " + balance + ", but the price is " + price);
        }
        balances.put(customer, balance - price);
        System.out.println("[PaymentSystem] Charged " + price + " from '" + customer + "'");
    }

    public void refund(String customer, int price) {
        balances.merge(customer, price, Integer::sum);
        System.out.println("[PaymentSystem] Refunded " + price + " to '" + customer + "'");
    }

    public int getBalance(String customer) {
        return balances.getOrDefault(customer, 0);
    }
}

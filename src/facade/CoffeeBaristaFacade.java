package facade;

import subsystem.CoffeeException;
import subsystem.EspressoMachine;
import subsystem.Grinder;
import subsystem.MilkFrother;
import subsystem.PaymentSystem;

import java.util.Map;

public class CoffeeBaristaFacade {
    private static final int ESPRESSO_PRICE = 3;
    private static final int CAPPUCCINO_PRICE = 4;
    private static final int COFFEE_DOSE_GRAMS = 18;
    private static final int SHOT_ML = 30;
    private static final int CAPPUCCINO_MILK_ML = 120;

    private final Grinder grinder = new Grinder(200);
    private final EspressoMachine espressoMachine = new EspressoMachine(1000);
    private final MilkFrother milkFrother = new MilkFrother(
            Map.of("Whole Milk", 250, "Oat Milk", 500));
    private final PaymentSystem paymentSystem = new PaymentSystem(
            Map.of("alice", 30, "bob", 2));

    public String orderEspresso(String customer) {
        try {
            paymentSystem.charge(customer, ESPRESSO_PRICE);
        } catch (CoffeeException e) {
            return "Payment declined: " + e.getMessage();
        }

        try {
            makeEspressoShot();
            return "Your espresso is ready!";
        } catch (CoffeeException e) {
            return refundAfterProblem(customer, ESPRESSO_PRICE, e);
        }
    }

    public String orderCappuccino(String customer, String milkType) {
        try {
            paymentSystem.charge(customer, CAPPUCCINO_PRICE);
        } catch (CoffeeException e) {
            return "Payment declined: " + e.getMessage();
        }

        try {
            makeEspressoShot();
            milkFrother.froth(milkType, CAPPUCCINO_MILK_ML);
            return "Your cappuccino with " + milkType + " is ready!";
        } catch (CoffeeException e) {
            return refundAfterProblem(customer, CAPPUCCINO_PRICE, e);
        }
    }

    private void makeEspressoShot() throws CoffeeException {
        int groundCoffee = grinder.grind(COFFEE_DOSE_GRAMS);
        espressoMachine.makeShot(groundCoffee, SHOT_ML);
    }

    private String refundAfterProblem(String customer, int price, CoffeeException problem) {
        paymentSystem.refund(customer, price);
        return "Sorry, we could not make your drink: " + problem.getMessage() + ". Your money was returned.";
    }
}

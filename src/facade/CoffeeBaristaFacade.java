package facade;

import subsystem.Grinder;
import subsystem.MilkFrother;
import subsystem.PaymentSystem;
import subsystem.SyrupDispenser;

public class CoffeeBaristaFacade {
    private final Grinder grinder;
    private final MilkFrother milkFrother;
    private final SyrupDispenser syrupDispenser;
    private final PaymentSystem paymentSystem;

    public CoffeeBaristaFacade(Grinder grinder, MilkFrother milkFrother,
                               SyrupDispenser syrupDispenser, PaymentSystem paymentSystem) {
        this.grinder = grinder;
        this.milkFrother = milkFrother;
        this.syrupDispenser = syrupDispenser;
        this.paymentSystem = paymentSystem;
    }

    public void orderEspresso(double price) {
        System.out.println("\n*Starting Espresso Preparation*");
        if (!paymentSystem.processPayment(price)) {
            System.out.println("[Facade] Order canceled due to payment failure.");
            return;
        }

        grinder.grindBeans("Arabica Dark Roast");
        System.out.println("[Facade] Your Espresso is ready!");
    }

    public void orderCappuccino(double price, String milkType) {
        System.out.println("\n*Starting Cappuccino Preparation*");
        if (!paymentSystem.processPayment(price)) {
            System.out.println("[Facade] Order canceled due to payment failure.");
            return;
        }

        grinder.grindBeans("Arabica Medium Roast");
        milkFrother.frothMilk(milkType);
        System.out.println("[Facade] Your Cappuccino is ready!");
    }

    public void orderCaramelMacchiato(double price, String milkType) {
        System.out.println("\n*Starting Caramel Macchiato Preparation*");
        if (!paymentSystem.processPayment(price)) {
            System.out.println("[Facade] Order canceled due to payment failure.");
            return;
        }

        try {
            grinder.grindBeans("Arabica Premium");
            syrupDispenser.addSyrup("Caramel");
            milkFrother.frothMilk(milkType);
            System.out.println("[Facade] Your Caramel Macchiato is ready!");
        } catch (Exception e) {
            System.out.println("[Facade] Preparation failed! Rolling back transaction...");
            paymentSystem.refundPayment(price);
        }
    }
}
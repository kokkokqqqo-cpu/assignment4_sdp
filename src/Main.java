import facade.CoffeeBaristaFacade;
import subsystem.Grinder;
import subsystem.MilkFrother;
import subsystem.PaymentSystem;
import subsystem.SyrupDispenser;

public class Main {
    public static void main(String[] args) {
        Grinder grinder = new Grinder();
        MilkFrother frother = new MilkFrother();
        SyrupDispenser dispenser = new SyrupDispenser();
        PaymentSystem payment = new PaymentSystem();

        CoffeeBaristaFacade barista = new CoffeeBaristaFacade(grinder, frother, dispenser, payment);

        System.out.println("*** Client #1 ordering Espresso ***");
        barista.orderEspresso(3.00);

        System.out.println("\n*** Client #2 ordering Cappuccino ***");
        barista.orderCappuccino(4.00, "Whole Milk");

        System.out.println("\n*** Client #3 ordering Caramel Macchiato ***");
        barista.orderCaramelMacchiato(5.00, "Oat Milk");

        System.out.println("\n*** Expert accessing subsystem directly ***");
        grinder.grindBeans("Robusta Extra");
    }
}
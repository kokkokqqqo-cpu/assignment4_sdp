import subsystem.CoffeeException;
import subsystem.EspressoMachine;
import subsystem.Grinder;

public class AdvancedClientDemo {
    public static void main(String[] args) throws CoffeeException {
        Grinder grinder = new Grinder(50);
        EspressoMachine machine = new EspressoMachine(500);

        int coffee = grinder.grind(20);
        int shot = machine.makeShot(coffee, 60);

        System.out.println("I made my own " + shot + " ml double shot without the facade.");
    }
}

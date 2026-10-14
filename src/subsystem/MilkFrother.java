package subsystem;

import java.util.HashMap;
import java.util.Map;

public class MilkFrother {
    private final Map<String, Integer> milkMl;

    public MilkFrother(Map<String, Integer> startMilkMl) {
        this.milkMl = new HashMap<>(startMilkMl);
    }

    public int froth(String milkType, int amountMl) throws CoffeeException {
        Integer available = milkMl.get(milkType);
        if (available == null) {
            throw new CoffeeException("MilkFrother: we do not have '" + milkType + "'");
        }
        if (available < amountMl) {
            throw new CoffeeException("MilkFrother: not enough '" + milkType + "' (need " + amountMl + " ml, have " + available + " ml)");
        }
        milkMl.put(milkType, available - amountMl);
        System.out.println("[MilkFrother] Frothed " + amountMl + " ml of " + milkType + " (left: " + (available - amountMl) + " ml)");
        return amountMl;
    }

    public int getMilkMl(String milkType) {
        return milkMl.getOrDefault(milkType, 0);
    }
}

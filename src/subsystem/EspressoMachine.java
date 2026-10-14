package subsystem;

public class EspressoMachine {
    private static final int MIN_COFFEE_GRAMS = 7;

    private int waterMl;

    public EspressoMachine(int waterMl) {
        this.waterMl = waterMl;
    }

    public int makeShot(int groundCoffeeGrams, int shotMl) throws CoffeeException {
        if (groundCoffeeGrams < MIN_COFFEE_GRAMS) {
            throw new CoffeeException("EspressoMachine: too little coffee (" + groundCoffeeGrams + " g, minimum " + MIN_COFFEE_GRAMS + " g)");
        }
        if (shotMl > waterMl) {
            throw new CoffeeException("EspressoMachine: not enough water");
        }
        waterMl -= shotMl;
        System.out.println("[EspressoMachine] Made a " + shotMl + " ml shot (water left: " + waterMl + " ml)");
        return shotMl;
    }

    public int getWaterMl() {
        return waterMl;
    }
}


package subsystem;

public class Grinder {
    private int beansGrams;

    public Grinder(int beansGrams) {
        this.beansGrams = beansGrams;
    }

    public int grind(int grams) throws CoffeeException {
        if (grams > beansGrams) {
            throw new CoffeeException("Grinder: not enough beans (need " + grams + " g, have " + beansGrams + " g)");
        }
        beansGrams -= grams;
        System.out.println("[Grinder] Ground " + grams + " g of beans (left: " + beansGrams + " g)");
        return grams;
    }

    public int getBeansGrams() {
        return beansGrams;
    }
}
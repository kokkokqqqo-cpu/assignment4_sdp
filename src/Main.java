import facade.CoffeeBaristaFacade;

public class Main {
    public static void main(String[] args) {
        CoffeeBaristaFacade barista = new CoffeeBaristaFacade();

        System.out.println("=== 1. Alice orders an espresso ===");
        System.out.println(barista.orderEspresso("alice"));

        System.out.println("\n=== 2. Alice orders a cappuccino with oat milk ===");
        System.out.println(barista.orderCappuccino("alice", "Oat Milk"));

        System.out.println("\n=== 3. Alice orders a cappuccino with whole milk ===");
        System.out.println(barista.orderCappuccino("alice", "Whole Milk"));

        System.out.println("\n=== 4. Alice orders one more cappuccino with whole milk ===");
        System.out.println(barista.orderCappuccino("alice", "Whole Milk"));

        System.out.println("\n########## Problems ##########");

        System.out.println("\n=== 5. Whole milk is almost finished (drink fails, money returned) ===");
        System.out.println(barista.orderCappuccino("alice", "Whole Milk"));

        System.out.println("\n=== 6. Bob has too little money (payment declined) ===");
        System.out.println(barista.orderCappuccino("bob", "Oat Milk"));

        System.out.println("\n=== 7. Coconut milk does not exist (drink fails, money returned) ===");
        System.out.println(barista.orderCappuccino("alice", "Coconut Milk"));

        System.out.println("\n=== 8. Unknown customer (payment declined) ===");
        System.out.println(barista.orderEspresso("mallory"));
    }
}

package test;

import facade.CoffeeBaristaFacade;

public class CoffeeBaristaFacadeTest {
    private static int failed = 0;

    public static void main(String[] args) {
        CoffeeBaristaFacade barista = new CoffeeBaristaFacade();
        check("espresso works", barista.orderEspresso("alice").startsWith("Your espresso"));
        check("cappuccino works", barista.orderCappuccino("alice", "Oat Milk").startsWith("Your cappuccino"));

        check("poor customer is declined", barista.orderCappuccino("bob", "Oat Milk").startsWith("Payment declined"));
        check("unknown customer is declined", barista.orderEspresso("mallory").startsWith("Payment declined"));

        String coconut = barista.orderCappuccino("alice", "Coconut Milk");
        check("unknown milk: drink fails", coconut.startsWith("Sorry"));
        check("unknown milk: money returned", coconut.contains("money was returned"));

        CoffeeBaristaFacade other = new CoffeeBaristaFacade();
        other.orderCappuccino("alice", "Whole Milk");
        other.orderCappuccino("alice", "Whole Milk");
        String third = other.orderCappuccino("alice", "Whole Milk");
        check("milk runs out: drink fails", third.startsWith("Sorry"));
        check("milk runs out: money returned", third.contains("money was returned"));

        System.out.println(failed == 0 ? "\nAll tests passed." : "\nFailed tests: " + failed);
        if (failed > 0) {
            System.exit(1);
        }
    }

    private static void check(String name, boolean ok) {
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if (!ok) {
            failed++;
        }
    }
}

# Assignment 4 - Facade Pattern (Coffee Barista)

Student: Azhikhat Nurai, SE2523 | Course: ShP-2216 Software Design Patterns 

## What is this project?

A small coffee shop. To make a coffee we need four machines: a grinder, an espresso machine,
a milk frother and a payment system. The client should not control all of them by himself.
So I made one class, `CoffeeBaristaFacade`, that does it for the client.

```java
CoffeeBaristaFacade barista = new CoffeeBaristaFacade();
System.out.println(barista.orderCappuccino("alice", "Oat Milk"));
```

If something goes wrong after the payment (for example, no milk), the facade returns the money.

## Folders

```
src/
  Main.java                   the client (uses ONLY the facade)
  AdvancedClientDemo.java     client that does NOT use the facade (uses subsystem directly)
  facade/
    CoffeeBaristaFacade.java  the Facade
  subsystem/
    Grinder.java              beans
    EspressoMachine.java      makes the shot
    MilkFrother.java          milk
    PaymentSystem.java        money, charge and refund
    CoffeeException.java      one exception for all problems
test/
  CoffeeBaristaFacadeTest.java   simple tests
docs/
  uml.png, demo_output.txt, test_output.txt
```

## How to run (JDK 17)

```
mkdir out
javac -d out src/*.java src/facade/*.java src/subsystem/*.java test/*.java
java -cp out Main
java -cp out AdvancedClientDemo
java -cp out CoffeeBaristaFacadeTest
```

In IntelliJ: mark `src` as Sources Root, `test` as Test Sources Root, run `Main`.

## Check with the task

| Task requirement | Where |
|---|---|
| 3+ subsystem classes with real work | Grinder, EspressoMachine, MilkFrother, PaymentSystem |
| Facade with a small API, right order | CoffeeBaristaFacade (2 order methods) |
| Client uses only the facade | Main (only one import: the facade) |
| Subsystem does not know the facade | no word "facade" in the `subsystem` folder |
| Subsystem can be used directly | AdvancedClientDemo |
| Error handling | payment declined / money returned when the drink fails |

# Coffee Shop Express Barista (Facade Pattern) 

This repository contains an implementation of the **Facade Structural Design Pattern** in Java for a Coffee Shop Management System.

##  Project Overview
In a coffee shop, preparing a drink like a **Caramel Macchiato** requires interacting with multiple complex machines:
1. Grinding coffee beans
2. Dispensing flavored syrups
3. Frothing milk
4. Processing payment and managing rollbacks

Without a **Facade**, the client (customer/cashier) would have to manually operate and coordinate all four machines in the correct order. The `CoffeeBaristaFacade` class simplifies this process by providing simple, high-level methods like `orderCaramelMacchiato()`, hiding the inner complexity of the subsystem.

---

##  Subsystem Components
The project consists of 4 main subsystem classes:
* **`Grinder`**: Handles grinding different types of coffee beans.
* **`MilkFrother`**: Froths different milk types (Whole, Oat, etc.).
* **`SyrupDispenser`**: Dispenses flavored syrups (Caramel, Vanilla, etc.).
* **`PaymentSystem`**: Processes transactions and handles refunds on failure.

---

##  Key Design Highlights
* **Simplified API**: Clients can order complex drinks via single method calls (`orderEspresso`, `orderCappuccino`, `orderCaramelMacchiato`).
* **Error Handling & Rollback**: If a payment fails, the transaction is canceled and no beans or milk are wasted.
* **Direct Access Preserved**: Expert clients can still access subsystem components directly (e.g., calling `Grinder` directly) without bypassing or breaking the Facade pattern.

---

##  How to Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/kokkokqqqo-cpu/assignment4_sdp.git](https://github.com/kokkokqqqo-cpu/assignment4_sdp.git)

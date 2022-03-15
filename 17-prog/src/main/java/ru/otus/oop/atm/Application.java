package ru.otus.oop.atm;

import ru.otus.oop.atm.impl.AutomatedTellerMachine;
import ru.otus.oop.atm.interfaces.ATM;

public class Application {
    public static void main(String[] args) {
        ATM atm = new AutomatedTellerMachine();

        atm.accountState().printState();

        try {
            atm.withdraw(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        atm.saveState();
        atm.load();

    }
}

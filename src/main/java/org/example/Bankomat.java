package org.example;
import java.util.ArrayList;

public interface Bankomat {
    void insertCard(int cardNumber);

    boolean enterPin(int pinCode);

    Client getCurrentUser();

    double checkBalance();

    void deposit(double amount);

    void withdraw(double amount);

    void ejectCard();

    void blockCard();

}
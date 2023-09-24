package org.example;

public interface Client {
    String getUserName();
    int getAccountId();
    double getAccountBalance();
    void setAccountBalance(double accountBalance);
    Card getUserCard();
}
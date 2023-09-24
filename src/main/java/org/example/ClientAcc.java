package org.example;

public class ClientAcc implements Client {
    private String userName;
    private int accountId;
    private double accountBalance;
    private Card userCard;
    public ClientAcc(String userName, int accountId, double accountBalance, Card userCard) {
        this.userName = userName;
        this.accountId = accountId;
        this.accountBalance = accountBalance;
        this.userCard = userCard;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public int getAccountId() {
        return accountId;
    }

    @Override
    public double getAccountBalance() {
        return accountBalance;
    }
    @Override
    public Card getUserCard() {
        return userCard;
    }
    @Override
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
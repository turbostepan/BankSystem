package org.example;

public class ClientAcc implements Client {
    private String userName;
    private int accountID;
    private double accountBalance;
    private Card userCard;
    public ClientAcc(String userName, int accountID, double accountBalance, Card clientCard) {
        this.userName = userName;
        this.accountID = accountID;
        this.accountBalance = accountBalance;
        this.userCard = clientCard;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public int getAccountId() {
        return accountID;
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
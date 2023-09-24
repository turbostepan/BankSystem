package org.example;

import java.util.ArrayList;
import java.util.Scanner;
public class Terminal implements Bankomat {
    Scanner sc = new Scanner(System.in);
    private Card currentCard;
    private ClientAcc currentUser;
    private int remainingPinAttempts;
    private boolean next = false;
    public ArrayList<Card> cards = new ArrayList<Card>();
    public ArrayList<ClientAcc> bankAccounts = new ArrayList<>();
    public Card card1 = new Card(123456,1234,123);
    public Card card2 = new Card(654321,4321,321);
    public ClientAcc user1 = new ClientAcc("Stepan",1,1234, card1);
    public ClientAcc user2 = new ClientAcc ("Slayik",2,4321, card2);
    Proverka cti = new Proverka();
    private int checkMethod() {
        System.out.println("Что бы посмотреть баланс введите 1");
        System.out.println("Что бы положить деньги введите 2");
        System.out.println("Что бы снять деньги введите 3");
        System.out.println("Что бы выйти с терминала введите 4");
        int method = cti.integer();
        return method;
    }
    private int checkPinCode() {
        System.out.println("Введите пин-код:");
        int pinCode = cti.integer();
        return pinCode;
    }
    private double checkMethodsTwo() {
        System.out.println("Введите сумму которую хотите положить:");
        double sum = sc.nextDouble();
        return sum;
    }
    private double checkMethodsThree() {
        System.out.println("Введите сумму которую хотите снять:");
        double sum = sc.nextDouble();
        return sum;
    }
    public void terminate() {
        cards.add(card1);
        cards.add(card2);
        bankAccounts.add(user1);
        bankAccounts.add(user2);
        System.out.println("Введите номер карты:");
        int card = cti.integer();
        if (card > 0) {
            insertCard(card);
            next = true;
        } else if (card == -1) {
            System.out.println("Вы ввели не правильный тип данных");
            terminate();
        }

        for (int i = 0; i <= remainingPinAttempts; i++) {
            int pinCode = checkPinCode();
            boolean x = false;
            if(pinCode > 0) {
                x = enterPin(pinCode);
            }
            if (x == true) {
                while (currentCard != null) {
                    int method = checkMethod();
                    if(method == -1){
                        System.out.println("Вы ввели не правильный тип данных");
                        method = checkMethod();
                    }
                    if (method == 1) {
                        System.out.println(checkBalance());
                    } else if (method == 2) {
                        double sum = checkMethodsTwo();
                        if(sum == -1){
                            System.out.println("Вы ввели не правильный тип данных");
                            sum = checkMethodsTwo();
                        }else {
                            deposit(sum);
                        }
                    } else if (method == 3) {
                        double sum = checkMethodsThree();
                        if(sum == -1){
                            System.out.println("Вы ввели не правильный тип данных");
                            sum = checkMethodsThree();
                        }else {
                            withdraw(sum);
                        }
                    } else if (method == 4) {
                        System.out.println("Вы вышли из терминала");
                        ejectCard();
                    }
                }
                return;
            }else {
                System.out.println("Вы ввели не правильный тип данных");
                pinCode = checkPinCode();
            }
        }
    }
    @Override
    public void insertCard(int cardNumber) {
        for(int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getCardNumber() == cardNumber){
                currentCard = cards.get(i);
            };
        }
        remainingPinAttempts = 3;
    }

    @Override
    public boolean enterPin(int pin) {
        if (currentCard != null && pin == currentCard.getPinCode() && remainingPinAttempts > 0) {
            for(int i =0; i < bankAccounts.size(); i++) {
                if (bankAccounts.get(i).getUserCard() == currentCard){
                    currentUser = bankAccounts.get(i);
                    System.out.println("Добро пожаловать " + userName );
                    getCurrentUser();
                }
            }
            return true;
        } else {
            remainingPinAttempts--;
            if (remainingPinAttempts == 0) {
                blockCard();
            }
            return false;
        }
    }

    @Override
    public Client getCurrentUser() {
        System.out.println("Имя: " + currentUser.getUserName());
        return currentUser;
    }

    @Override
    public double checkBalance() {
        if (currentUser != null) {
            return currentUser.getAccountBalance();
        }
        return 0.0;
    }

    @Override
    public void deposit(double amount) {
        double x =currentUser.getAccountBalance();
        if (amount > 0) {
            currentUser.setAccountBalance(x += amount);
            System.out.println("Вы внесли " + amount + "Средсв на счету: " + x);
        }else {
            System.out.println("Ошибка 154 (недопустимая сумма)");
        }
    }

    @Override
    public void withdraw(double amount) {
        double x = currentUser.getAccountBalance();
        if (amount > 0 && amount <= x) {

            currentUser.setAccountBalance(x -= amount);
            System.out.println("Снято " + amount + "Средсв на счету: " + x);
        }else {
            System.out.println("Ошибка 154 (недопустимая сумма)");
        }
    }

    @Override
    public void ejectCard() {
        currentCard = null;
        currentUser = null;
    }

    @Override
    public void blockCard() {
        System.out.println("Система распознала в вас угрозу");
        currentCard.setIsBlocked(true);
    }
}
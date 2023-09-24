package org.example;
import java.util.Scanner;
public class Proverka {
    public int integer() {
        Scanner sc = new Scanner(System.in);
        int x;
        try {
            x = sc.nextInt();
            return x;
        } catch (Exception e) {
            return -1;
        }
    }
    public double Double() {
        Scanner sc = new Scanner(System.in);
        double x;
        try {
            x = sc.nextDouble();
            return x;
        } catch (Exception e) {
            return -1;
        }
    }
}
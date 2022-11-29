package mvc;

import entity.*;

import java.util.Map;
import java.util.Scanner;

public class View implements ViewInter {
    @Override
    public void finalStatistics(int totalSum, double clearIncome, int i) {
        System.out.println("*************************************************");
        System.out.println("The total income: " + totalSum);
        System.out.println("The month income: " + totalSum / (i / 30));
        System.out.println("The Company income: " + clearIncome);
        System.out.println("*************************************************");
    }

    @Override
    public void border2() {
        System.out.println("++++++++++++++++++++++++++");
        System.out.print("Tap \"end\" to finish: ");
    }

    @Override
    public void productsPrice(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte) {
        System.out.println("Americano price: " + americano.getPrice());
        System.out.println("Espresso price: " + espresso.getPrice());
        System.out.println("Cappuccino price: " + cappuccino.getPrice());
        System.out.println("Latte price: " + latte.getPrice());
    }

    @Override
    public void minMax(String s1, String s2) {
        System.out.println("Max: " + s1);
        System.out.println("Min: " + s2);
    }

    @Override
    public void productsStatistics(double income, int es, int am, int cap, int lat) {
        System.out.println("Month income: " + income);
        System.out.println("Espresso " + es);
        System.out.println("Americano " + am);
        System.out.println("Cappuccino " + cap);
        System.out.println("Latte " + lat);
    }

    @Override
    public void payments(double expendCoffee, double expendMilk, double expendVegMilk, double sum1, double sum2) {
        System.out.println("Coffee price: " + expendCoffee);
        System.out.println("Milk price: " + expendMilk);
        System.out.println("Veg milk: " + expendVegMilk);
        System.out.println("Total payment: " + sum1);
        System.out.println("Staff salary: " + sum2);
    }

    @Override
    public void monthStatus(int monthSum, int i) {
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(i / 30 + ". Month");
        System.out.println("The month total money: " + monthSum);
    }

    @Override
    public void border1() {
        System.out.println("---------------");
    }

    @Override
    public void daylyIncome(float med) {
        System.out.println("The daily medium income: " + med);
    }

    @Override
    public String getString(Scanner scanner) {
        String stop;
        stop = scanner.next();
        return stop;
    }

    @Override
    public void buyCoffee(Map<Coffee, Integer> companyCoffee, Client client, Coffee coffee) {
        if (client.getMoney() > coffee.getPrice()) {
            if (companyCoffee.get(coffee) > 0) {
                if ((coffee.isDairyMilk() == true) && (client.isLactoseTolerant() == false)) {
                    System.out.println(" and client cannot buy it but it will have vegan milk with additional price");
                } else {
                    System.out.println(" and client buy it");
                }
            } else {
                System.out.println(" There is not in stock ");
            }
        } else {
            System.out.println(" He don't have enough money");
        }
    }

    @Override
    public void showCosts(Coffee coffee) {
        System.out.print(coffee.getName() + " that costs " + coffee.getPrice());
    }

    @Override
    public void clientComes(Client client) {
        System.out.println();
        if (client.isLactoseTolerant()) {
            System.out.println("A client comes and has " + client.getMoney() + " money and likes Milk");
        } else {
            System.out.println("A client comes and has " + client.getMoney() + " money and hates Milk");
        }
        System.out.println("  Order: ");
    }

    @Override
    public void dayCount(int i) {
        System.out.println("---------------");
        System.out.println("Day " + i);
    }
}

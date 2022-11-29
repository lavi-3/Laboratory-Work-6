package mvc;

import entity.*;

import java.util.Map;
import java.util.Scanner;

public interface ViewInter {
    void finalStatistics(int totalSum, double clearIncome, int i);

    void border2();

    void productsPrice(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte);

    void minMax(String s1, String s2);

    void productsStatistics(double income, int es, int am, int cap, int lat);

    void payments(double expendCoffee, double expendMilk, double expendVegMilk, double sum1, double sum2);

    void monthStatus(int monthSum, int i);

    void border1();

    void daylyIncome(float med);

    void buyCoffee(Map<Coffee, Integer> companyCoffee, Client client, Coffee coffee);

    void showCosts(Coffee coffee);

    void clientComes(Client client);

    void dayCount(int i);
    String getString(Scanner scanner);
}

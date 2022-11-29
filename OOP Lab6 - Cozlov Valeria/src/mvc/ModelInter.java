package mvc;

import entity.*;
import market.Company;
import market.Employee;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public interface ModelInter {
    boolean isEnd(String stop);

    int getTotalSum(int totalSum, int monthSum);

    void removePrice(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte, String s2);

    void addPrice(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte, String s1);

    void experienceChenge(Employee manager, Employee barista);

    String getS2(Map<Integer, String> stringIntegerMap, Integer min);

    String getS1(Map<Integer, String> stringIntegerMap, Integer max);

    Integer getMin(List<Integer> integers);

    Integer getMax(List<Integer> integers);

    List<Integer> getIntegers(int es, int am, int cap, int lat);

    void coffeeSetUp(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte, Map<Coffee, Integer> companyCoffee, Company company);

    double getClearIncome(double income, double clearIncome);

    double getIncome(int monthSum, double sum1, double sum2);

    Map<Integer, String> getIntegerStringMap(int es, int am, int cap, int lat);

    double getSum2(Employee manager, Employee barista);

    double getSum1(double expendCoffee, double expendMilk, double expendVegMilk);

    double getExpendVegMilk(int veg);

    double getExpendMilk(Latte latte, int cap, int lat);

    double getExpendCoffee(Espresso espresso, int es, int am, int cap, int lat);

    float getMed(int monthSum);

    void totalEarn(Company company, int monthSum);

    boolean monthCheck(int i);

    int getMonthSum(int monthSum, int daySum);

    void moneyExtract(Client client, Coffee coffee);

    int getDaySum(Random random, Employee barista, int daySum, Coffee coffee);

    int experienceBarista(Random random, Employee barista, int daySum, Coffee coffee);

    int getVeg(int veg);

    int getDaySum2(int daySum, Coffee coffee);

    int getDaySum1(Random random, int daySum, Coffee coffee);

    boolean baristaExperience(Employee barista);

    void setMoney(Client client, Coffee coffee);

    boolean milkPresence(Client client, Coffee coffee);

    void coffeeUpdate1(Map<Coffee, Integer> companyCoffee, Coffee coffee);

    boolean coffeeCheck(Map<Coffee, Integer> companyCoffee, Coffee coffee);

    boolean moneyCheck(Client client, Coffee coffee);

    Coffee getCoffee(List<Coffee> coffees, Random random);

    int getNrOfProducts(Random random);

    Client getClient(Random random, List<Boolean> booleans);

    int getNrOfClients(Random random);

    List<Boolean> getBooleans();

    Company getCompany(Employee manager, Employee barista, Map<Coffee, Integer> companyCoffee);

    Map<Coffee, Integer> getCoffeeIntegerMap(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte);

    Employee getBarista(Random random);

    Employee getManager(Random random);

    Scanner getScanner();

    Random getRandom();

    List<Coffee> getCoffees(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte);

    Latte getLatte();

    Cappuccino getCappuccino();

    Espresso getEspresso();

    Americano getAmericano();
}

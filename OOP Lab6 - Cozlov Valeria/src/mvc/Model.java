package mvc;

import entity.*;
import market.Barista;
import market.Company;
import market.Employee;
import market.Manager;

import java.util.*;

public class Model implements ModelInter{
    @Override
    public boolean isEnd(String stop) {
        return stop.equals("end");
    }

    @Override
    public int getTotalSum(int totalSum, int monthSum) {
        totalSum += monthSum;
        return totalSum;
    }

    @Override
    public void removePrice(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte, String s2) {
        switch (s2) {
            case "Americano" -> americano.setPrice(americano.getPrice() - 5);
            case "Cappuccino" -> cappuccino.setPrice(cappuccino.getPrice() - 5);
            case "Espresso" -> espresso.setPrice(espresso.getPrice() - 5);
            default -> latte.setPrice(latte.getPrice() - 5);
        }
    }

    @Override
    public void addPrice(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte, String s1) {
        switch (s1) {
            case "Americano" -> americano.setPrice(americano.getPrice() + 5);
            case "Cappuccino" -> cappuccino.setPrice(cappuccino.getPrice() + 5);
            case "Espresso" -> espresso.setPrice(espresso.getPrice() + 5);
            default -> latte.setPrice(latte.getPrice() + 5);
        }
    }

    @Override
    public void experienceChenge(Employee manager, Employee barista) {
        barista.setExperience(barista.getExperience() + 1);
        manager.setExperience(barista.getExperience() + 1);
    }

    @Override
    public String getS2(Map<Integer, String> stringIntegerMap, Integer min) {
        return stringIntegerMap.get(min);
    }

    @Override
    public String getS1(Map<Integer, String> stringIntegerMap, Integer max) {
        return stringIntegerMap.get(max);
    }

    @Override
    public Integer getMin(List<Integer> integers) {
        return integers.stream().min(Integer::compareTo).orElseThrow();
    }

    @Override
    public Integer getMax(List<Integer> integers) {
        return integers.stream().max(Integer::compareTo).orElseThrow();
    }

    @Override
    public List<Integer> getIntegers(int es, int am, int cap, int lat) {
        return new ArrayList<>(List.of(es, am, cap, lat));
    }

    @Override
    public void coffeeSetUp(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte, Map<Coffee, Integer> companyCoffee, Company company) {
        companyCoffee.put(americano, 100);
        companyCoffee.put(espresso, 100);
        companyCoffee.put(cappuccino, 80);
        companyCoffee.put(latte, 80);
        company.setCompanyCoffee(companyCoffee);
    }

    @Override
    public double getClearIncome(double income, double clearIncome) {
        clearIncome += income;
        return clearIncome;
    }

    @Override
    public double getIncome(int monthSum, double sum1, double sum2) {
        double income;
        income = monthSum - (sum1 + sum2);
        return income;
    }

    @Override
    public Map<Integer, String> getIntegerStringMap(int es, int am, int cap, int lat) {
        Map<Integer, String> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put(am, "Americano");
        stringIntegerMap.put(cap, "Cappuccino");
        stringIntegerMap.put(es, "Espresso");
        stringIntegerMap.put(lat, "Latte");
        return stringIntegerMap;
    }

    @Override
    public double getSum2(Employee manager, Employee barista) {
        return barista.getSalary() + manager.getSalary();
    }

    @Override
    public double getSum1(double expendCoffee, double expendMilk, double expendVegMilk) {
        return expendMilk + expendCoffee + expendVegMilk;
    }

    @Override
    public double getExpendVegMilk(int veg) {
        return veg * 5 * 0.3;
    }

    @Override
    public double getExpendMilk(Latte latte, int cap, int lat) {
        return (cap + lat) * latte.getPrice() * 0.3;
    }

    @Override
    public double getExpendCoffee(Espresso espresso, int es, int am, int cap, int lat) {
        return (es + cap + am + lat) * espresso.getPrice() * 0.3;
    }

    @Override
    public float getMed(int monthSum) {
        return monthSum / 30.f;
    }

    @Override
    public void totalEarn(Company company, int monthSum) {
        System.out.println();
        company.setTotalEarn(company.getTotalEarn() + monthSum);
    }

    @Override
    public boolean monthCheck(int i) {
        return i % 30 == 0;
    }

    @Override
    public int getMonthSum(int monthSum, int daySum) {
        monthSum += daySum;
        return monthSum;
    }

    @Override
    public void moneyExtract(Client client, Coffee coffee) {
        client.setMoney(client.getMoney() - coffee.getPrice());
    }

    @Override
    public int getDaySum(Random random, Employee barista, int daySum, Coffee coffee) {
        if (baristaExperience(barista)) {
            daySum = getDaySum1(random, daySum, coffee);
        } else {
            daySum = getDaySum2(daySum, coffee);
        }
        return daySum;
    }

    @Override
    public int experienceBarista(Random random, Employee barista, int daySum, Coffee coffee) {
        if (barista.getExperience() > 10) {
            daySum += coffee.getPrice() + random.nextInt(5, 10);
        } else {
            daySum += coffee.getPrice();
        }
        return daySum;
    }

    @Override
    public int getVeg(int veg) {
        veg += 1;
        return veg;
    }

    @Override
    public int getDaySum2(int daySum, Coffee coffee) {
        daySum += coffee.getPrice() + 5;
        return daySum;
    }

    @Override
    public int getDaySum1(Random random, int daySum, Coffee coffee) {
        daySum += (coffee.getPrice() + 5) + random.nextInt(5, 10);
        return daySum;
    }

    @Override
    public boolean baristaExperience(Employee barista) {
        return barista.getExperience() > 10;
    }

    @Override
    public void setMoney(Client client, Coffee coffee) {
        client.setMoney(client.getMoney() - coffee.getPrice());
    }

    @Override
    public boolean milkPresence(Client client, Coffee coffee) {
        return (coffee.isDairyMilk() == true) && (client.isLactoseTolerant() == false);
    }

    @Override
    public void coffeeUpdate1(Map<Coffee, Integer> companyCoffee, Coffee coffee) {
        companyCoffee.put(coffee, companyCoffee.get(coffee) - 1);
    }

    @Override
    public boolean coffeeCheck(Map<Coffee, Integer> companyCoffee, Coffee coffee) {
        return companyCoffee.get(coffee) > 0;
    }

    @Override
    public boolean moneyCheck(Client client, Coffee coffee) {
        return client.getMoney() > coffee.getPrice();
    }

    @Override
    public Coffee getCoffee(List<Coffee> coffees, Random random) {
        return coffees.get(random.nextInt(coffees.size()));
    }

    @Override
    public int getNrOfProducts(Random random) {
        int nrOfProducts;
        nrOfProducts = random.nextInt(1, 4);
        return nrOfProducts;
    }

    @Override
    public Client getClient(Random random, List<Boolean> booleans) {
        return new Client(random.nextInt(100, 200), booleans.get(random.nextInt(booleans.size())));
    }

    @Override
    public int getNrOfClients(Random random) {
        int nrOfClients;
        nrOfClients = random.nextInt(6, 10);
        return nrOfClients;
    }

    @Override
    public List<Boolean> getBooleans() {
        return new ArrayList<>(List.of(true, true, false, true, true));
    }

    @Override
    public Company getCompany(Employee manager, Employee barista, Map<Coffee, Integer> companyCoffee) {
        return new Company(companyCoffee, barista, manager, 0);
    }

    @Override
    public Map<Coffee, Integer> getCoffeeIntegerMap(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte) {
        Map<Coffee, Integer> companyCoffee = new HashMap<>();
        companyCoffee.put(americano, 100);
        companyCoffee.put(espresso, 100);
        companyCoffee.put(cappuccino, 80);
        companyCoffee.put(latte, 80);
        return companyCoffee;
    }

    @Override
    public Employee getBarista(Random random) {
        return new Barista(true, random.nextInt(350, 400), random.nextInt(3, 5));
    }

    @Override
    public Employee getManager(Random random) {
        return new Manager(true, random.nextInt(500, 600), random.nextInt(3, 10));
    }

    @Override
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Override
    public Random getRandom() {
        return new Random();
    }

    @Override
    public List<Coffee> getCoffees(Americano americano, Espresso espresso, Cappuccino cappuccino, Latte latte) {
        return new ArrayList<>(List.of(americano, espresso, cappuccino, latte));
    }

    @Override
    public Latte getLatte() {
        return new Latte(250, "Latte", 100, true);
    }

    @Override
    public Cappuccino getCappuccino() {
        return new Cappuccino(200, "Cappuccino", 95, true);
    }

    @Override
    public Espresso getEspresso() {
        return new Espresso(50, "Espresso", 75, false);
    }

    @Override
    public Americano getAmericano() {
        return new Americano(150, "Americano", 60, false);
    }
}

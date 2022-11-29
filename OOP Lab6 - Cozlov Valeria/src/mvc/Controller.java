package mvc;

import entity.*;
import market.Company;
import market.Employee;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Controller implements ControllerInt {
    ViewInter view = new View();
    ModelInter model = new Model();

    @Override
    public void rule() {
        Americano americano = model.getAmericano();
        Espresso espresso = model.getEspresso();
        Cappuccino cappuccino = model.getCappuccino();
        Latte latte = model.getLatte();
        List<Coffee> coffees = model.getCoffees(americano, espresso, cappuccino, latte);
        Random random = model.getRandom();
        Scanner scanner = model.getScanner();
        Employee manager = model.getManager(random);
        Employee barista = model.getBarista(random);
        Map<Coffee, Integer> companyCoffee = model.getCoffeeIntegerMap(americano, espresso, cappuccino, latte);
        Company company = model.getCompany(manager, barista, companyCoffee);
        List<Boolean> booleans = model.getBooleans();
        int totalSum = 0, monthSum = 0, daySum;
        double income, clearIncome = 0;
        int nrOfClients, nrOfProducts;
        int es = 0, am = 0, cap = 0, lat = 0, veg = 0;
        String stop;
        boolean a = true;
        for (int i = 1; a; i++) {
            daySum = 0;
            view.dayCount(i); //view
            nrOfClients = model.getNrOfClients(random);
            for (int j = 0; j < nrOfClients; j++) {
                Client client = model.getClient(random, booleans);
                nrOfProducts = model.getNrOfProducts(random);
                view.clientComes(client); //view
                for (int k = 0; k < nrOfProducts; k++) {
                    Coffee coffee = model.getCoffee(coffees, random);
                    view.showCosts(coffee); //view
                    view.buyCoffee(companyCoffee, client, coffee);  //view
                    if (model.moneyCheck(client, coffee)) {
                        if (model.coffeeCheck(companyCoffee, coffee)) {
                            model.coffeeUpdate1(companyCoffee, coffee);
                            if (model.milkPresence(client, coffee)) {
                                model.setMoney(client, coffee);
                                daySum = model.getDaySum(random, barista, daySum, coffee);
                                veg = model.getVeg(veg);
                            } else {
                                model.moneyExtract(client, coffee);
                                daySum = model.experienceBarista(random, barista, daySum, coffee);
                            }
                            switch (coffee.getName()) {
                                case "Americano" -> am += 1;
                                case "Cappuccino" -> cap += 1;
                                case "Espresso" -> es += 1;
                                default -> lat += 1;
                            }
                        }
                    }
                }
            }
            monthSum = model.getMonthSum(monthSum, daySum);
            view.border1(); //view
            if (model.monthCheck(i)) {
                model.totalEarn(company, monthSum);
                view.monthStatus(monthSum, i); //view
                float med = model.getMed(monthSum);
                double expendCoffee = model.getExpendCoffee(espresso, es, am, cap, lat);
                double expendMilk = model.getExpendMilk(latte, cap, lat);
                double expendVegMilk = model.getExpendVegMilk(veg);
                double sum1 = model.getSum1(expendCoffee, expendMilk, expendVegMilk);
                double sum2 = model.getSum2(manager, barista);
                view.daylyIncome(med); //view
                Map<Integer, String> stringIntegerMap = model.getIntegerStringMap(es, am, cap, lat);

                view.payments(expendCoffee, expendMilk, expendVegMilk, sum1, sum2);//view
                income = model.getIncome(monthSum, sum1, sum2);
                clearIncome = model.getClearIncome(income, clearIncome);
                view.productsStatistics(income, es, am, cap, lat); //view
                model.coffeeSetUp(americano, espresso, cappuccino, latte, companyCoffee, company);

                List<Integer> integers = model.getIntegers(es, am, cap, lat);
                Integer max = model.getMax(integers);
                Integer min = model.getMin(integers);
                String s1 = model.getS1(stringIntegerMap, max);
                String s2 = model.getS2(stringIntegerMap, min);
                model.experienceChenge(manager, barista);
                view.minMax(s1, s2);//view
                model.addPrice(americano, espresso, cappuccino, latte, s1);
                model.removePrice(americano, espresso, cappuccino, latte, s2);
                view.productsPrice(americano, espresso, cappuccino, latte);//view
                totalSum = model.getTotalSum(totalSum, monthSum);
                monthSum = 0;
                es = 0;
                am = 0;
                cap = 0;
                lat = 0;
                veg = 0;
                //Stop & Final Function
                view.border2();  //view
                stop = view.getString(scanner); //view
                if (model.isEnd(stop)) {
                    view.finalStatistics(totalSum, clearIncome, i); //view
                    a = false;
                }
            }
        }
    }
}
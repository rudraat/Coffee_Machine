package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private long currentCup = 9;
    private long currentWater = 400;
    private long currentMilk = 540;
    private long currentBean = 120;
    private long currentMoney = 550;

    public void buy() {
        System.out.println("What would you like to buy?  1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();

        final int waterEspressoPerCup = 250;
        final int waterLattePerCup = 350;
        final int waterCappuccinoPerCup = 200;
        final int milkLattePerCup = 75;
        final int milkCappuccinoPerCup = 100;
        final int beanEspressoPerCup = 16;
        final int beanLattePerCup = 20;
        final int beanCappuccinoPerCup = 12;
        final int costEspressoPerCup = 4;
        final int costLattePerCup = 7;
        final int costCappuccinoPerCup = 6;

        switch (type) {
            case "1":
                make(waterEspressoPerCup, 0, beanEspressoPerCup, 1, costEspressoPerCup);
                break;
            case "2":
                make(waterLattePerCup, milkLattePerCup, beanLattePerCup, 1, costLattePerCup);
                break;
            case "3":
                make(waterCappuccinoPerCup, milkCappuccinoPerCup, beanCappuccinoPerCup, 1, costCappuccinoPerCup);
                break;
            case "back":
                break;
        }
    }

    private void make(long water, long milk, long bean, long cup, long cost) {

        if (currentWater < water * cup) {
            System.out.println("Sorry,not enough water!");
            return;
        } else if (currentMilk < milk * cup) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else if (currentBean < bean * cup) {
            System.out.println("Sorry, not enough coffee bean!");
            return;
        } else if (currentCup < cup) {
            System.out.println("Sorry, not enough cup!");
            return;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
        }

        currentWater = currentWater - (water * cup);
        currentMilk = currentMilk - (milk * cup);
        currentBean = currentBean - (bean * cup);
        currentCup  = currentCup - cup;
        currentMoney = currentMoney + (cost * cup);
    }


    public void status() {
        System.out.println("The coffee machine has:");
        System.out.println(currentWater + " ml of water");
        System.out.println(currentMilk + " ml of milk");
        System.out.println(currentBean + " of coffee beans");
        System.out.println(currentCup + " of disposable cups");
        System.out.println(currentMoney + "$ of money");
        System.out.println();
    }

    public void fill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        currentWater = currentWater + sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        currentMilk = currentMilk + sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        currentBean = currentBean + sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        currentCup = currentCup + sc.nextInt();
    }

    public void take() {
        System.out.println("I gave you " + currentMoney + "$");
        currentMoney = 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CoffeeMachine cm = new CoffeeMachine();


        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit ): ");
            String userCommand = sc.next();
            switch (userCommand) {
                case "buy":
                    cm.buy();
                    break;
                case "fill":
                    cm.fill();
                    break;
                case "take":
                    cm.take();
                    break;
                case "remaining":
                    cm.status();
                    break;
                case "exit":
                    return;
            }
        }
    }
}
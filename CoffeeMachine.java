package machine;
import java.util.Scanner;




public class CoffeeMachine {
    private static int waterMl = 400;
    private static int milkMl = 540;
    private static int coffeeBeansG = 120;
    private static int disposableCups = 9;
    private static int money = 550;
    static Scanner scanner = new Scanner(System.in);

    public static void displayResources() {
        System.out.println("The coffee machine has:");
        System.out.println(waterMl + " of water");
        System.out.println(milkMl + " of milk");
        System.out.println(coffeeBeansG + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
    public static void makeEspresso (int waterMlNeed, int coffeeBeansGNeed, int moneyCost){
        if (waterMl >= waterMlNeed && coffeeBeansG >= coffeeBeansGNeed && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            waterMl -= waterMlNeed;
            coffeeBeansG -= coffeeBeansGNeed;
            disposableCups -= 1;
            money += moneyCost;
        } else if (waterMl < waterMlNeed){
            System.out.println("Sorry, not enough water!");
        } else if(coffeeBeansG < coffeeBeansGNeed) {
            System.out.println("Sorry, not enough coffee beans!");
        }
    }
    public static void makeLatteAndCappuccino (int waterMlNeed,int milkMlNeed, int coffeeBeansGNeed, int moneyCost){
        if(waterMl >= waterMlNeed && milkMl >= milkMlNeed && coffeeBeansG >= coffeeBeansGNeed && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            waterMl -= waterMlNeed;
            milkMl -= milkMlNeed;
            coffeeBeansG -= coffeeBeansGNeed;
            disposableCups -= 1;
            money += moneyCost;
        } else if (waterMl < waterMlNeed){
            System.out.println("Sorry, not enough water!");
        } else if (milkMl < milkMlNeed) {
            System.out.println("Sorry, not enough milk!");
        } else if(coffeeBeansG < coffeeBeansGNeed) {
            System.out.println("Sorry, not enough coffee beans!");
        }
    }
    public static void takeAction(){
        int moneyTake = money;
        money = 0;
        System.out.println("I gave you $" + moneyTake);
        System.out.println();
    }

    public static void buyAction(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choiceOfDrink = scanner.next();
        switch (choiceOfDrink){
            case "1":
                makeEspresso(250, 16, 4);
                break;
            case "2":
                makeLatteAndCappuccino(350 , 75, 20, 7);
                break;
            case "3":
                makeLatteAndCappuccino(200, 100, 12, 6);
                break;
            case "back":
                break;
        }
    }

    public static void fillAction(){
        System.out.println("Write how many ml of water do you want to add: ");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scanner.nextInt();

        waterMl += addWater;
        milkMl += addMilk;
        coffeeBeansG += addCoffeeBeans;
        disposableCups += addCups;
    }



    public static void main(String[] args) {

        boolean flag = true;

        while(flag) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String chooseAction = scanner.next();
            System.out.println();
            switch (chooseAction){
                case "buy":
                    buyAction();
                    break;
                case "fill":
                    fillAction();
                    break;
                case "take":
                    takeAction();
                    break;
                case "remaining":
                    displayResources();
                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    break;
            }

        }
    }
}

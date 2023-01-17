package SchoolProjects;

import java.util.*;
public class HorseBetting {

    public static class Race {
        int[] array = {1, 2, 3, 4};
        void Race() {
        }void readySetGo() {
            int n = array.length;
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                int randomValue = i + random.nextInt(n - i);
                int randomElement = array[randomValue];
                array[randomValue] = array[i];
                array[i] = randomElement;
            }
        }
        int first() {
            return array[0];
        }
        int second() {
            return array[1];
        }
        int third() {
            return array[2];
        }
        int fourth() {
            return array[3];
        }
        int[] getArray() {
            return array;
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to Horse Betting!");
        System.out.println("Choose an option:");
        System.out.println("    1. Exacta");
        System.out.println("    2. Exacta Box");
        System.out.println("    3. Trifecta");
        System.out.println("    4. Trifecta Box");
        System.out.println("    5. See your USD balance");
        System.out.println("    6. Exit");
    }

    public static void main(String[] args) {
        Race r = new Race();
        double USD = 200.00;
        int h1;
        int h2;
        int h3;
        Scanner S = new Scanner(System.in);
        int choice;
        boolean notDone = true;

        while (notDone) {
            System.out.println("-------------------------------");
            printMenu();
            r.readySetGo();
            for (int value : r.getArray()) {
                System.out.println(value);
            }
            choice = S.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You chose Exacta");
                    System.out.println("Choose two horses");
                    h1 = S.nextInt();
                    h2 = S.nextInt();
                    USD = USD - 10;
                    if ((h1 == r.first()) && (h2 == r.second())) {
                        System.out.println("You won, your USD has increased by $100!");
                        USD = USD + 100;
                    } else{
                        System.out.println("Sorry, you lost :(");
                    }
                    System.out.println("The horses placed:");
                    System.out.println("    First place is " + r.first());
                    System.out.println("    Second place is " + r.second());
                    System.out.println("    Third place is " + r.third());
                    System.out.println("    Fourth place is " + r.fourth());
                    break;
                case 2:
                    System.out.println("You chose Exacta Box");
                    System.out.println("Choose two horses");
                    h1 = S.nextInt();
                    h2 = S.nextInt();
                    USD = USD - 5;
                    if ((h1 == r.first()) && (h2 == r.second()) || (h2 == r.first()) && (h1 == r.second())) {
                        System.out.println("You won, your USD has increased by $50!");
                        USD = USD + 50;
                    } else {
                        System.out.println("Sorry, you lost :(");
                    }
                    System.out.println("The horses placed:");
                    System.out.println("    First place is " + r.first());
                    System.out.println("    Second place is " + r.second());
                    System.out.println("    Third place is " + r.third());
                    System.out.println("    Fourth place is " + r.fourth());
                    break;
                case 3:
                    System.out.println("You chose Trifecta");
                    System.out.println("Choose three horses");
                    h1 = S.nextInt();
                    h2 = S.nextInt();
                    h3 = S.nextInt();
                    USD = USD - 25;
                    if ((h1 == r.first()) && (h2 == r.second()) && (h3 == r.third())) {
                        System.out.println("You won, your USD has increased by $200!");
                        USD = USD + 200;
                    } else {
                        System.out.println("Sorry, you lost :(");
                    }
                    System.out.println("The horses placed:");
                    System.out.println("    First place is " + r.first());
                    System.out.println("    Second place is " + r.second());
                    System.out.println("    Third place is " + r.third());
                    System.out.println("    Fourth place is " + r.fourth());
                    break;
                case 4:
                    System.out.println("You chose Trifecta Box");
                    System.out.println("Choose three horses");
                    h1 = S.nextInt();
                    h2 = S.nextInt();
                    h3 = S.nextInt();
                    USD = USD - 20;
                    if (       (h1 == r.first()) && (h2 == r.second()) && (h3 == r.third())
                            || (h1 == r.first()) && (h3 == r.second()) && (h2 == r.third())
                            || (h2 == r.first()) && (h1 == r.second()) && (h3 == r.third())
                            || (h2 == r.first()) && (h3 == r.second()) && (h1 == r.third())
                            || (h3 == r.first()) && (h1 == r.second()) && (h2 == r.third())
                            || (h3 == r.first()) && (h2 == r.second()) && (h1 == r.third())) {
                        System.out.println("You won, your USD has increased by $150!");
                        USD = USD + 150;
                    } else {
                        System.out.println("Sorry, you lost :(");
                    }
                    System.out.println("The horses placed:");
                    System.out.println("    First place is " + r.first());
                    System.out.println("    Second place is " + r.second());
                    System.out.println("    Third place is " + r.third());
                    System.out.println("    Fourth place is " + r.fourth());
                    break;
                case 5:
                    System.out.println("Your current balance is: $" + USD);
                    break;
                case 6:
                    System.out.println("Have a great day!");
                    notDone = false;
                    break;
            }
            System.out.println("-------------------------------");
            System.out.println(" ");
        }
    }
}
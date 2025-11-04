//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        new Scanner(System.in);
        new Random();
        Runner r1 = new Runner("John", "Mario", 1, 0.01, false);
        Runner r2 = new Runner("Jack", "New Super Mario Bros", 5, 25.4, false);
        Runner r3 = new Runner("Henry", "FNAF SB", 120, 122.5, true);

        List<Runner> Runners = new ArrayList<>();
        Runners.add(r1);
        Runners.add(r2);
        Runners.add(r3);

        for(int choice = Menu(); choice != 0; choice = Menu()) {
            if (choice == 1) {
                AskChange(r1);
                System.out.println(r1.toString());
            }

            else if (choice == 2) {
                AddNumOfRuns(r1);
                System.out.println(r1.toString());
            }

            else if (choice == 3) {
                RunnerNameComparator NameCompare = new RunnerNameComparator();
                Collections.sort(Runners, NameCompare);
                System.out.println(Runners);
            }

            else if (choice == 4) {
                System.out.println(Runners);
            }
        }

    }

    //comunity sccore changer
    public static double AskChange(Runner r) {
        Scanner s = new Scanner(System.in);
        double by = (double)0.0F;
        System.out.println("Would you like to add or take away community score: ");
        String choice = s.nextLine();
        if (choice.equalsIgnoreCase("add")) {
            System.out.println("How Much: ");
            by = (double)s.nextInt();
        } else if (choice.equalsIgnoreCase("take")) {
            System.out.println("How Much: ");
            by = (double)s.nextInt();
            by *= (double)-1.0F;
        }

        return r.RattingChage(by);
    }

    //lets player add a chosen number of runs to player
    public static int AddNumOfRuns(Runner r) {
        Scanner s = new Scanner(System.in);
        System.out.println("Add how many more runs this user has done: ");
        int runs = s.nextInt();
        return r.RunChange(runs);
    }

    //shows the user the menu options
    public static int Menu() {
        Scanner s = new Scanner(System.in);
        int choice = 0;
        System.out.println("What funtion do you wish to run:\n" +
                "0 = exit\n1 = Change Community Rating\n" +
                "2 = add runs\n" +
                "3 = Sort Players\n" +
                "4 = Display Players");
        choice = s.nextInt();
        return choice;
    }

    //player picks what names to display
    public static void NameDisplay(Runner r) {
        Scanner s = new Scanner(System.in);
        System.out.println("What runner do you wish to view: ");
        String name = s.nextLine();
        //int Contained = Runner.DisplayByName(name);
    }

}

//Garryowen stinks

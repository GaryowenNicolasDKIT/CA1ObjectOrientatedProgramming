//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        addRunnerToFile(r1);
        addRunnerToFile(r2);
        addRunnerToFile(r3);



        RunnerFileUtilitlies r = new RunnerFileUtilitlies();

        for (int choice = Menu(); choice != 0; choice = Menu()) {
            List<Runner> RunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
            if (choice == 1) {
                AskChange(r1);
                System.out.println(r1.toString());
            } else if (choice == 2) {
                AddNumOfRuns(r1);
                System.out.println(r1.toString());
            } else if (choice == 3) {
                boolean doneSort = false;
                while (doneSort != true){
                    int sortChoice = sortMenu();
                    if(sortChoice == 1){
                        sortByName();
                    }
                    else if (sortChoice == 2){
                        sortByGame();
                    }
                    else if (sortChoice == 3){
                        sortByRuns();
                    }
                    if(sortChoice == 4){
                        sortByRating();
                    }
                    else if (sortChoice == 5){
                        sortByJoin();
                    }
                    else{
                        doneSort = true;
                    }
                }
            } else if (choice == 4) {
                for (Runner runner : RunnersList) {
                    System.out.println(runner);
                }
            } else if (choice == 5) {

            }
        }

    }

    //Community score changer
    public static double AskChange(Runner r) {
        Scanner s = new Scanner(System.in);
        double by = (double) 0.0F;
        System.out.println("Would you like to add or take away community score: ");
        String choice = s.nextLine();
        if (choice.equalsIgnoreCase("add")) {
            System.out.println("How Much: ");
            by = (double) s.nextInt();
        } else if (choice.equalsIgnoreCase("take")) {
            System.out.println("How Much: ");
            by = (double) s.nextInt();
            by *= (double) -1.0F;
        }

        return r.RatingChange(by);
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
        System.out.println("What function do you wish to run:\n" +
                "0 = Exit \n" +
                "1 = Change Community Rating \n" +
                "2 = Add Runs \n" +
                "3 = Sort Players \n" +
                "4 = Display Players \n" +
                "5 = Add new Runner");
        choice = s.nextInt();
        return choice;
    }

    public static int sortMenu() {
        Scanner s = new Scanner(System.in);
        int choice = 0;
        System.out.println("What sort do you wish to perform:\n" +
                "1 = Sort By Name (Alphabetically) \n" +
                "2 = Sort By Game (Alphabetically) \n" +
                "3 = Sort By Runs (Numerically DESC) \n" +
                "4 = Sort By Rating (Numerically DESC) \n" +
                "5 = Sort By Join Date (Date) \n" +
                "6 = Back To Main Menu");
        choice = s.nextInt();
        return choice;
    }

    //player picks what names to display
    public static void NameDisplay(Runner r) {
        Scanner s = new Scanner(System.in);
        System.out.println("What runner do you wish to view: ");
        String searchName = s.nextLine();
        //int Contained = Runner.DisplayByName(name);
    }

    public static void addRunnerToFile(Runner r1) {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        r.addRunnerRecordToFile("data.txt",", ", r1);
        sortByGame();
        System.out.println("\n Runner Added & List Sorted by Game \n ");
    }

    public static void sortByName() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerNameComparator NameCompare = new RunnerNameComparator();
        Collections.sort(tempRunnersList, NameCompare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Name \n");
    }
    public static void sortByGame() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerGameComparator GameCompare = new RunnerGameComparator();
        Collections.sort(tempRunnersList, GameCompare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Game \n");
    }
    public static void sortByJoin() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerJoinComparator Compare = new RunnerJoinComparator();
        Collections.sort(tempRunnersList, Compare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Game \n");
    }
    public static void sortByRating() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerRatingComparator Compare = new RunnerRatingComparator();
        Collections.sort(tempRunnersList, Compare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Game \n");
    }
    public static void sortByRuns() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerRunsComparator Compare = new RunnerRunsComparator();
        Collections.sort(tempRunnersList, Compare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Game \n");
    }
}



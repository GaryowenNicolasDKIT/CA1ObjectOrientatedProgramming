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
    Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random ran = new Random();


        RunnerFileUtilitlies r = new RunnerFileUtilitlies();

        for (int choice = Menu(); choice != 0; choice = Menu()) {
            List<Runner> RunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
            if (choice == 1) {
                Runner runnerToChange = findRunner();
                System.out.println(AskChange(runnerToChange));
                System.out.println(runnerToChange.toString());
            } else if (choice == 2) {
                Runner runnerToChange = findRunner();
                System.out.println(AddNumOfRuns(runnerToChange));
                System.out.println(runnerToChange.toString());
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
            }

            else if (choice == 5) {
                System.out.println("Please insert the users name: ");
                String newName = s.nextLine();
                System.out.println("Please insert the game they are running: ");
                String newGame = s.nextLine();

                Runner R = new Runner (newName, newGame);
                RunnersList.add(R);
                addRunnerToFile(R);
            }

            //show by certain criteria
            else if (choice == 6) {
                int ShowChoice = DisplaySubMenu();

                while(ShowChoice != 0) {

                    //show all users using a given name
                    if(ShowChoice == 1) {
                        System.out.println(findRunner());
                    }

                    //show all users using given game
                    else if (ShowChoice == 2) {
                        System.out.println("What game do you wish to view: ");
                        String searchGame = s.nextLine();

                        for (int i = 0; i < RunnersList.size(); i++) {
                            if (RunnersList.get(i).getGame().indexOf(searchGame) > -1) {
                                System.out.println(RunnersList.get(i));
                            }
                        }
                    }

                    //show all users who have a world record
                    else if(ShowChoice == 3){
                        for (int i = 0; i < RunnersList.size(); i++) {
                            if (RunnersList.get(i).getHas_World_Record() == true) {
                                System.out.println(RunnersList.get(i));
                            }
                        }
                    }

                    ShowChoice = DisplaySubMenu();
                }
            }

            //counting how many games a player has run
            else if (choice == 7) {
                System.out.println("Please insert the users name you wish to see how many games they've run: ");
                String playerName = s.nextLine();
                String output = NumOfGamesPlayed(playerName, RunnersList);

                System.out.println(output);
            }

            //counting how many people playa certain game
            else if (choice == 8) {
                System.out.println("Please insert the game name you wish to see how many people run: ");
                String GameName = s.nextLine();
                String output = NumOfRunners(GameName, RunnersList);

                System.out.println(output);
            }

            //show all runners hascode
            else if (choice == 9) {
                for (Runner runner : RunnersList) {
                    System.out.println(runner.getName() + " " +  runner.getGame());
                    System.out.println("Their Hashcode: " + runner.hashCode());
                }
            }

            //finding specific entry using hascode
            else if (choice == 10) {
                System.out.println("Please enter hascode: ");
                int hashCode = s.nextInt();

                Runner found = FindRunnerUsingHash(hashCode, RunnersList);
                System.out.println(found);
            }

        }

    }

    //Community score changer
    public static String AskChange(Runner r) {
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

        r.RatingChange(by);
        RunnerFileUtilitlies runF = new RunnerFileUtilitlies();
        runF.updateRunnerRecordInFile("data.txt",", ", r);
        return r.getName() + " now has a rating of " + r.getCommunity_Rating();
    }

    //lets player add a chosen number of runs to player
    public static String AddNumOfRuns(Runner r) {
        System.out.println("Runner = " + r.getName());
        Scanner s = new Scanner(System.in);
        System.out.println("Add how many more runs this user has done: ");
        int runs = s.nextInt();
        System.out.println("Is this run a world record?");
        String e = s.nextLine();
        String wr = s.nextLine();
        if ((wr.equalsIgnoreCase("yes") || wr.equalsIgnoreCase("y")
                || wr.equalsIgnoreCase("no") || wr.equalsIgnoreCase("n")) != true)
                { throw new IllegalArgumentException("Wrong data format"); }
        r.RunChange(runs, wr);
        RunnerFileUtilitlies runF = new RunnerFileUtilitlies();
        runF.updateRunnerRecordInFile("data.txt",", ", r);
        return r.getName() + " now has " + r.getRuns_Amount() + " runs.";
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
                "5 = Add new Runner\n" +
                "6 = Diplay specific users\n" +
                "7 = How many games a player runs\n"+
                "8 = how many players run a a game\n"+
                "9 = show hascode for all runners\n"+
                "10 = find entry using hashcode");
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

    public static Runner findRunner(){
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> RunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        Scanner s = new Scanner(System.in);
        System.out.println("What runner do you wish to view: ");
        String searchName = s.nextLine();

        for (int i = 0; i < RunnersList.size(); i++) {
            if (RunnersList.get(i).getName().contains(searchName)) {
                return RunnersList.get(i);
            }
        }
        return null;

    }

    public static void addRunnerToFile(Runner r1) {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        r.addRunnerRecordToFile("data.txt",", ", r1);
        sortByGame();
        System.out.println("\n Runner Added & List Sorted by Game \n ");
    }

    public static String sortByName() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerNameComparator NameCompare = new RunnerNameComparator();
        tempRunnersList.sort(NameCompare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Name \n");
        return "\n Runners List Sorted By Name \n";
    }
    public static String sortByGame() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerGameComparator GameCompare = new RunnerGameComparator();
        tempRunnersList.sort(GameCompare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Game \n");
        return "\n Runners List Sorted By Game \n";
    }
    public static String sortByJoin() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerJoinComparator Compare = new RunnerJoinComparator();
        tempRunnersList.sort(Compare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Join Date \n");
        return "\n Runners List Sorted By Join Date \n";
    }
    public static String sortByRating() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerRatingComparator Compare = new RunnerRatingComparator();
        tempRunnersList.sort(Compare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Rating \n");
        return  "\n Runners List Sorted By Rating \n";
    }
    public static String sortByRuns() {
        RunnerFileUtilitlies r = new RunnerFileUtilitlies();
        List<Runner> tempRunnersList = r.loadRunnerRecordFromFile("data.txt",", ");
        RunnerRunsComparator Compare = new RunnerRunsComparator();
        tempRunnersList.sort(Compare);
        r.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted By Run Number \n");
        return "\n Runners List Sorted By Run Number \n";
    }

    public static int DisplaySubMenu(){
        Scanner s = new Scanner(System.in);

        System.out.println("What catagory would you like to search users by:\n" +
                           "1: Name\n" +
                           "2: Game\n" +
                           "3: who has a world record\n" +
                           "4: return back to main menu");

        int choice = s.nextInt();


        return choice;
    }

    //counting how many games a player has run
    public static String NumOfGamesPlayed(String name, List<Runner> ListOfPlayers){

        String output = "";
        int gameCounter = 0;
        boolean UserFound = false;
        boolean endLoop = false;
        int counter = 0;
        //temp info to let code run
        Runner a = new Runner("AAAA", "AAAA");

        //test to see if list is being taken into function
        //System.out.println(ListOfPlayers.toString());

        while(!endLoop){

            //test to see if function enters for loop
            //System.out.println("Entered while loop");

            if(name.equals(ListOfPlayers.get(counter).getName())) {

                //test
                //System.out.println("If statment worked");

                a = ListOfPlayers.get(counter);

                //test to see if a is being given a value
                //System.out.println("runner" + a.getName());
                //gameCounter++;
                UserFound = true;
                endLoop = true;
            }

            counter++;

            if(counter == ListOfPlayers.size()){
                endLoop = true;
            }

        }

        //testing if chosen user sticks
        //System.out.println("does chosen user stick \n"+a);
        //testing if bollean sticks
        //System.out.println(UserFound);

        if(UserFound){
            for (int j = 0; j < ListOfPlayers.size(); j++) {


                Runner temp=  ListOfPlayers.get(j);

                String a1 = a.getName();
                String temp1 = temp.getName();

                //test if takes in runner for temp
                //System.out.println(temp.getName());

                if (a1.equals(temp1)) {
                    //temp to see if this code is running
                    System.out.println("is this running or not");

                    gameCounter++;
                }
            }
            output = name + " runs " + gameCounter + " games";
        }

        else{
            output = "User not found";
        }

        return output;

    }

    //counting how many runners a play a game
    public static String NumOfRunners(String game,List<Runner> ListOfPlayers){
        String output = "";
        int PlayerCounter = 0;
        boolean GameFound = false;
        boolean endLoop = false;
        int counter = 0;
        //temp info to let code run
        Runner a = new Runner("AAAA", "AAAA");

        while(!endLoop){

            //test to see if function enters for loop
            //System.out.println("Entered while loop");

            if(game.equals(ListOfPlayers.get(counter).getGame())) {

                //test
                //System.out.println("If statment worked");

                a = ListOfPlayers.get(counter);

                //test to see if a is being given a value
                //System.out.println("runner" + a.getName());
                //PlayerCounter++;
                GameFound = true;
                endLoop = true;
            }

            counter++;

            if(counter == ListOfPlayers.size()){
                endLoop = true;
            }

        }

        if(GameFound){
            for (int j = 0; j < ListOfPlayers.size(); j++) {

                Runner temp=  ListOfPlayers.get(j);

                String a1 = a.getGame();
                String temp1 = temp.getGame();

                //test if takes in runner for temp
                //System.out.println(temp.getName());


                if (a1.hashCode() == temp1.hashCode()) {
                    PlayerCounter++;
                }
            }
            output = game + " has " + PlayerCounter + " player run it";
        }

        else{
            output = "Game not found";
        }

        return output;
    }

    //finding an entry using a hashcode
    public static Runner FindRunnerUsingHash(int hash, List<Runner> ListOfPlayers){
        //temp info to let code run
        Runner a = new Runner("AAAA", "AAAA");

        for (Runner runner : ListOfPlayers) {
            if(hash == runner.hashCode()){
                a = runner;
            }
        }

        return a;
    }
}

//BigBill Deltarune
//Their Hashcode: 1695699884

//BigBill Deltarune
//Their Hashcode: -2035032499



//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class Main {
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random ran = new Random();
        HashMap<Runner, Integer> RunnerProfileIDs = new HashMap<>();
        final LocalDate siteStart = LocalDate.of(2006, 6, 3);

        RunnerFileUtilitlies r = new RunnerFileUtilitlies();


        //Main Menu Loop
        for (int choice = Menu(); choice != 0; choice = Menu()) {
            List<Runner> RunnersList = r.loadRunnerRecordFromFile("data.txt",", ");

            int ID_Counter = 00001;
            for (Runner runner : RunnersList) {
                RunnerProfileIDs.put(runner, ID_Counter);
                ID_Counter++;
            }

            //First Choice
            if (choice == 1) {
                //Calls the find function
                Runner runnerToChange = findRunner();
                System.out.println(AskChange(runnerToChange));
                System.out.println(runnerToChange.toString());
            }
            //Second Choice
            else if (choice == 2) {
                //Calls the runner to alter the run number of
                Runner runnerToChange = findRunner();
                System.out.println(AddNumOfRuns(runnerToChange));
                System.out.println(runnerToChange);
            }
            //Third Choice
            else if (choice == 3) {
                boolean doneSort = false;
                //Sub-menu
                while (doneSort != true){
                    int sortChoice = sortMenu();
                    if(sortChoice == 1){
                        sortBy(new RunnerNameComparator());
                    }
                    else if (sortChoice == 2){
                        sortBy(new RunnerGameComparator());
                    }
                    else if (sortChoice == 3){
                        sortBy(new RunnerRunsComparator());
                    }
                    if(sortChoice == 4){
                        sortBy(new RunnerRatingComparator());
                    }
                    else if (sortChoice == 5){
                        sortBy(new RunnerJoinComparator());
                    }
                    else{
                        doneSort = true;
                    }
                }
            }
            //Fourth Choice
            else if (choice == 4) {
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

            //Show by certain criteria
            else if (choice == 6) {
                int ShowChoice = DisplaySubMenu();

                while(ShowChoice != 0) {

                    //Show all users using a given name
                    if(ShowChoice == 1) {
                        System.out.println(findRunner());
                    }

                    //Show all users using given game
                    else if (ShowChoice == 2) {
                        System.out.println("What game do you wish to view: ");
                        String searchGame = s.nextLine();

                        for (int i = 0; i < RunnersList.size(); i++) {
                            if (RunnersList.get(i).getGame().contains(searchGame)) {
                                System.out.println(RunnersList.get(i));
                            }
                        }
                    }

                    //Show all users who have a world record
                    else if(ShowChoice == 3){
                        for (int i = 0; i < RunnersList.size(); i++) {
                            if (RunnersList.get(i).getHas_World_Record()) {
                                System.out.println(RunnersList.get(i));
                            }
                        }
                    }

                    ShowChoice = DisplaySubMenu();
                }
            }

            //Counting how many games a player has run
            else if (choice == 7) {
                System.out.println("Please insert the users name you wish to see how many games they've run: ");
                String playerName = s.nextLine();
                String output = NumOfGamesPlayed(playerName, RunnersList);

                System.out.println(output);
            }

            //Counting how many people playa certain game
            else if (choice == 8) {
                System.out.println("Please insert the game name you wish to see how many people run: ");
                String GameName = s.nextLine();
                String output = NumOfRunners(GameName, RunnersList);

                System.out.println(output);
            }

            //Show all runners hashcode
            else if (choice == 9) {
                for (Runner runner : RunnersList) {
                    System.out.println(runner.getName() + " " +  runner.getGame());
                    System.out.println("Their Hashcode: " + runner.hashCode());
                }
            }

            //view hashcode of chosen runner
            else if (choice == 10) {
                System.out.println("Enter runner you wish to see hashcode of: ");
                String runnerForHash = s.nextLine();
                findRunnersHash(runnerForHash,  RunnersList);
            }

            //view total hashmap
            else if (choice == 11) {
                System.out.println(RunnerProfileIDs);
            }

            //find specific users ID
            else if (choice == 12) {
                System.out.println("Select Runner: ");
                String RunnerChoice = s.nextLine();

                for(Runner runner : RunnersList){
                    if(runner.getName().equals(RunnerChoice)) {
                        System.out.println(runner);
                        System.out.println("Their ID: " + RunnerProfileIDs.get(runner));
                    }
                }
            }

            else if (choice == 13) {
                System.out.println("Select Runner ID: ");
                int IDchocie = s.nextInt();

                for(Runner runner : RunnersList){
                    if(RunnerProfileIDs.get(runner).equals(IDchocie)) {
                        System.out.println(runner);
                        System.out.println("Their ID: " + RunnerProfileIDs.get(runner));
                    }
                }
            }
            else if (choice == 14){
                System.out.println("Select Date you Wish to Compare");
                System.out.println("(In the format DAY-MONTH-YEAR please)");
                String dateInput = s.nextLine();
                System.out.println("Find Runners made after or before this date?");
                String decision = s.nextLine();
                String[] dateSplit = dateInput.split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateSplit[2]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[0]));
                if (decision.equalsIgnoreCase("before")){
                    RunnerFileUtilitlies.makeResultsFile("RunnersBefore"+date,", ",findBetween(siteStart,date,RunnersList));
                }
                else if (decision.equalsIgnoreCase("after")){
                    RunnerFileUtilitlies.makeResultsFile("RunnersAfter" + date,", ",findBetween(date,LocalDate.now(),RunnersList));
                }
                else{
                    System.out.println("ERROR. PLEASE INPUT BEFORE OR AFTER");
                }
            }
        }

    }

    //Community score changer
    public static String AskChange(Runner r) {
        Scanner s = new Scanner(System.in);
        double by = 0.0F;
        System.out.println("Would you like to add or take away community score: ");
        String choice = s.nextLine();
        if (choice.equalsIgnoreCase("add")) {
            System.out.println("How Much: ");
            by = (double) s.nextInt();
        } else if (choice.equalsIgnoreCase("take")) {
            System.out.println("How Much: ");
            by = (double) s.nextInt();
            by *= -1.0F;
        }

        r.RatingChange(by);
        RunnerFileUtilitlies.updateRunnerRecordInFile("data.txt",", ", r);
        return r.getName() + " now has a rating of " + r.getCommunity_Rating();
    }

    //Lets player add a chosen number of runs to player
    public static String AddNumOfRuns(Runner r) {
        System.out.println("Runner = " + r.getName());
        Scanner s = new Scanner(System.in);
        System.out.println("Add how many more runs this user has done: ");
        int runs = s.nextInt();
        System.out.println("Is this run a world record?");
        String e = s.nextLine();
        String wr = s.nextLine();
        if (!(wr.equalsIgnoreCase("yes") || wr.equalsIgnoreCase("y")
                || wr.equalsIgnoreCase("no") || wr.equalsIgnoreCase("n")))
                { throw new IllegalArgumentException("Wrong data format"); }
        r.RunChange(runs, wr);
        RunnerFileUtilitlies.updateRunnerRecordInFile("data.txt",", ", r);
        return r.getName() + " now has " + r.getRuns_Amount() + " runs.";
    }

    //Shows the user the menu options
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
                "6 = Display specific users\n" +
                "7 = How many games a player runs\n"+
                "8 = how many players run a a game\n"+
                "9 = Show hashcode for all runners\n"+
                "10 = View hashcode of chosen runner\n"+
                "11 = View Hashmap\n"+
                "12 = Find specific users IDs\n"+
                "13 = Find user using ID\n" +
                "14 = Find users within a date");
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
        List<Runner> RunnersList = RunnerFileUtilitlies.loadRunnerRecordFromFile("data.txt",", ");
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
        RunnerFileUtilitlies.addRunnerRecordToFile("data.txt",", ", r1);
        sortBy(new RunnerGameComparator());
        System.out.println("\n Runner Added & List Sorted by Game \n ");
    }


    public static String sortBy(Comparator<Runner> c) {
        List<Runner> tempRunnersList = RunnerFileUtilitlies.loadRunnerRecordFromFile("data.txt",", ");
        tempRunnersList.sort(c);
        RunnerFileUtilitlies.replaceRunnerRecordFile("data.txt",", ", tempRunnersList);
        System.out.println("\n Runners List Sorted \n");
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

    //finding chosen runners hash
    public static void findRunnersHash(String name, List<Runner> ListOfPlayers){
        for (Runner runner : ListOfPlayers) {
            if(name.equals(runner.getName())){
                System.out.println(runner);
                System.out.println("Runners hashcode: " + runner.hashCode());
            }
        }

    }


    public static List<Runner> findBetween (LocalDate lower, LocalDate upper, List<Runner> runners){
        List<Runner> finalRunnerList = new ArrayList<>();
        for (Runner runner : runners){
            if(runner.getJoinDate().isAfter(lower) && runner.getJoinDate().isBefore(upper)){
                finalRunnerList.add(runner);
            }
        }
        return finalRunnerList;
    }


}

//BigBill Deltarune
//Their Hashcode: 1695699884

//BigBill Deltarune
//Their Hashcode: -2035032499



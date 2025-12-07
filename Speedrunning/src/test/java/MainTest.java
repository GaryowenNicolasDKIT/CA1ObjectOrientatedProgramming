import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //add number of runs test

    /*@org.junit.jupiter.api.Test
    public void test2(){
        Main test = new Main();

        String expectedResult = "\n Runners List Sorted By Name \n";
        String Actual = test.sortByName();
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void test3(){
        Main test = new Main();

        String expectedResult = "\n Runners List Sorted By Game \n";
        String Actual = test.sortByGame();
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void test4(){
        Main test = new Main();

        String expectedResult = "\n Runners List Sorted By Join Date \n";
        String Actual = test.sortByJoin();
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void test5(){
        Main test = new Main();

        String expectedResult = "\n Runners List Sorted By Rating \n";
        String Actual = test.sortByRating();
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void test6(){
        Main test = new Main();

        String expectedResult = "\n Runners List Sorted By Run Number \n";
        String Actual = test.sortByRuns();
        assertEquals(expectedResult,Actual);
    }

     */

    //testing counting how many games a player runs
    @org.junit.jupiter.api.Test
    public void test7(){
        Main test = new Main();

        String a = "Josh";
        List<Runner> RunnersList = new ArrayList<Runner>();

        Runner r1 = new Runner("Josh", "Mario");
        Runner r2 = new Runner("Josh", "Kirby");
        Runner r3 = new Runner("Frank", "Mario");

        RunnersList.add(r1);
        RunnersList.add(r2);
        RunnersList.add(r3);

        String expectedResult = "Josh runs 2 games";
        String Actual = test.NumOfGamesPlayed(a,RunnersList);
        assertEquals(expectedResult,Actual);
    }

    //testing counting how many games a player runs
    @org.junit.jupiter.api.Test
    public void test8(){
        Main test = new Main();

        String a = "Simmon";
        List<Runner> RunnersList = new ArrayList<Runner>();

        Runner r1 = new Runner("Josh", "Mario");
        Runner r2 = new Runner("Josh", "Kirby");
        Runner r3 = new Runner("Frank", "Mario");

        RunnersList.add(r1);
        RunnersList.add(r2);
        RunnersList.add(r3);

        String expectedResult = "User not found";
        String Actual = test.NumOfGamesPlayed(a,RunnersList);
        assertEquals(expectedResult,Actual);
    }


    //testing find duplicates
    @org.junit.jupiter.api.Test
    public void test9(){
        Main test = new Main();

        String a = "Simmon";
        List<Runner> RunnersList = new ArrayList<Runner>();

        Runner r1 = new Runner("Josh", "Mario");
        Runner r2 = new Runner("Sam", "Kirby");
        Runner r3 = new Runner("Frank", "Mario");
        Runner r4 = new Runner("Josh", "Mario");

        RunnersList.add(r1);
        RunnersList.add(r2);
        RunnersList.add(r3);
        RunnersList.add(r4);

        HashMap<Runner, Integer> b = new HashMap<>();

        b.put(r1, 1);
        b.put(r2, 2);
        b.put(r3, 3);
        b.put(r4, 4);

        String expectedResult = "1 and 4 are duplicates\n" +
                "4 and 1 are duplicates\n";
        String Actual = test.DuplicateFinder(b);
        System.out.println(Actual);
        assertEquals(expectedResult,Actual);
    }



}
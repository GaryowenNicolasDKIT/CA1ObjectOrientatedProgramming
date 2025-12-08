import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //add number of runs test

    @org.junit.jupiter.api.Test
    public void sortNameTest(){
        Main test = new Main();
        List<Runner> expectedResult = new ArrayList<>();
        List<Runner> actualResult = new ArrayList<>();
        //Creating of 8 Runners
        Runner r1 = new Runner("Aaron","Luigi's Mansion",10,-42.4,false, LocalDate.of(2016,12,5), LocalDateTime.now());
        Runner r2 = new Runner("Baron","Deltarune",46,62.5,true, LocalDate.of(2012,6,20), LocalDateTime.now());
        Runner r3 = new Runner("Daron","Deltarune",79,446.2,false, LocalDate.of(2019,10,30), LocalDateTime.now());
        Runner r4 = new Runner("Carlon","FNAF SB",56,1029.0,true, LocalDate.of(2014,7,23), LocalDateTime.now());
        Runner r5 = new Runner("Aarrron","Luigi's Mansion",4460,-1.8,true, LocalDate.of(2016,11,4), LocalDateTime.now());
        Runner r6 = new Runner("Caron","FNAF SB",9986,67.6,false, LocalDate.of(2012,3,20), LocalDateTime.now());
        Runner r7 = new Runner("Barton","Minecraft",125,42021.2,false, LocalDate.of(2019,9,5), LocalDateTime.now());
        Runner r8 = new Runner("Darlon","Minecraft",3355,6942.0,true, LocalDate.of(2014,6,12), LocalDateTime.now());

        //Adding them in a randomised order to an ArrayList
        actualResult.add(r1);
        actualResult.add(r2);
        actualResult.add(r3);
        actualResult.add(r4);
        actualResult.add(r5);
        actualResult.add(r6);
        actualResult.add(r7);
        actualResult.add(r8);

        //Adding them to a different ArrayList in the correct order
        expectedResult.add(r1);
        expectedResult.add(r5);
        expectedResult.add(r2);
        expectedResult.add(r7);
        expectedResult.add(r4);
        expectedResult.add(r6);
        expectedResult.add(r8);
        expectedResult.add(r3);

        //Creating a file with the unorganised list of Runners
        RunnerFileUtilitlies.replaceRunnerRecordFile("checkData.txt",", ",actualResult);

        //Running the sorting code to update the file to hold everything in the right order
        List<Runner> Actual = Main.sortBy("checkData.txt",new RunnerNameComparator());

        //Comparing the organised list to the outputted list of the sorting code
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void sortGameTest(){
        Main test = new Main();
        List<Runner> expectedResult = new ArrayList<>();
        List<Runner> actualResult = new ArrayList<>();
        //Creating of 8 Runners
        Runner r1 = new Runner("Aaron","Luigi's Mansion",10,-42.4,false, LocalDate.of(2016,12,5), LocalDateTime.now());
        Runner r2 = new Runner("Baron","Deltarune",46,62.5,true, LocalDate.of(2012,6,20), LocalDateTime.now());
        Runner r3 = new Runner("Daron","Deltarune",79,446.2,false, LocalDate.of(2019,10,30), LocalDateTime.now());
        Runner r4 = new Runner("Carlon","FNAF SB",56,1029.0,true, LocalDate.of(2014,7,23), LocalDateTime.now());
        Runner r5 = new Runner("Aarrron","Luigi's Mansion",4460,-1.8,true, LocalDate.of(2016,11,4), LocalDateTime.now());
        Runner r6 = new Runner("Caron","FNAF SB",9986,67.6,false, LocalDate.of(2012,3,20), LocalDateTime.now());
        Runner r7 = new Runner("Barton","Minecraft",125,42021.2,false, LocalDate.of(2019,9,5), LocalDateTime.now());
        Runner r8 = new Runner("Darlon","Minecraft",3355,6942.0,true, LocalDate.of(2014,6,12), LocalDateTime.now());

        //Adding them in a randomised order to an ArrayList
        actualResult.add(r1);
        actualResult.add(r2);
        actualResult.add(r3);
        actualResult.add(r4);
        actualResult.add(r5);
        actualResult.add(r6);
        actualResult.add(r7);
        actualResult.add(r8);

        //Adding them to a different ArrayList in the correct order
        expectedResult.add(r2);
        expectedResult.add(r3);
        expectedResult.add(r4);
        expectedResult.add(r6);
        expectedResult.add(r1);
        expectedResult.add(r5);
        expectedResult.add(r7);
        expectedResult.add(r8);

        //Creating a file with the unorganised list of Runners
        RunnerFileUtilitlies.replaceRunnerRecordFile("checkData.txt",", ",actualResult);

        //Running the sorting code to update the file to hold everything in the right order
        List<Runner> Actual = Main.sortBy("checkData.txt",new RunnerGameComparator());

        //Comparing the organised list to the outputted list of the sorting code
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void sortJoinTest(){
        Main test = new Main();
        List<Runner> expectedResult = new ArrayList<>();
        List<Runner> actualResult = new ArrayList<>();
        //Creating of 8 Runners
        Runner r1 = new Runner("Aaron","Luigi's Mansion",10,-42.4,false, LocalDate.of(2016,12,5), LocalDateTime.now());
        Runner r2 = new Runner("Baron","Deltarune",46,62.5,true, LocalDate.of(2012,6,20), LocalDateTime.now());
        Runner r3 = new Runner("Daron","Deltarune",79,446.2,false, LocalDate.of(2019,10,30), LocalDateTime.now());
        Runner r4 = new Runner("Carlon","FNAF SB",56,1029.0,true, LocalDate.of(2014,7,23), LocalDateTime.now());
        Runner r5 = new Runner("Aarrron","Luigi's Mansion",4460,-1.8,true, LocalDate.of(2016,11,4), LocalDateTime.now());
        Runner r6 = new Runner("Caron","FNAF SB",9986,67.6,false, LocalDate.of(2012,3,20), LocalDateTime.now());
        Runner r7 = new Runner("Barton","Minecraft",125,42021.2,false, LocalDate.of(2019,9,5), LocalDateTime.now());
        Runner r8 = new Runner("Darlon","Minecraft",3355,6942.0,true, LocalDate.of(2014,6,12), LocalDateTime.now());

        //Adding them in a randomised order to an ArrayList
        actualResult.add(r1);
        actualResult.add(r2);
        actualResult.add(r3);
        actualResult.add(r4);
        actualResult.add(r5);
        actualResult.add(r6);
        actualResult.add(r7);
        actualResult.add(r8);

        //Adding them to a different ArrayList in the correct order
        expectedResult.add(r6);
        expectedResult.add(r2);
        expectedResult.add(r8);
        expectedResult.add(r4);
        expectedResult.add(r5);
        expectedResult.add(r1);
        expectedResult.add(r7);
        expectedResult.add(r3);

        //Creating a file with the unorganised list of Runners
        RunnerFileUtilitlies.replaceRunnerRecordFile("checkData.txt",", ",actualResult);

        //Running the sorting code to update the file to hold everything in the right order
        List<Runner> Actual = Main.sortBy("checkData.txt",new RunnerJoinComparator());

        //Comparing the organised list to the outputted list of the sorting code
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void sortRatingTest(){
        Main test = new Main();
        List<Runner> expectedResult = new ArrayList<>();
        List<Runner> actualResult = new ArrayList<>();
        //Creating of 8 Runners

        Runner r1 = new Runner("Aaron","Luigi's Mansion",10,-42.4,false, LocalDate.of(2016,12,5), LocalDateTime.now());
        Runner r2 = new Runner("Baron","Deltarune",46,62.5,true, LocalDate.of(2012,6,20), LocalDateTime.now());
        Runner r3 = new Runner("Daron","Deltarune",79,446.2,false, LocalDate.of(2019,10,30), LocalDateTime.now());
        Runner r4 = new Runner("Carlon","FNAF SB",56,1029.0,true, LocalDate.of(2014,7,23), LocalDateTime.now());
        Runner r5 = new Runner("Aarrron","Luigi's Mansion",4460,-1.8,true, LocalDate.of(2016,11,4), LocalDateTime.now());
        Runner r6 = new Runner("Caron","FNAF SB",9986,67.6,false, LocalDate.of(2012,3,20), LocalDateTime.now());
        Runner r7 = new Runner("Barton","Minecraft",125,42021.2,false, LocalDate.of(2019,9,5), LocalDateTime.now());
        Runner r8 = new Runner("Darlon","Minecraft",3355,6942.0,true, LocalDate.of(2014,6,12), LocalDateTime.now());

        //Adding them in a randomised order to an ArrayList
        actualResult.add(r1);
        actualResult.add(r2);
        actualResult.add(r3);
        actualResult.add(r4);
        actualResult.add(r5);
        actualResult.add(r6);
        actualResult.add(r7);
        actualResult.add(r8);

        //Adding them to a different ArrayList in the correct order
        expectedResult.add(r1);
        expectedResult.add(r5);
        expectedResult.add(r2);
        expectedResult.add(r6);
        expectedResult.add(r3);
        expectedResult.add(r4);
        expectedResult.add(r8);
        expectedResult.add(r7);

        //Creating a file with the unorganised list of Runners
        RunnerFileUtilitlies.replaceRunnerRecordFile("checkData.txt",", ",actualResult);

        //Running the sorting code to update the file to hold everything in the right order
        List<Runner> Actual = Main.sortBy("checkData.txt",new RunnerRatingComparator());

        //Comparing the organised list to the outputted list of the sorting code
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void sortRunsTest(){
        Main test = new Main();
        List<Runner> expectedResult = new ArrayList<>();
        List<Runner> actualResult = new ArrayList<>();
        //Creating of 8 Runners
        Runner r1 = new Runner("Aaron","Luigi's Mansion",10,-42.4,false, LocalDate.of(2016,12,5), LocalDateTime.now());
        Runner r2 = new Runner("Baron","Deltarune",46,62.5,true, LocalDate.of(2012,6,20), LocalDateTime.now());
        Runner r3 = new Runner("Daron","Deltarune",79,446.2,false, LocalDate.of(2019,10,30), LocalDateTime.now());
        Runner r4 = new Runner("Carlon","FNAF SB",56,1029.0,true, LocalDate.of(2014,7,23), LocalDateTime.now());
        Runner r5 = new Runner("Aarrron","Luigi's Mansion",4460,-1.8,true, LocalDate.of(2016,11,4), LocalDateTime.now());
        Runner r6 = new Runner("Caron","FNAF SB",9986,67.6,false, LocalDate.of(2012,3,20), LocalDateTime.now());
        Runner r7 = new Runner("Barton","Minecraft",125,42021.2,false, LocalDate.of(2019,9,5), LocalDateTime.now());
        Runner r8 = new Runner("Darlon","Minecraft",3355,6942.0,true, LocalDate.of(2014,6,12), LocalDateTime.now());

        //Adding them in a randomised order to an ArrayList
        actualResult.add(r1);
        actualResult.add(r2);
        actualResult.add(r3);
        actualResult.add(r4);
        actualResult.add(r5);
        actualResult.add(r6);
        actualResult.add(r7);
        actualResult.add(r8);

        //Adding them to a different ArrayList in the correct order
        expectedResult.add(r1);
        expectedResult.add(r2);
        expectedResult.add(r4);
        expectedResult.add(r3);
        expectedResult.add(r7);
        expectedResult.add(r8);
        expectedResult.add(r5);
        expectedResult.add(r6);

        //Creating a file with the unorganised list of Runners
        RunnerFileUtilitlies.replaceRunnerRecordFile("checkData.txt",", ",actualResult);

        //Running the sorting code to update the file to hold everything in the right order
        List<Runner> Actual = Main.sortBy("checkData.txt",new RunnerRunsComparator());

        //Comparing the organised list to the outputted list of the sorting code
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void sortBetweenPastNow(){
        Main test = new Main();

        List<Runner> expectedResult = new ArrayList<>();
        List<Runner> actualResult = new ArrayList<>();
        //Creating of 8 Runners
        Runner r1 = new Runner("Aaron","Luigi's Mansion",10,-42.4,false, LocalDate.of(2016,12,5), LocalDateTime.now());
        Runner r2 = new Runner("Baron","Deltarune",46,62.5,true, LocalDate.of(2012,6,20), LocalDateTime.now());
        Runner r3 = new Runner("Daron","Deltarune",79,446.2,false, LocalDate.of(2019,10,30), LocalDateTime.now());
        Runner r4 = new Runner("Carlon","FNAF SB",56,1029.0,true, LocalDate.of(2014,7,23), LocalDateTime.now());
        Runner r5 = new Runner("Aarrron","Luigi's Mansion",4460,-1.8,true, LocalDate.of(2016,11,4), LocalDateTime.now());
        Runner r6 = new Runner("Caron","FNAF SB",9986,67.6,false, LocalDate.of(2012,3,20), LocalDateTime.now());
        Runner r7 = new Runner("Barton","Minecraft",125,42021.2,false, LocalDate.of(2019,9,5), LocalDateTime.now());
        Runner r8 = new Runner("Darlon","Minecraft",3355,6942.0,true, LocalDate.of(2014,6,12), LocalDateTime.now());

        //Adding them in a randomised order to an ArrayList
        actualResult.add(r1);
        actualResult.add(r3);
        actualResult.add(r5);
        actualResult.add(r7);

        //Adding them to a different ArrayList in the correct order
        expectedResult.add(r1);
        expectedResult.add(r2);
        expectedResult.add(r4);
        expectedResult.add(r3);
        expectedResult.add(r7);
        expectedResult.add(r8);
        expectedResult.add(r5);
        expectedResult.add(r6);

        //Running the sorting code to update the file to hold everything in the right order
        List<Runner> Actual = Main.findBetween(LocalDate.of(2016,3,19),LocalDate.now(),actualResult);

        //Comparing the organised list to the outputted list of the sorting code
        assertEquals(expectedResult,Actual);
    }

    @org.junit.jupiter.api.Test
    public void sortBetweenStartPast(){
        Main test = new Main();

        List<Runner> expectedResult = new ArrayList<>();
        List<Runner> actualResult = new ArrayList<>();
        //Creating of 8 Runners
        Runner r1 = new Runner("Aaron","Luigi's Mansion",10,-42.4,false, LocalDate.of(2016,12,5), LocalDateTime.now());
        Runner r2 = new Runner("Baron","Deltarune",46,62.5,true, LocalDate.of(2012,6,20), LocalDateTime.now());
        Runner r3 = new Runner("Daron","Deltarune",79,446.2,false, LocalDate.of(2019,10,30), LocalDateTime.now());
        Runner r4 = new Runner("Carlon","FNAF SB",56,1029.0,true, LocalDate.of(2014,7,23), LocalDateTime.now());
        Runner r5 = new Runner("Aarrron","Luigi's Mansion",4460,-1.8,true, LocalDate.of(2016,11,4), LocalDateTime.now());
        Runner r6 = new Runner("Caron","FNAF SB",9986,67.6,false, LocalDate.of(2012,3,20), LocalDateTime.now());
        Runner r7 = new Runner("Barton","Minecraft",125,42021.2,false, LocalDate.of(2019,9,5), LocalDateTime.now());
        Runner r8 = new Runner("Darlon","Minecraft",3355,6942.0,true, LocalDate.of(2014,6,12), LocalDateTime.now());

        //Adding them in a randomised order to an ArrayList
        actualResult.add(r2);
        actualResult.add(r4);
        actualResult.add(r6);
        actualResult.add(r8);

        //Adding them to a different ArrayList in the correct order
        expectedResult.add(r1);
        expectedResult.add(r2);
        expectedResult.add(r4);
        expectedResult.add(r3);
        expectedResult.add(r7);
        expectedResult.add(r8);
        expectedResult.add(r5);
        expectedResult.add(r6);

        //Running the sorting code to update the file to hold everything in the right order
        List<Runner> Actual = Main.findBetween(LocalDate.of(2006,6,3),LocalDate.of(2016,3,21),actualResult);

        //Comparing the organised list to the outputted list of the sorting code
        assertEquals(expectedResult,Actual);
    }

    //testing counting how many games a player runs
    @org.junit.jupiter.api.Test
    public void testGamesPlayed(){
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
    public void testNoUser(){
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
    public void testFindDuplicates(){
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
        assertEquals(expectedResult,Actual);
    }


    
}
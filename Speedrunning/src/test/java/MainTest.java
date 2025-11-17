import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //add number of runs test

    @org.junit.jupiter.api.Test
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
}
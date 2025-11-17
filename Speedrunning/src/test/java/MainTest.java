import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //add number of runs test
    @org.junit.jupiter.api.Test
    public void test1()
    {
        Main test= new Main();

        Runner a = new Runner("Jake","Portal", 55,25.5,true);

        String expectedResult = "Jake now has 55 runs";
        String Actual = test.AddNumOfRuns(a);
        assertEquals(expectedResult,Actual);
    }

}
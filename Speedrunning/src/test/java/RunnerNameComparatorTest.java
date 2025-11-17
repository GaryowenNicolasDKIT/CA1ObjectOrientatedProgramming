import static org.junit.jupiter.api.Assertions.*;

class RunnerNameComparatorTest {
    //testing sort
    @org.junit.jupiter.api.Test
    public void test1()
    {
        RunnerNameComparator test= new RunnerNameComparator();

        Runner a1 = new Runner("Jake","Portal", 55,25.5,true);
        Runner a2 = new Runner("Amy","Dark Souls", 15,15.5,false);

        int expectedResult = 9;
        int Actual = test.compare(a1,a2);
        assertEquals(expectedResult,Actual);
    }

    //testing sort
    @org.junit.jupiter.api.Test
    public void test2()
    {
        RunnerNameComparator test= new RunnerNameComparator();

        Runner a1 = new Runner("Jake","Portal", 55,25.5,true);
        Runner a2 = new Runner("Frank","Tetris", 225,156.5,true);

        int expectedResult = 4;
        int Actual = test.compare(a1,a2);
        assertEquals(expectedResult,Actual);
    }
}
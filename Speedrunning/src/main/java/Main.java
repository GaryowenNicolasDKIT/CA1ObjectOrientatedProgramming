import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Random r = new Random();
        Runner r1 = new Runner("John", "Mario", 1, 0.00001, false);
        System.out.println(r1.toString());
    }

}

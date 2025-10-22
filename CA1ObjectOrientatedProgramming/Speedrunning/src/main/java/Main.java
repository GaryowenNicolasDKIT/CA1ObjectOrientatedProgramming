import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Random r = new Random();
        Runner r1 = new Runner("John", "Mario", 1, 0.01, false);
        int choice = Menu();
        while(choice!=0){
            if(choice==1){
                AskChange(r1);
                System.out.println(r1.toString());
            }

            else if(choice==2){
                AddNumOfRuns(r1);
                System.out.println(r1.toString());
            }

            choice = Menu();
        }
    }

    public static double AskChange(Runner r){
        Scanner s = new Scanner(System.in);
        double by = 0;
        System.out.println("Would you like to add or take away community score: ");
        String choice = s.nextLine();

        if(choice.equalsIgnoreCase("add")){
            System.out.println("How Much: ");
            by = s.nextInt();
        }

        else if(choice.equalsIgnoreCase("take")){
            System.out.println("How Much: ");
            by = s.nextInt();
            by = by * -1.0;
        }

        return r.RattingChage(by);
    }

    public static int AddNumOfRuns(Runner r){
        Scanner s = new Scanner(System.in);
        System.out.println("Add how many more runs this user has done: ");
        int runs = s.nextInt();
        return r.RunChange(runs);
    }

    public static int Menu(){

        Scanner s = new Scanner(System.in);
        int choice = 0;

        System.out.println("What funtion do you wish to run:\n"
                            + "0 = exit\n"
                            + "1 = Change Community Rating\n"
                            + "2 = add runs\n");

        choice = s.nextInt();

        return choice;
    }
}

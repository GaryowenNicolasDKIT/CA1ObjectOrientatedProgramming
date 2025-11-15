import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class RunnerFileUtilitlies {
    public static List<Runner> loadRunnerRecordFromFile(String fileName, String deLimiter) {
        ArrayList<Runner> runnerList = new ArrayList<>();


        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                    String[] data = line.split(deLimiter);

                    if (data.length != 7) { throw new IllegalArgumentException("Wrong data format"); }

                    String name = data[0];
                    String game = data[1];
                    int Runs_Amount = Integer.parseInt(data[2]);
                    double Community_Rating = Double.parseDouble(data[3]);
                    Boolean Has_World_Record = Boolean.parseBoolean(data[4]);
                    LocalDate joinDate = LocalDate.parse(data[5]);
                    LocalDateTime lastSubmission = LocalDateTime.parse(data[6]);

                    Runner runner = new Runner(name, game,  Runs_Amount, Community_Rating, Has_World_Record);
                    runnerList.add(runner);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return runnerList;
    }

    public static void addRunnerRecordToFile(String fileName, String deLimiter, Runner runner) {
        ArrayList<Runner> runnerList = new ArrayList<>();


        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            fileWriter.write(("\n" + runner.getName() + deLimiter + runner.getGame()
                    + deLimiter + runner.getRuns_Amount() + deLimiter +
                    runner.getCommunity_Rating() + deLimiter + runner.getHas_World_Record()
                    + deLimiter + runner.getJoinDate().toString() + deLimiter + runner.getLastSubmission().toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void replaceRunnerRecordFile(String fileName, String deLimiter, List<Runner> runnerList) {

        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            fileWriter.write("");

        } catch (IOException e){
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (int i=0; i<runnerList.size(); i++) {
                if (i!= 0 ){fileWriter.write("\n");}
                fileWriter.write(runnerList.get(i).toStringForList(deLimiter));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateRunnerRecordInFile(String fileName, String deLimiter, Runner runnerToUpdate){
        ArrayList<Runner> tempRunners = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(deLimiter);

                //if (data.length != 7) { throw new IllegalArgumentException("Wrong data format"); }
                if(data[0].equals(runnerToUpdate.getName()) &&  data[1].equals(runnerToUpdate.getGame())) {
                    tempRunners.add(runnerToUpdate);
                }
                else {
                    String name = data[0];
                    String game = data[1];
                    int Runs_Amount = Integer.parseInt(data[2]);
                    double Community_Rating = Double.parseDouble(data[3]);
                    Boolean Has_World_Record = Boolean.parseBoolean(data[4]);
                    LocalDate joinDate = LocalDate.parse(data[5]);
                    LocalDateTime lastSubmission = LocalDateTime.parse(data[6]);

                    Runner runner = new Runner(name, game, Runs_Amount, Community_Rating, Has_World_Record);
                    tempRunners.add(runner);
                }
            }
            replaceRunnerRecordFile(fileName, deLimiter, tempRunners);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileChange {
    // This is the code used to convert the Mockaroo .txt file to use the proper Syntax for DateTime values.
    public static void main(String[] args)
    {
        replaceRunnerRecordFile("MOCK_DATA.csv",",",loadRunnerRecordFromFile("MOCK_DATA.csv",","));
    }
    public static List<String> loadRunnerRecordFromFile(String fileName, String deLimiter) {
        ArrayList<String> runnerList = new ArrayList();

        String line;
        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            while((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(deLimiter);
                String[] changed = data[6].split(" ");
                data[6] = changed[0] + "T"+ changed[1] + ".000000000";
                runnerList.add(data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + ", " + data[4] + ", " + data[5] + ", " +data[6]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return runnerList;
    }


    public static void replaceRunnerRecordFile(String fileName, String deLimiter, List<String> runnerList) {
        try (
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            for(int i = 0; i < runnerList.size(); ++i) {
                if (i != 0) {
                    fileWriter.write("\n");
                }

                fileWriter.write(runnerList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
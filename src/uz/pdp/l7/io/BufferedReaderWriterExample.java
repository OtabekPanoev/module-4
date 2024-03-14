package uz.pdp.l7.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedReaderWriterExample {
    public static void main(String[] args) {


        writer();
//        reader();


    }


    private static void reader() {




        try (
                FileReader fileReader = new FileReader("io/readme.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {


            List<String> collect = bufferedReader.lines().toList();

            for (String string : collect) {
                System.out.println(string);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private static void writer() {
        File file = new File("io/readme1.txt");
        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {

            bufferedWriter.append("used Buffered Writer");
            bufferedWriter.newLine();
            bufferedWriter.append("End");

//            bufferedWriter.flush();
//            bufferedWriter.append("End of End");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package uz.pdp.l7.io;

import java.io.*;

public class FileReaderWriterExample {

    public static void main(String[] args) {

//        input();
        output();

    }


    private static void output() {
        File file = new File("io/readme.txt");
        try (
                FileWriter fileWriter = new FileWriter(file, true)
        ) {

            fileWriter.append("jgjkdwhlqwenlkwernlbrkbr");
//            fileWriter.write("gndsdveqhwj");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void input() {
        File file = new File("io/readme.txt");
        try (
                FileReader fileReader = new FileReader(file)
        ) {

            while (fileReader.ready()) {
                int read = fileReader.read();
                System.out.print((char) read);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

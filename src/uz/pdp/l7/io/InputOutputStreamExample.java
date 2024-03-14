package uz.pdp.l7.io;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class InputOutputStreamExample {
    public static void main(String[] args) {

//        input();
        output();

    }

    private static void output() {

        try (
                FileOutputStream os = new FileOutputStream("io/readme.txt", true)
        ) {

            byte[] bytes = "Salom bu Java G38 а qashqirlari".getBytes();
            System.out.println(Arrays.toString(bytes));
            os.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*FileOutputStream os = null;
        try {
            os = new FileOutputStream("io/readme.txt", true);

            byte[] bytes = "Salom bu Java G38 а qashqirlari".getBytes();
            System.out.println(Arrays.toString(bytes));
            os.write(bytes);

//            os.write(100);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }*/
    }

    private static void input() {
        try {
            FileInputStream is = new FileInputStream("io/readme.txt");

//            int read = is.read();
//            System.out.println((char) read);

//            System.out.println("is.read() = " + (char)is.read());
//            System.out.println("is.read() = " + (char)is.read());
//            System.out.println("is.read() = " + (char)is.read());

           /* StringBuilder str = new StringBuilder();
            int k = 0;
            while (k != -1) {
                k = is.read();
//                System.out.print((char)k);
                str.append((char) k);
            }
            System.out.println(str);*/

            byte[] bytes = is.readAllBytes();
            String string = new String(bytes);
            System.out.println(string);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

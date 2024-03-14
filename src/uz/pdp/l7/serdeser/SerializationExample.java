package uz.pdp.l7.serdeser;

import java.io.*;

public class SerializationExample {

    public static void main(String[] args) {

        write();
        read();

    }

    private static void read() {
        try (
                FileInputStream fileInputStream = new FileInputStream("serdeser/userfile.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {

            User user = (User) objectInputStream.readObject();
            System.out.println(System.identityHashCode(user));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        User user = new User("Adham", 16, "ketmon123");
        System.out.println(System.identityHashCode(user));

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("serdeser/userfile.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

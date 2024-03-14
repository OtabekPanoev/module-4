package uz.pdp.l7.serdeser;

import java.io.*;
import java.util.List;

public class SerializationExample2 {

    public static void main(String[] args) {

        write();
        read();

    }

    @SuppressWarnings("unchecked")
    private static void read() {
        try (
                FileInputStream fileInputStream = new FileInputStream("serdeser/userfile.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {

            List<User> users = (List<User>) objectInputStream.readObject();
            users.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        List<User> users = List.of(
                new User("Adham", 16, "ketmon123"),
                new User("Aziz", 16, "ketmon123"),
                new User("G'olib", 16, "ketmon123")
        );

        try (
                FileOutputStream fileOutputStream = new FileOutputStream("serdeser/userfile.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

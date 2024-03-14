package uz.pdp.l7.nio;

import jdk.dynalink.Operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilesExample {
    public static void main(String[] args) throws IOException {

//        try {
//            Path path = Path.of("nio/readme1.txt");
//            String string = Files.readString(path);
//            System.out.println(string);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Files.writeString(Path.of("nio/readme.txt"), "Balo battar", StandardOpenOption.TRUNCATE_EXISTING);



    }
}

package uz.pdp.l7.nio;

import java.nio.file.Path;

public class PathExample {
    public static void main(String[] args) {
        Path path = Path.of("nio", "readme.txt");

        System.out.println("path.isAbsolute() = " + path.isAbsolute());
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);

        Path normalize = path.toAbsolutePath();
        System.out.println("path.getParent() = " + normalize.getParent().getParent());

    }
}

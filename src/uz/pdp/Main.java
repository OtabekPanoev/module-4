package uz.pdp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    }
}


class A {
    public void m1() throws IOException {
        System.out.println("A");
    }
}

class B extends A {

    @Override
    public void m1() throws RuntimeException {

    }
}

package uz.pdp.l7.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputOutputStreamEx {
    public static void main(String[] args) {


        try(
                FileOutputStream fileOutputStream = new FileOutputStream("");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {

//            bufferedOutputStream.

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

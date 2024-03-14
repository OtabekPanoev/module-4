package uz.pdp.l7.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileExample {

    static int counterFolder = 0;
    static int counterFile = 0;
    public static void main(String[] args) throws IOException {

//        File file = new File("ketmonio/ketmon.txt");
//        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
//
//        System.out.println("file.exists() = " + file.exists());

//        if (!file.exists()) {
//            file.createNewFile();
//        }

//        boolean delete = file.delete();
//        System.out.println(delete);

//        File file = new File("ketmonio/ketmon.txt");
//
//        System.out.println("file.getParent() = " + file.getParent());

//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        System.out.println(file.exists());

        File file = new File("/Users/otabekpanoev");
//        File file = new File("/Users/otabekpanoev/Job/Pdp/Lessons/Module4/module_4/src/uz/pdp/l2");


//        System.out.println("file.exists() = " + file.exists());
//        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());


        files(file);
        System.out.println("counterFolder = " + counterFolder);
        System.out.println("counterFile = " + counterFile);

//        System.out.println(Arrays.toString(files));


    }

    private static void files(File file) {
        File[] files = file.listFiles();

        if (files == null)
            return;

        for (File file1 : files) {
            if (file1.isDirectory()){
                counterFolder++;
                files(file1);
            } else {
                counterFile++;
            }
        }
    }
}

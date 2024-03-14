package uz.pdp.l6;

import java.util.Date;

public class DateExample {
    public static void main(String[] args) {

//        System.out.println(System.currentTimeMillis()); // 1970
//        Date date = new Date();
//        Date date = new Date();
        /*System.out.println(date);

        Date date1 = new Date(0, 10, 0);
        System.out.println(date1);*/

//        long time = date.getTime();


        Date date = new Date(10100);
        Date date1 = new Date(System.currentTimeMillis() - 1000);

        System.out.println("date.after(date1) = " + date.after(date1));
        System.out.println("date1.before(date) = " + date1.before(date));


    }
}

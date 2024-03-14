package uz.pdp.l6;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatExample {
    public static void main(String[] args) {

        Calendar instance = Calendar.getInstance();
//        instance.set(Calendar.DATE, 14);

        System.out.println("instance.get(Calendar.DAY_OF_MONTH) = " + instance.get(Calendar.DAY_OF_WEEK));
        System.out.println("instance.get(Calendar.DAY_OF_Year) = " + instance.get(Calendar.DAY_OF_YEAR));

        Date date = instance.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss 'is after' SS z D");
        String format = simpleDateFormat.format(date);

        System.out.println("format = " + format);
        System.out.println(date);
    }

    public static void m1(String date) { // 2024/12/31
        //
    }
}

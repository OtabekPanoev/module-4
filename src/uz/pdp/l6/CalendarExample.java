package uz.pdp.l6;

import java.util.Calendar;
import java.util.Date;

public class CalendarExample {
    public static void main(String[] args) {

        /*Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);
        Date date = calendar.getTime(); // convert from calendar to Date
        System.out.println(date);

        System.out.println("calendar.getWeekYear() = " + calendar.getWeekYear());
        System.out.println("calendar.getWeeksInWeekYear() = " + calendar.getWeeksInWeekYear());
        System.out.println("calendar.get(Calendar.MONTH) = " + calendar.get(Calendar.MONTH));

//        calendar.add(Calendar.MONTH, 1);
//        System.out.println("calendar.get(Calendar.MONTH) = " + calendar.get(Calendar.MONTH));
////        System.out.println(calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 40);
        System.out.println(calendar.getTime());*/

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.APRIL, 1, 12, 12, 30);
        System.out.println(calendar.getTime());

        calendar.set(Calendar.DATE, 16);

        System.out.println(calendar.getTime());



    }
}

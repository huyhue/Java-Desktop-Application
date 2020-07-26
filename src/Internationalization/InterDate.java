package Internationalization;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Locale;
import java.util.Scanner;

public class InterDate {

    public static void main(String[] args) {
        int region;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("1. Japan");
            System.out.println("2. English");
            System.out.println("3. Germany");
            System.out.println("4. Vietnam");
            System.out.println("5. Exit program");
            System.out.print("Please choose your region: ");
            region = s.nextInt();
            switch (region) {
                case 1:
                    printDate(Locale.JAPAN);
                    break;
                case 2:
                    printDate(Locale.ENGLISH);
                    break;
                case 3:
                    printDate(Locale.GERMANY);
                    break;
                case 4:
                    printDate(new Locale("vi", "VN"));
                    break;
            }
        } while (region != 5);
        
        //code lien quan: Formatting Date/Time…
        System.out.println("-----------------------------------------------------");
        Date today = new Date();
        String timeStr, dateStr;
        Locale locales[] = {Locale.US, Locale.CHINA, Locale.GERMANY,Locale.JAPAN};
        //get time formatter using current locale
        Locale curLocale = Locale.getDefault();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, curLocale);
        timeStr = timeFormatter.format(today);
        System.out.println("Locale: " + curLocale + ": " + timeStr);
        for (Locale locale : locales) {
             DateFormat formatter = DateFormat.getDateTimeInstance(
                     DateFormat.LONG,//date style
                     DateFormat.LONG, //time style
                     locale);
             dateStr = formatter.format(today);
             System.out.println("Locale: " + locale + ": " + dateStr);
        }

        //Code lien quan: Custom Formatting Date/Time…
//        System.out.println("-----------------------------------------------------");
//        Date today = new Date();
//        String dateStr;
//        Locale locales[] = {Locale.US, Locale.CHINA, Locale.GERMANY,Locale.FRENCH, new Locale("vi", "VN")};
//        SimpleDateFormat sdf;
//        for (Locale locale : locales) {
//             sdf = new SimpleDateFormat("EEEE d MMMM yy",locale);
//             dateStr = sdf.format(today);
//             System.out.println(locale + ": " + dateStr);
//        }
    }

    private static void printDate(Locale locale) {
        //Get current date
        Date currentDate = new Date();
        //Date
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        String date = dateFormatter.format(currentDate);
        System.out.println(locale + " : " + date);
        //Time
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        String time = timeFormatter.format(currentDate);
        System.out.println(locale + " : " + time);
        //DateTime
        DateFormat dateTimeFormatter = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String dateTime = dateTimeFormatter.format(currentDate);
        System.out.println(locale + " : " + dateTime);
        //SimpleDateFormat
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("EEEE d MMMM yy", locale);
        String dateStr = sdf.format(currentDate);
        System.out.println(locale + " : " + dateStr);
    }
}

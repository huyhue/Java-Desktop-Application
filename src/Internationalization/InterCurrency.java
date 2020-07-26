package Internationalization;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class InterCurrency {
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
                    printCurrency(Locale.JAPAN);
                    break;
                case 2:
                    printCurrency(Locale.ENGLISH);
                    break;
                case 3:
                    printCurrency(Locale.GERMANY);
                    break;
                case 4:
                    printCurrency(new Locale("vi", "VN"));
                    break;
            }
        } while (region != 5);
       
       //Currency Format
        System.out.println("-----------------------------------------------------");
        Locale locales[] = {Locale.US, Locale.GERMANY,Locale.JAPAN, new Locale("vi", "VN")};
        for (Locale locale : locales) {
             NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
             System.out.println(locale + ": " + currencyFormatter.format(200));
        }
        
    }
    
    private static void printCurrency(Locale locale) {
        float n = 10500.3245F;
        //Currency
        NumberFormat curFormatter = NumberFormat.getCurrencyInstance(locale);
        String currency = curFormatter.format(n);
        System.out.println(currency + " for the locale " + locale);
        //Number
        NumberFormat numFormatter = NumberFormat.getNumberInstance(locale);
        String number = numFormatter.format(n);
        System.out.println(number + " for the locale " + locale);        
    }    
    
}
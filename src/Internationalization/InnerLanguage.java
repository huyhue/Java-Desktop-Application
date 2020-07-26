package Internationalization;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class InnerLanguage {

    public static void main(String[] args) {
        int lang;
        ResourceBundle bundle;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. English");
            System.out.println("2. Vietnamese");
            System.out.println("3. Exit program");
            System.out.print("Please choose your language: ");
            lang = sc.nextInt();
            switch(lang){
                case 1:
                    //Internationalization is package name
                    //MessageBundle is properties file name
                    bundle = ResourceBundle.getBundle("Internationalization.MessageBundle", Locale.US);
                    System.out.println("Message in " + Locale.US + ": " + bundle.getString("greeting"));
                    break;
                case 2:
                    //Changing the default locate to Vietnamese
                    Locale.setDefault(new Locale("vi", "VN"));
                    bundle = ResourceBundle.getBundle("Internationalization.MessageBundle");
                    System.out.println("Message in " + Locale.getDefault() + ": " + bundle.getString("greeting"));
                    break;
                default:
                    return;
            }
        } while (lang != 3);
    }

}

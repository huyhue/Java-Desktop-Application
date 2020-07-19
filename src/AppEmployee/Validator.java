/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppEmployee;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Validator {

    public static boolean checkEmpty(JTextField field, StringBuilder sb, String msg) {
        boolean ok = true;
        if (field.getText().equals("")) {
            sb.append(msg).append("");
            field.setBackground(Color.red);
            ok = false;
        } else {
            field.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean checkAge(JTextField field, StringBuilder sb) {
        boolean ok = true;
        if (!checkEmpty(field, sb, "Tuoi chua nhap. ")) {
            return false;
        }
        try {
            int age = Integer.parseInt(field.getText());
            if (age < 18 || age > 55) {
                sb.append("Tuoi khong hop le (nam ngoai khoang 18 - 55). \n");
                field.setBackground(Color.red);
                ok = false;
            }
        } catch (Exception e) {
            sb.append("Gia tri tuoi khong hop le (phai la gia tri so). \n");
            field.setBackground(Color.red);
            ok = false;
        }
        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean checkSalary(JTextField field, StringBuilder sb) {
        boolean ok = true;
        if (!checkEmpty(field, sb, "Luong chua nhap. ")) {
            return false;
        }
        try {
            double salary = Double.parseDouble(field.getText());
            if (salary < 5000000) {
                sb.append("Luong khong hop le (phai lon hon 5,000,000). \n");
                field.setBackground(Color.red);
                ok = false;
            }
        } catch (Exception e) {
            sb.append("Gia tri luong khong hop le (phai la gia tri so). \n");
            field.setBackground(Color.red);
            ok = false;
        }
        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean checkEmail(JTextField field, StringBuilder sb) {
        boolean ok = true;
        if (!checkEmpty(field, sb, "Email chua nhap. ")) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");

        Matcher matcher = pattern.matcher(field.getText());
        if (!matcher.find()) {
            sb.append("Email khong hop le. \n");
            field.setBackground(Color.red);
            ok = false;
        }
        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }
}

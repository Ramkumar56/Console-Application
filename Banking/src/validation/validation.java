package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {
    public static boolean isValidEmail(String email)
    {
        String regex = "^(.+)@(\\S+)$";
        Pattern p = Pattern.compile(regex);
        if (email == null) {
            return false;
        }
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,12}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }
    public static boolean isValidPhoneNumber(String number)
    {
        String regex = "^\\d{10}$";
        Pattern p = Pattern.compile(regex);
        if (number == null) {
            return false;
        }
        Matcher m = p.matcher(number);
        return m.matches();
    }

    public static boolean isValidPanCard(String panCard) {
        String regex = "[A-Z]{5}{0-9}{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        if (panCard == null) {
            return false;
        }
        Matcher m = p.matcher(panCard);
        return m.matches();
    }

}

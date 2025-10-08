package cz.ictpro.inner_classes.exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1 {
    public static void main(String[] args) {
        UserValidator userValidator = new UserValidator();
        String[] results = userValidator.validateEmails("pb@",
                "@yahoo.com");
        System.out.println(results[0]); // unknown
        System.out.println(results[1]); // unknown
    }
}
class UserValidator {
    public String[] validateEmails(String email, String
            alternativeEmail) {
        class Email {
            private String email;
            public Email(String email) {
                if (email == null || email.isEmpty() ||
                        !validate(email)) {
                    this.email = "unknown";
                } else {
                    this.email = email;
                }
            }
        }
        Email email1 = new Email(email);
        Email email2 = new Email(alternativeEmail);
        return new String[]{email1.email, email2.email};
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean validate(String emailStr) {
        Matcher matcher =
                VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}

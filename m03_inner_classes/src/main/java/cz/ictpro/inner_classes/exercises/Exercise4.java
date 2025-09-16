package cz.ictpro.inner_classes.exercises;

public class Exercise4 {
    public static void main(String[] args) {
        User user = new User();
        user.setName("John", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                return !input.isEmpty() &&
                        Character.isUpperCase(input.charAt(0));
            }
        });
        user.setLastName("Smith", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                return input != null && !input.isEmpty() &&
                        Character.isUpperCase(input.charAt(0));
            }
        });
        user.setAge(20, new Validator<Integer>() {
            @Override
            public boolean validate(Integer input) {
                return input >= 0 && input <= 150;
            }
        });
        user.setLogin("test", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                return input.length() == 10;
            }
        });
        user.setPassword("test", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                return input.contains("!");
            }
        });
        System.out.println(user);
    }
}
interface Validator<T> {
    boolean validate(T input);
}
class User {
    private String name;
    private String lastName;
    private int age;
    private String login;
    private String password;
    public String getName() {
        return name;
    }
    public void setName(String name, Validator<String> validator)
    {
        if (validator.validate(name)) {
            this.name = name;
        }
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName, Validator<String>
            validator) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age, Validator<Integer> validator) {
        if (validator.validate(age)) {
            this.age = age;
        }
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login, Validator<String>
            validator) {
        if (validator.validate(login)) {
            this.login = login;
        }
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password, Validator<String>
            validator) {
        if (validator.validate(password)) {
            this.password = password;
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package cz.ictpro.functional_programming.lesson;

public class LambdaExample1 {
    public static void main(String[] args) {

        Action action1 = new Action() {
            @Override
            public String execute(int x, int y) {
                return x + "-" + y;
            }
        };
        System.out.println(action1.execute(1, 2));

        Action action2 = (int x, int y) -> {
            return x + "-" + y;
        };
        System.out.println(action2.execute(10, 20));

        Action action3 = (x, y) -> x + "-" + y;
        System.out.println(action3.execute(100, 200));

    }

    public interface Action {
        String execute(int x, int y);
    }
}

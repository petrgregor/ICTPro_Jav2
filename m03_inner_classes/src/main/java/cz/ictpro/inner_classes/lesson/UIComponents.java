package cz.ictpro.inner_classes.lesson;

public class UIComponents {
    void showComponents() {
        // an anonymous class implementation using the new keyword
        ClickListener buttonClick = new ClickListener() {
            @Override
            public void onClick() {
                System.out.println("On Button click!");
            }
        };
        // end of anonymous class implementation

        buttonClick.onClick();

        // an anonymous class implementation using lambda
        // this is possible because ClickListener is a functional interface, ie it has one method to implement
        ClickListener checkboxClick  = () -> System.out.println("On Checkbox click!");
        checkboxClick.onClick();
    }

    void showComponentsV2() {
        // anonymous class implementation
        ClickListener buttonClick = new ClickListener() {

            private String name; // field in anonymous class
            private static final String BUTTON_CLICK_MESSAGE ="On Button click!"; // static field in anonymous class

            public void sayHello() { // method implementation in anonymous class
                System.out.println("I am new method in anonymous class");
            }

            @Override
            public void onClick() {
                sayHello();
                System.out.println(BUTTON_CLICK_MESSAGE);
            }
        };

    }
}

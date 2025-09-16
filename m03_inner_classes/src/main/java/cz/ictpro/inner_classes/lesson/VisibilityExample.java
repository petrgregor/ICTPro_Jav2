package cz.ictpro.inner_classes.lesson;

public class VisibilityExample {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        final OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.useOuterClassField();

        // OuterClass.InnerStaticClass innerStaticClass = new OuterClass.InnerStaticClass();
    }
}

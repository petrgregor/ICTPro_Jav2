package cz.ictpro.inner_classes.lesson;

public class OuterClass {

        private static int outerClassStaticField;
        private int outerClassField;

        void outerClassMethod() {
            System.out.println("I am outer class method");
        }

        public class InnerClass {
            void useOuterClassField() {
                System.out.println(outerClassStaticField); // use of a static field
                outerClassMethod();                        // use of method
                System.out.println(outerClassField);       // use of private field
            }
        }
    }

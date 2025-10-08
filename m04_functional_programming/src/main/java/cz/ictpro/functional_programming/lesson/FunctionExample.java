package cz.ictpro.functional_programming.lesson;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        /*
        We are creating an implementation of the Function interface using a unary lambda
        that returns the value of the name field in the Employee object.
        Since this lambda consists of one expression, we don't have to write the return keyword.
         */
        //Function<Employee, String> employeeToString = (employee) -> employee.getName();
        Function<Employee, String> employeeToString = Employee::getName;

        List<Employee> employees = Arrays.asList(new Employee("Adam"), new Employee("Bronislav"));
        showEmployee(employees, employeeToString);
    }

    static void showEmployee(List<Employee> employees, Function<Employee, String> showFunction) {
        for (Employee employee : employees) {
            System.out.println(showFunction.apply(employee));;
        }
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}


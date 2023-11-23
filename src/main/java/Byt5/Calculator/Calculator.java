package Byt5.Calculator;

public class Calculator {
    public static void main(String[] args) {
        Operations addition = new Addition();
        Operations subtraction = new Subtraction();
        Operations multiplication = new Multiplication();
        Operations division = new Division();

        addition.setNext(subtraction);
        subtraction.setNext(multiplication);
        multiplication.setNext(division);

        addition.operation(10, 5, "+");
        addition.operation(10, 0, "-");
        addition.operation(10, 2, "*");
        addition.operation(10, 5, "/");
    }
}
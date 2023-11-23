package Byt5.Calculator;

interface Operations {
    void setNext(Operations next);

    void operation(double num1, double num2, String operation);
}
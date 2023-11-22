package Calculator;

class Multiplication implements Operations {
    private Operations next;

    @Override
    public void setNext(Operations next) {
        this.next = next;
    }

    @Override
    public void operation(double num1, double num2, String operation) {
        if ("*".equals(operation)) {
            double result = num1 * num2;
            System.out.println(num1 + " * " + num2 + " = " + result);
        } else if (next != null) {
            next.operation(num1, num2, operation);
        } else {
            System.out.println("Try again multiplication");
        }
    }
}
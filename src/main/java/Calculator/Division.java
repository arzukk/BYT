package Calculator;

class Division implements Operations {
    private Operations next;

    @Override
    public void setNext(Operations next) {
        this.next = next;
    }

    @Override
    public void operation(double num1, double num2, String operation) {
        if ("/".equals(operation)) {
            if (num2 != 0) {
                double result = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + result);
            } else {
                System.out.println("Cannot divide by zero");
            }
        } else if (next != null) {
            next.operation(num1, num2, operation);
        } else {
            System.out.println("Try again division");
        }
    }
}

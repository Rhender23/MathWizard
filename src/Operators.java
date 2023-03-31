/**
 * Operators enum provides the possible operations that can be performed in the calculator.
        Each operation has calculates from the first and second input and returns the result.
        */
public enum Operators {
    ADD("+") {
        @Override
        public double calculate(double first, double second) {
            return first + second;
        }
    },
    SUBTRACT("-") {
        @Override
        public double calculate(double first, double second) {
            return first - second;
        }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double first, double second) {
            return first * second;
        }
    },
    DIVIDE ("/"){
        @Override
        public double calculate(double first, double second) {
            if (second == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed");
            }
            return first / second;
        }
    },
    POWER ("^"){
        @Override
        public double calculate(double first, double second) {
            return Math.pow(first, second);
        }
    },
    ROOT ("r"){
        @Override
        public double calculate(double first, double second) {
            if (second == 0) {
                throw new IllegalArgumentException("Root zero is not allowed");
            }
            return Math.pow(first, 1.0 / second);
        }
    },
    MODULUS ("%"){
        @Override
        public double calculate(double first, double second) {
            if (second == 0) {
                throw new IllegalArgumentException("Cannot divide by zero.");
            }
            return first % second;
        }
    };
    private final String symbol;

    Operators(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operators onlySymbol(String symbol) {
        for (Operators op : values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operator symbol");
    }

    public abstract double calculate(double first, double second);
}
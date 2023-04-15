/**
 * Operators enum provides the possible operations that can be performed in the calculator.
        Each operation has calculates from the first and second input and returns the result.
        */
public enum Operators {
    ADD("+") {
        @Override
        public double calculate(double inputNumberOperand, double inputNumberOperator) {
            return inputNumberOperand + inputNumberOperator;
        }
    },
    SUBTRACT("-") {
        @Override
        public double calculate(double inputNumberOperand, double inputNumberOperator) {
            return inputNumberOperand - inputNumberOperator;
        }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double inputNumberOperand, double inputNumberOperator) {
            return inputNumberOperand * inputNumberOperator;
        }
    },
    DIVIDE("/") {
        @Override
        public double calculate(double inputNumberOperand, double inputNumberOperator) {
            return inputNumberOperand / inputNumberOperator;
        }
    },
    POWER("^") {
        @Override
        public double calculate(double inputNumberOperand, double inputNumberOperator) {
            return Math.pow(inputNumberOperand, inputNumberOperator);
        }
    },
    ROOT("r") {
        @Override
        public double calculate(double inputNumberOperand, double inputNumberOperator) {
            return Math.pow(inputNumberOperand, 1.0 / inputNumberOperator);
        }
    },
    MODULUS("%") {
        @Override
        public double calculate(double inputNumberOperand, double inputNumberOperator) {
            return inputNumberOperand % inputNumberOperator;
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
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        return null;
    }
    public abstract double calculate ( double inputNumberOperand, double inputNumberOperator);
}

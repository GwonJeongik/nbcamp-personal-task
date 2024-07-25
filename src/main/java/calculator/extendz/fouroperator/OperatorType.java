package calculator.extendz.fouroperator;

/**
 * 1. 현재 사칙연산 계산기는 +, -, *, /, % 이렇게 총 5가지 연산 타입으로 구성되어있습니다.
 *     - Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.
 */

public enum OperatorType {

    // MODULO -> 나눗셈의 나머지를 계산하는 수학적 연산
    ADD("+", new AddOperate()),
    SUBTRACT("-", new SubtractOperate()),
    MULTIPLY("*", new MultiplyOperate()),
    DIVIDE("/", new DivideOperate()),
    MODULO("%", new ModOperate());

    private final String operator;
    private final Operate operate;

    OperatorType(String operator, Operate operate) {
        this.operator = operator;
        this.operate = operate;
    }

    public String getOperator() {
        return operator;
    }

    public Operate getOperate() {
        return operate;
    }
}

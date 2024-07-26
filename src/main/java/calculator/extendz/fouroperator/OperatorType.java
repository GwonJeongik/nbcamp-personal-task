package calculator.extendz.fouroperator;

/**
 * 1. 현재 사칙연산 계산기는 +, -, *, /, % 이렇게 총 5가지 연산 타입으로 구성되어있습니다.
 *     - Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.
 */

public enum OperatorType {

    // MODULO -> 나눗셈의 나머지를 계산하는 수학적 연산
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODULO("%");

    private final String operator;


    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}

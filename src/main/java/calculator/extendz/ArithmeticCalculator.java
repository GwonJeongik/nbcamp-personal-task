package calculator.extendz;

import calculator.Calculator;
import calculator.extendz.fouroperator.*;

/**
 * 1. 스위치 -> 결과 반환x -> operate만 반환 -> 연산자만 반환
 * 2. 반환된 연산자를 이용해서
 */

public class ArithmeticCalculator extends Calculator {

    /**
     * 산술 계산 기능은 산술 계산기에 담음.
     * 조회, 삭제, 저장배열은 부모에게 있음.
     */

    public double calculate(int firstNum, int secondNum, String operator) {

        double result;

        // 작업1 두 수 모두 양수 확인
        if (isNotPositive(firstNum, secondNum)) {
            throw new RuntimeException("firstNum = " + firstNum + ", secondNum = " + secondNum + ", 두 수 모두 양수여야 합니다.");
        }

        // 작업2 연산할 operate 반환
        Operate operate = checkOperate(secondNum, operator);

        // 작업3 계산 처리
        result = operate.operate(firstNum, secondNum);
        getResults().add(result);
        return result;
    }

    private Operate checkOperate(int secondNum, String operator) {
        switch (operator) {

            case "+":
                return new AddOperate();

            case "-":
                return new SubtractOperate();

            case "*":
                return new MultiplyOperate();

            case "/":
                if (secondNum == 0) {
                    throw new RuntimeException("입력된 분모(secondNum)는 " + secondNum + "입니다. 0으로 나눌 수 없습니다.");
                } else {
                    return new DivideOperate();
                }

            case "%":
                return new ModOperate();

            default:
                throw new RuntimeException("[" + operator + "]" + "은 연산기호가 아닙니다.");
        }
    }

    private boolean isNotPositive(int firstNum, int secondNum) {
        return !(firstNum >= 0 && secondNum >= 0);
    }
}

package calculator.extendz;

import calculator.Calculator;
import calculator.extendz.fouroperator.*;

/**
 * 1. 스위치 -> 결과 반환x -> operate만 반환 -> 연산자만 반환
 * 2. 반환된 연산자를 이용해서
 */

public class ArithmeticCalculator extends Calculator {
    AddOperate addOperate;
    SubtractOperate subtractOperate;
    MultiplyOperate multiplyOperate;
    DivideOperate divideOperate;

    public ArithmeticCalculator() {

        this.addOperate = new AddOperate();
        this.subtractOperate = new SubtractOperate();
        this.multiplyOperate = new MultiplyOperate();
        this.divideOperate = new DivideOperate();
    }

    /**
     * 산술 계산 기능은 산술 계산기에 담음.
     * 조회, 삭제, 저장배열은 부모에게 있음.
     */

    public double calculate(int firstNum, int secondNum, String operator) {


        // 작업1
        if (isNotPositive(firstNum, secondNum)) {
            throw new RuntimeException("firstNum = " + firstNum + ", secondNum = " + secondNum + ", 두 수 모두 양수여야 합니다.");
        }

        double result;

        // 작업2
        switch (operator) {

            case "+":
                result = addOperate.operate(firstNum, secondNum);
                break;

            case "-":
                result = subtractOperate.operate(firstNum, secondNum);
                break;

            case "*":
                result = multiplyOperate.operate(firstNum, secondNum);
                break;

            case "/":
                if (secondNum == 0) {
                    throw new RuntimeException("입력된 분모(secondNum)는 " + secondNum + "입니다. 0으로 나눌 수 없습니다.");
                } else {
                    result = divideOperate.operate(firstNum, secondNum);
                    break;
                }

            default:
                throw new RuntimeException("[" + operator + "]" + "은 연산기호가 아닙니다.");
        }

        // 작업3
        getResults().add(result);
        return result;
    }

    private boolean isNotPositive(int firstNum, int secondNum) {
        return !(firstNum >= 0 && secondNum >= 0);
    }
}

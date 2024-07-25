package calculator.extendz;

import calculator.Calculator;

public class ArithmeticCalculator extends Calculator {


    // 산술 계산 기능은 산술 계산기에
    public double calculate(int firstNum, int secondNum, String operator) {

        if (isNotPositive(firstNum, secondNum)) {
            throw new RuntimeException("firstNum = " + firstNum + ", secondNum = " + secondNum + ", 두 수 모두 양수여야 합니다.");
        }

        double result;

        switch (operator) {

            case "+":
                result = firstNum + secondNum;
                break;

            case "-":
                result = firstNum - secondNum;
                break;

            case "*":
                result = firstNum * secondNum;
                break;

            case "/":
                if (secondNum == 0) {
                    throw new RuntimeException("입력된 분모(secondNum)는 " + secondNum + "입니다. 0으로 나눌 수 없습니다.");
                } else {
                    result = firstNum / (double) secondNum;
                    break;
                }

            default:
                throw new RuntimeException("[" + operator + "]" + "은 연산기호가 아닙니다.");
        }

        getResults().add(result);
        return result;
    }

    private static boolean isNotPositive(int firstNum, int secondNum) {
        return !(firstNum >= 0 && secondNum >= 0);
    }
}

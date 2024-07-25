package calculator;

import java.util.ArrayList;

/**
 * 1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후
 * 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
 * - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다.
 * (매개변수로 해당 오류 내용을 전달합니다.)
 */

public class Calculator {

    //매개변수로 해당 오류 내용을 전달하라는 게 뭔말이지?

    private final ArrayList<Double> list = new ArrayList<>();

    public double calculate(int firstNum, int secondNum, String operator) {

        if (isNotPositive(firstNum, secondNum)) {
            throw new RuntimeException("양수가 아닙니다.");
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

        list.add(result);
        return result;
    }

    private static boolean isNotPositive(int firstNum, int secondNum) {
        return !(firstNum >= 0 && secondNum >= 0);
    }


}

package calculator;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후
 * 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
 * - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다.
 * (매개변수로 해당 오류 내용을 전달합니다.)
 * <p>
 * 2. Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정합니다.
 * - 연산 수행 역할은 Calculator 클래스가 담당합니다.
 * - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장됩니다.
 * - 소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작해야합니다.
 * <p>
 * 3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
 * - 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
 * - 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드)
 * - 위 요구사항을 모두 구현 했다면 App 클래스의 main 메서드에서 위에서 구현한 메서드를 활용 해봅니다.
 * <p>
 * 4. Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후---
 * ---App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정합니다.
 * <p>
 * 5. Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현한 후---
 * ---App 클래스의 main 메서드에 조회 메서드가 활용될 수 있도록 수정합니다.
 * <p>
 * 6. Calculator 인스턴스를 생성(new)할 때 생성자를 통해 연산 결과를 저장하고 있는 컬렉션 필드가 초기화 되도록 수정합니다.
 */

public class Calculator {

    //매개변수로 해당 오류 내용을 전달하라는 게 뭔말이지?

    private final ArrayList<Double> results;

    public Calculator(ArrayList<Double> results) {
        this.results = results;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public Double setResults(int index, double setNum) {
        return results.set(index, setNum);
    }

    public Double removeFirst() {
        return results.remove(0);
    }

    public void findAll() {
        for (Double result : results) {
            System.out.print("[" + result + "] ");
        }
        System.out.println();
    }


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

        results.add(result);
        return result;
    }

    private static boolean isNotPositive(int firstNum, int secondNum) {
        return !(firstNum >= 0 && secondNum >= 0);
    }


}

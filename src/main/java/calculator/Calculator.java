package calculator;

import java.util.ArrayList;

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
 * <p>
 * 7. Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현합니다. v
 * - APP 클래스의 main 메서드에 Scanner를 활용하여 사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력 받은 후
 *   원의 넓이를 구하는 것을 선택했을 때, 원의 반지름을 입력 받아 원의 넓이를 구한 후 출력되도록 구현합니다. v
 * - 기존에 구현되어있던 사칙연산 기능은 수정 후에도 반드시 이전과 동일하게 동작해야합니다. v
 * - 이때, static, final 키워드를 활용할 수 있는지 고민한 후 활용 해봅니다.
 * - 반드시 static, final 키워드에 대한 설명과 활용한 이유에 대해 주석으로 작성합니다.
 * - 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성 v
 * - 계산된 원의 넓이를 저장합니다. v
 * - 생성자로 초기화됩니다. v
 * - 외부에서 직접 접근할 수 없습니다. v
 * - Getter, Setter 메서드를 구현합니다. v
 * - 원의 넓이 결과값들을 조회하는 메서드를 구현합니다. v
 */

//매개변수로 해당 오류 내용을 전달하라는 게 뭔말이지?
public class Calculator {


    // final static은 사용할 수 없다. -> 사용하려면 생성자 주입을 빼야한다. ->
    // static은 자바가 띄어지면서 메서드 영역에 등록 -> final이 붙다보니 필드 선언 시 초기화 필수.
    // final: null값으로 초기화 되면 변경 불가하기 때문에 필드 선언 시 초기화가 필수가 된다.

    // 그러면 난 final을 왜 넣었지? -> 결과값을 저장하는 두 자료구조의 참조가 중간에 변하지 않도록 final로 설정함. ->
    // 현재 두 자료구조 모두 private로 막혀있고 자료구조의 setter는 없음. -> 하지만 getter로 자료구조를 받아서 다른 참조를 넣을 수 있음 ->
    // 결국 누구라도 자료구조의 참조를 변경할 수 있음 -> 이것을 방지하기 위한 final.
    // 다만, 새로운 인스턴스 생성시 새로운 참조값으로 자료구조도 새롭게 생성.

    // static만 붙인다면? -> 생성자로 받을 수는 있지만 의미가 없음. -> 새로운 인스턴스 만들 때마다 새로운 참조가 들어가니까 의미x ->
    // 생성자로 새로운 참조값을 넣어버리면 현재까지 넣어놨던 값들이 날아감.

    // ==========정리==========
    // 결과적으로 현재 만들어 놓은 생성자를 없애고 final static 키워드를 이용해서 자료구조를 사용할 수는 있음. ->
    // 새로운 Calculator 인스턴스를 생성해도 자료구조에 추가된 값은 보존 상태.
    // 하지만, 인스턴스마다 자료구조를 새로 만들어서 사용하고 싶다면 -> final로 선언해서 참조를 변경할 수 없게 막아놔야함. -> 불상사 방지...

    private final ArrayList<Double> areas;
    private final ArrayList<Double> results;

    public Calculator(ArrayList<Double> results, ArrayList<Double> areas) {
        this.results = results;
        this.areas = areas;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public double setResults(int index, double setNum) {
        return results.set(index, setNum);
    }

    public ArrayList<Double> getAreas() {
        return areas;
    }

    public double setAreas(int index, double setArea) {
        return areas.set(index, setArea);
    }

    public Double removeFirst() {
        return results.remove(0);
    }

    public void findAllResults() {
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

    public double calculationArea(int radius) {
        double area = (radius * radius * Math.PI);
        areas.add(area);
        return area;
    }

    public void findAllAreas() {
        for (Double area : areas) {
            System.out.print("[" + area + "] ");
        }
        System.out.println();
    }

    private static boolean isNotPositive(int firstNum, int secondNum) {
        return !(firstNum >= 0 && secondNum >= 0);
    }

}

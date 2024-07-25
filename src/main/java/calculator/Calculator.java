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
 * 원의 넓이를 구하는 것을 선택했을 때, 원의 반지름을 입력 받아 원의 넓이를 구한 후 출력되도록 구현합니다. v
 * - 기존에 구현되어있던 사칙연산 기능은 수정 후에도 반드시 이전과 동일하게 동작해야합니다. v
 * - 이때, static, final 키워드를 활용할 수 있는지 고민한 후 활용 해봅니다.
 * - 반드시 static, final 키워드에 대한 설명과 활용한 이유에 대해 주석으로 작성합니다.
 * - 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성 v
 * - 계산된 원의 넓이를 저장합니다. v
 * - 생성자로 초기화됩니다. v
 * - 외부에서 직접 접근할 수 없습니다. v
 * - Getter, Setter 메서드를 구현합니다. v
 * - 원의 넓이 결과값들을 조회하는 메서드를 구현합니다. v
 * <p>
 * 9. ArithmeticCalculator 클래스의 연산 메서드에 책임(역할)이 많아 보입니다.
 * *    사칙연산 각각의 기능을 담당하는 AddOperator, SubtractOperator, MultiplyOperator, DivideOperator 클래스를 만들어,
 * *    연산 메서드의 책임을 분리 해봅니다. (SRP) v
 * *     - Calculator 클래스에 사칙연산 클래스들을 어떻게 활용할 수 있을지 고민 해봅니다. (포함 관계)
 * *     - 활용 방법을 찾아 적용했을 때 사칙연산 클래스들을 초기화 해야하는데 이때, 반드시 생성자를 활용해 봅니다.
 * *     - 마찬가지로 ArithmeticCalculator 클래스의 연산 메서드를 수정 하더라도 이전과 똑같이 동작해야합니다.
 */

//매개변수로 해당 오류 내용을 전달하라는 게 뭔말이지?
public class Calculator {

    /**
     * calculator를 상속받는 클래스는 결과 저장소, 조회 기능을 공통으로 가져갈 수 있다.
     */

    private final ArrayList<Double> results;

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public void findAllResults() {
        for (Double result : results) {
            System.out.print("[" + result + "] ");
        }
        System.out.println();
    }

    public Double removeFirst() {
        return results.remove(0);
    }
}

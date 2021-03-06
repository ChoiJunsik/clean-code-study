1. KISS 원칙
   - Keep It Short and Simple
   
2. DRY (Do not Repeat Yourself)
    - 중복을 최소화하라
   
3. SRP (하나의 클래스/메소드는 하나의 책임, 변경도 하나의 이유로)
    - God Class 를 만들지마라
    - 큰 문제를 작은 문제로 분해하여 SRP 를 적용하라

4. 응집도
   - 서로 어떻게 관련되어 있는지 (클래스나 메소드의 책임이 서로 얼마나 강결합 되어있는지 측정)
   - 클래스 내부 메소드 간의 연관성 => 그룹화가 중요

5. 결합도
   - 한 기능이 다른 클래스에 얼마나 의존하고 있는지를 가늠
   - 어떤 클래스를 구현하는데 얼마나 다른 클래스를 참조했는가로 설명
   - 많은 클래스를 참조했다면 기능 변경시 유연성이 떨어진다
   - 인터페이스를 통해 결합도를 낮출 수 있다

6. OCP (개방/폐쇄 원칙)
   - 코드 베이스에 유연성을 추가하고 유지보수성을 개선하는데 도움
   - 기존 코드를 바꾸지 않으므로 기존 코드가 잘못될 가능성이 줄어든다
   - 코드 중복을 없애고 재사용성을 높인다

7. God Interface 를 피하자
   - 모든 연산이 명시적인 API 정의에 포함, 인터페이스의 변경은 코드의 변경
   - 도메인 객체의 특정 접근자에 종속 되는 문제 발생, 객체 세부 내용이 바뀌면 인터페이스도 바뀌어야함
   - 작은 인터페이스를 지향 => 지나친 세밀함은 안티 응집도 문제 발생

8. 결과값으로는 원시값보단 도메인 객체를 활용하다
   - 유연성
   - 도메인의 다양한 개념 간의 결합을 줄인다

9. 예외
   - checked exception : 프로그램 회복 강제성
   - unchecked exception : 비즈니스 로직 검증 (일시적 발생 오류)
   - 예외의 패턴과 안티 패턴 (CSV Parser의 경우)
     - 정해진 문법 파싱(CSV, JSON)
     - 데이터 검증

10. 예외처리
    - 과도한 세밀함 : 각각의 예외에 적합하고 정확한 회복기법, 생산성 저하
    - 과도한 덤덤함 : 구체적인 회복로직 만들 수 없음

11. 노티피케이션 패턴 : 도메인 클래스로 오류를 수집

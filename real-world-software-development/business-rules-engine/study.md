1. TDD 로 설계 문제를 풀어나가기
2. Mocking
3. Builder Pattern
4. 인터페이 분리 원칙 (ISP)

#### ISP
- 어떤 클래스도 사용하지 않는 메소드에 의존성을 갖지 않아야 한다 => 불필요한 결합을 만들기 때문
- 인터페이스가 커지면 인터페이스 사용자는 사용하지 않는 기능을 갖게 되며 이는 불필요한 결합도를 만든다 ex) engine.ConditionalAction
- 반드시 필요한 메소드만을 상속/구현 해야한다


#### Fluent Api
- 특정 문제를 더 직관적으로 해결할 수 있도록 특정 도메인에 맞춰진 API
- Method Chaining을 이용하여 복잡한 연산도 지정 가능 ex. stream api

*Self 정리*
- ISP 는 불필요한 메서드의 디펜던시를 감소시켜 높은 응집도를 촉진한다.
- 큰 인터페이스를 응집력 있는 작은 인터페이스로 분리해 사용자는 필요한 기능만 사용할 수 있다.
- TODO : 회사 Batch Trigger 코드 Fluent api 로 바꿔보기
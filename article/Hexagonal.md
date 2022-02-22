## 지속 가능한 소프트웨어 설계 패턴: 포트와 어댑터 아키텍처 적용하기

https://engineering.linecorp.com/ko/blog/port-and-adapter-architecture/

---

### 헥사고날 아키텍처 (=포트와 어댑터 아키텍처)

인터페이스나 Infra의 변경에 영향을 받지 않는 핵심 코드를 만들고 견고하게 관리하는 것이 목표


포트와 어댑터 설계를 적용하면 인터페이스나 기반 요소가 사용자의 요구 사항 혹은 수용 능력에 영향을 받아 변경된다고 하더라도 애플리케이션의 주요 동작(도메인 로직 혹은 비즈니스 로직)에는 아무런 영향을 주지 않는다.


---

### 포트와 어댑터란?

Port (= Interface)

Adaptor (= client에 제공해야 할 인터페이스를 따르면서, 내부 구현은 서버의 인터페이스로 위임)

*HTTP API 를 rent 라는 인터페이스로 연결하는 Adaptor*

![포트와 어댑터](https://engineering.linecorp.com/ko/port1/)


```
Adaptor =>          Port  => Domain

Application =>      Port  => Domain

포트는 변경이 잦은 어댑터와 애플리케이션의 결합도를 낮춘다

어플리케이션은 핵심 로직에 가까우므로 결합도를 낮추는 것이 매우 중요

어플리케이션은 도메인에 의존하지만, 도메인은 app과 adaptor에 의존 X

ex. Spring Data Jpa, 우리는 Port를 구현한다, 어댑터는 Spring Data Jpa가 구현

```
![포트와 어댑터2](https://engineering.linecorp.com/ko/port3/)


---

### 내 생각

adaptor는 자주 변동된다

핵심 도메인과을 Adaptor와 도메인을 연결하는 Port 는 변경을 최소화 해야한다

인터페이스의 커맨드 경계선을 명확화 해야한다

DDD와 별개의 아키텍처가 아닌 오히려 DDD안에 헥사고날을 녹일 수 있다.
1. 리스코프 치환 원칙
   - 상속관계, 어떻게 클래스를 상속하거나 인터페이스를 구현하는가, 언제 상속을 사용해야하는가, 상속보다는 조합
   - 하위 형식에서 선행조건을 더할 수 없음
     - 구현한 코드가 어떻게든 실행될 것이라 가정할 수 없음
     - 선행조건 : Importer -> 임포트 하려는 파일이 존재 / 읽을 수 있을 것
   - 하위형식에서 후행 조건을 약화시킬 수 없음
     - importFile() => contents() 에는 파일이 반드시 포함되어야함
   
   
2. 응용프로그램의 컴포넌트 이름을 구체적으로 짓자
   - 고객/운영자와 대화할 때 사용하는 용어를 소프트웨어 코드와 같은 의미로 사용하여 유지보수성을 높히자

3. 도메인 클래스를 사용하여 개념에 이름을 붙이고 수행할 수 있는 동작과 값을 제한하자

4. 유틸리티 클래스 사용의 주의점
   - 간단하지만 OOP와는 거리가 멀다, 객체지향에서는 클래스로 기능을 만든다
   - 응집도/SRP에 위반되는 여러 의무를 담당하는 한 개의 거대 클래스가 탄생한다.


*Self 정리*

5. TextFile 의 목적
   - Text 형식의 File 을 import 하는 Invoice/Letter/engine.Report Importer
     - 공통적으로 파일을 파싱해서 lines 와 attributes 객체를 구성해야하는 기능이 필요함
     - TextImporter 를 만들어 상속 : LSP 규칙은 따르지만, 비즈니스 흐름에 따라 상속이 깨질 수 있다 => (Invoice가 갑자기 Image 형식으로 바뀐다면?)
     - 유틸리티 클래스 : ImportUtil 클래스를 만든다 => 온갖 코드가 모인 God Class 가 될 수 있다
     - *도메인 클래스(TextFile) 와 조합을 사용* => 다 해결 가능 

6. LSP : 상위 타입의 객체를 하위 타입의 객체로 치환해도 동작에 문제가 없어야 한다
   - 선행조건을 더할 수 없고 후행 조건을 약화시킬 수 없음
   - 상속보단 조합이 나은 경우가 있다, 명확한 is A 가 필요할 경우만 상속을 사용하자 (ex. Importer Interface)


*전반적으로 이번 챕터는 책 내용이 부실하다, 코드 분석이 나음..*

7. Test 위생
   1. 테스트 이름은 도메인 용어 / 자연어로 짓자
   2. 공개(Public) API 만 테스트하자, 세부구현이 바뀔 시 Fail 로 이어질 수 있다
   3. 구현이 아니라 동작을 테스트하자
   4. Happy Path 만 테스트하지말자 => 오류상황을 가정하라, expected = xxxxException.class

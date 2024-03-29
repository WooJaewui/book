# 6장 메시지와 인터페이스

---------------------------------------------------------------------------------------------------

> ## 협력과 메시지.

### 메시지.
- 객체들이 협력하기 위해 사용할 수 있는 유일한 의사소통 수단이다.
- 한 객체가 다른 객체에게 도움을 요청하는 것을 메시지 전송 또는 메시지 패싱이라고 부른다.
- 이때 메시지를 전송하는 객체를 메시지 전송자, 메시지를 수신하는 객체를 메시지 수신자라고 부른다.
- 클라이언트-서버 모델 관점에서는 메시지 전송자는 클라이언트, 메시지 수신자는 서버라고 부르기도 한다.
- 메시지는 오퍼레이션명과 인자로 구성된다.

### 메시지 전송.
- 메시지(오퍼레이션명 + 인자) + 메시지 수신자.

### 메시지와 메서드.
- 메시지를 수신했을 때 실제로 어떤 코드가 실행되는지는 메시지 수신자의 실제 타입이 무엇인가에 달려있다.
- 메시지를 수신했을 때 실제로 수행되는 함수 또는 프러시저를 메서드라고 부른다.
- 메시지와 메서드의 구분은 메시지 전송자와 메시지 수신자가 느슨하게 결합될 수 있게 한다.

### 퍼블릭 인터페이스와 오퍼레이션.
- 퍼블릭 인터페이스.
  - 외부의 객체는 오직 객체가 공개하는 메시지를 통해서만 객체와 상호작용할 수 있다.
  - 객체가 의사소통을 위해 외부에 공개하는 메시지의 집합을 퍼블릭 인터페이스라고 부른다.
- 오퍼레이션.
  - 퍼블릭 인터페이스에 포함된 메시지를 오퍼레이션이라고 부른다.
  - 오퍼레이션은 수행 가능한 어떤 행동에 대한 추상화다.
  - 흔히 오퍼레이션이라고 부를 때는 내부의 구현 코드는 제외하고 단순히 메시지와 관련된 시그니처를 가리키는 경우가 대부분이다.
  - 오퍼레이션 관점에서 다형성이란 동일한 오퍼레이션 호출에 대해 서로 다른 메서드들이 실행되는 것이라고 정의할 수 있다.

### 시그니처.
- 시그니처 signature.
  - 오퍼레이션의 이름과 파라미터 목록을 합쳐 시그니처라고 부른다.
  - 오퍼레이션은 실행 코드 없이 시그니처만을 정의한 것이다.
  - 메서드는 이 시그니처에 구현을 더한 것이다.

### 용어 정리.
- 메시지.
  - 객체가 다른 객체와 협력하기 위해 사용하는 의사소통 메커니즘.
- 메시지 전송.
  - 일반적으로 객체의 오퍼레이션이 실행되도록 요청하는 것을 메시지 전송이라고 부른다.
- 오퍼레이션.
  - 객체가 다른 객체에게 제공하는 추상적인 서비스이다.
  - 오퍼레이션은 메시지를 수신하는 객체의 인터페이스를 강조한다.
  - 메시지 전송자는 고려하지 않은 채 메시지 수신자의 관점만을 다른다.
- 메서드.
  - 메세지에 응답하기 위해 실행되는 코드 블록을 메서드라고 부른다.
  - 오퍼레이션과 메서드의 구분은 다형성의 개념과 연결된다.
- 퍼블릭 인터페이스.
  - 객체가 협력에 참여하기 위해 외부에서 수신할 수 있는 메시지의 묶음.
  - 클래스의 퍼블릭 메서드들의 집합이나 메시지의 집합을 가리키는 데 사용된다.
- 시그니처.
  - 오퍼레이션이나 메서드의 명세를 나타낸 것으로, 이름과 인자의 목록을 포함한다.

---------------------------------------------------------------------------------------------------

> ## 인터페이스와 설계 품질.

### 좋은 인터페이스.
1. 최소한의 인터페이스.
  - 꼭 필요한 오퍼레이션만을 인터페이스에 포함한다.
2. 추상적인 인터페이스.
  - 어떻게 수행하는지가 아니라 무엇을 하는지를 표현한다.

### 좋은 인터페이스를 만드는 방법.
- 책임 주도 설계.
  - 메시지를 먼저 선택함으로써 협력과는 무관한 오퍼레이션이 인터페이스에 생성되는 것을 방지한다.
  - 인터페이스는 최소한의 인터페이스만 가지게 만든다.
  - 객체가 메시지를 선택하는 것이 아니라 메시지가 객체를 선택하게 함으로써 클라이언트의 의도를 메시지에 표현할 수 있게 된다.
  
### 디미터 법칙 Law of Demeter.
- 간단히 말하면 객체의 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한하라는 것이다.
- 모든 클래스 C와 C에 구현된 모든 메서드 M에 대해 M이 메시지를 전송할 수 있는 모든 객체의 조건.
  - M의 인자로 전달된 클래스(C 자체를 포함)
  - C의 인스턴스 변수의 클래스.
- 모든 예시.
  - this 객체.
  - 메서드의 매개변수.
  - this의 속성.
  - this의 속성인 컬렉션의 요소.
  - 메서드 내에서 생성된 지역 객체.

### 부끄럼 타는 코드 shy code.
- 부끄럼 타는 코드는 불필요한 어떤 것도 다른 객체에게 보여주지 않으며, 다른 객체의 구현에 의존하지 않는 코드.
- 디미터 법칙을 따르면 부끄럼 타는 코드를 작성할 수 있다.
  - 디미터 법칙을 따르는 코드는 메시지 수신자의 내부 구조가 전송자에게 노출되지 않는다.
  - 메시지 전송자는 수신자의 내부 구현에 결합되지 않는다.

### 디미터 법칙과 캡슐화.
- 디미터 법칙은 캡슐화를 다른 관점에서 표현한 것이다.
- 디미터 법칙이 가치 있는 이유는 클래스를 캡슐화하기 위해 따라야 하는 구체적인 지침을 제공하기 때문이다.
- 캡슐화 원칙이 내부의 구현을 감춰야 한다는 사실을 강조한다면 디미터 법칙은 협력하는 클래스의 캡슐화를 지키기 위해
  <br> 접근해야 하는 요소를 제한한다.

### 기차 충돌 train wreck.
- 클래스의 내부 구현이 외부로 노출됐을 때 나타나는 전형적인 형태이다.
- 메시지 전송자는 메시지 수신자의 내부 정보를 자세히 알게 된다.
- 디미터 법칙을 어길 때 발생할 수 있다.

### 묻지 말고 시켜라 Tell, Don't ask.
- 훌륭한 메시지는 객체의 상태에 관해 묻지 말고 원하는 것을 시켜야 한다.
- 메시지 전송자는 메시지 수신자의 상태를 기반으로 결정을 내린 후 메시지 수신자의 상태를 바꿔서는 안 된다.
- 묻지 말고 시켜라 원칙을 따르면 밀접하게 연관된 정보와 행동을 함께 가지는 객체를 만들 수 있다.

### 켄트 벡의 메서드를 명명하는 두 가지 방법.
1. 메서드가 작업을 어떻게 수행하는지를 나타내도록 이름 짓기.
   - 메서드의 이름이 내부의 구현 방법을 드러낸다.
   - 메서드에 대해 제대로 커뮤니케이션하지 못한다.
2. 메서드가 무엇을 하는지를 드러내기.
   - 무엇을 하는지를 고민하다보면 자연스럽게 책임에 관해 고민해야 한다.
   - 결과적으로 협력하는 클라이언트의 의도에 부합하도록 메서드의 이름을 짓게 된다.
   - 인터페이스를 두고 구현 객체들에게 같은 이름을 사용하여 추상화할 수 있다.

### 의도를 드러내는 인터페이스.
- 의도를 드러내는 선택자 Intention Revealing Selector.
  - 어떻게 하느냐가 아니라 무엇을 하느냐에 따라 메서드의 이름을 짓는 패턴.
  - 서로 다른 여러 구현에 메서드를 붙였을 때 어색하지 않도록 만들어야 한다.
- 의도를 드러내는 인터페이스 Intention Revealing Interface.
  - 구현과 관련된 모든 정보를 캡슐화하고 객체의 퍼블릭 인터페이스에는 협력과 관련된 의도만을 표현해야 한다.
  - 메서드의 이름을 작성할 때 수행 방법에 대해서는 언급하지 말고 결과와 목적만을 포함하도록 작성해야 한다.

### 함께 모으기.
- 디미터 법칙을 위반한 코드.
  - 작은 변경에도 쉽게 무너지는 불안정한 코드가 된다. 
  - 변경에 취약해진다.
  - 사용하기 어렵다. 

### 인터페이스에 의도를 드러내자.
- 오퍼레이션의 이름은 협력이라는 문맥을 반영해야 한다.
- 객체 자신이 아닌 클라이언트의 의도를 표현하는 이름을 가져야 한다.
- 의도를 드러내는 인터페이스 원칙은 코드의 목적을 명확하게 커뮤니케이션할 수 있께 해준다.

---------------------------------------------------------------------------------------------------

> ## 원칙의 함정.

### 디미터 법칙은 하나의 도트를 강제하는 규칙이 아니다.
- IntStream처럼 연속적으로 메서드를 수행하는 경우 오류라고 생각하기 쉽다. 
- IntStream 메서드를 수행한 후 다른 IntStream 인스턴스를 반환한다. (캡슐화가 깨지지 않음)

### 결합도와 응집도의 충돌.
- 객체에게 시키는 것이 항상 가능한 것은 아니다.
- 가끔씩은 물어야 한다.
- 소프트웨어 설계에 법칙이란 존재하지 않는다. (원칙들만 존재한다)
- 소프트웨어 원칙들은 맹신하지 말고, 원칙이 적절한 상황과 부적절한 상황을 판단할 수 있는 안목을 길러라.

---------------------------------------------------------------------------------------------------
> ## 명령-쿼리 분리 원칙.

### 명령-쿼리 분리 원칙 Command-Query Separation.
- 퍼블릭 인터페이스에 오퍼레이션을 정의할 떄 참고할 수 있는 지침을 제공한다.
- 객체의 상태를 변경하는 명령은 반환값을 가질 수 없다.
- 객체의 정보를 반환하는 쿼리는 상태를 변경할 수 없다.
- 질문(query)이 답변을 수정해서는 안 된다.

### 용어정리.
- 루틴 routine.
  - 어떤 절차를 묶어 호출 가능하도록 이름을 부여한 기능 모듈.
  - 루틴은 프로시저와 함수로 구분할 수 있다.
  - 프로시저 : 정해진 절차에 따라 내부의 상태를 변경하는 루틴의 한 종류다. (부수효과 O, 반환 값 X)
  - 함수 : 어떤 절차에 따라 필요한 값을 계산해서 반환하는 루틴의 한 종류다. (부수효과 X, 반환 값 O)
- 부수효과.
  - 값을 반환하는 메서드나 함수가 외부 상태를 변경하는 경우.
- 명령.
  - 객체의 상태를 수정하는 오퍼레이션.
  - 프로시저와 같다.
- 쿼리.
  - 객체와 관련된 정보를 반환하는 오퍼레이션.
  - 함수와 같다.

### 반복 일정의 명령과 쿼리 분리하기.
- 코드가 예측 가능하고 이해하기 쉬우며 디버깅이 용이한 동시에 유지보수가 수월해질 것이다.

### 명령-쿼리 분리와 참조 투명성.
- 참조 투명성 referential transparency.
  - 어떤 표현식 e가 있을 때 e의 값으로 e가 나타나는 모든 위치를 교체하더라도 결과가 달라지지 않는 특성.
  - 수학에서는 참조 투명성을 만족하지만, 프로그래밍에서는 참조 투명성이 만족하지 않을 수 있다.
  - 명령-쿼리 분리를 통해 제한적으로 참조 투명성의 혜택을 누릴 수 있다.
- 불변성 immutability.
  - 어떤 값이 변하지 않는 성질.
  - 부수효과가 발생하지 않는다는 뜻과 동일하다.
- 참조 투명성의 장점.
  - 모든 함수를 이미 알고 있는 하나의 결괏값으로 대체할 수 있기 때문에 식을 쉽게 계산할 수 있다.
  - 모든 곳에서 함수의 결과값이 동일하기 때문에 식의 순서를 변경하더라도 각 식의 결과는 달라지지 않는다.

### 부수효과를 발생시키는 방법.
1. 대입문.
2. 프로시저.

### 명령형 프로그래밍.
- 부수효과를 기반으로 하는 프로그래밍 방식.
- 상태를 변경시키는 연산들을 적절한 순서대로 나열함으로써 프로그램을 작성한다.
- 대부분의 객체지향 프로그래밍 언어들은 객체의 상태 변경에 집중하기 때문에 명령형 프로그래밍 언어로 분류된다.

### 함수형 프로그래밍.
- 부수효과가 존재하지 않는 수학적인 함수에 기반한다.
- 참조 투명성의 장점을 극대화할 수 있다.
- 명령형 프로그래밍에 비해 프로그램의 실행 결과를 이해하고 예측하기가 더 쉽다.
- 하드웨어 발달로 병렬 처리가 중요해진 최근에는 함수형 프로그래밍의 인기가 상승하고 있다.

### 계약의 의한 설계 Design By Contract.
- 협력을 위해 클라이언트와 서버가 준수해야 하는 제약을 코드 상에 명시적으로 표현하고 강제할 수 있는 ㅂ아법.
- 부록 A '계약에 의한 설계' 참고.










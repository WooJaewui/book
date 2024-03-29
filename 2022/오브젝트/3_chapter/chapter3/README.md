# 3장 역할, 책임, 협력.

----------------------------------------------------------------------------------------------

> ## 협력.

### 정의.
- 협력.
  - 객체들이 애플리케이션의 기능을 구현하기 위해 수행하는 상호작용.
  - 객체에서 다른 객체를 호출하여 로직을 수행하는 것을 의미.
- 책임.
  - 객체가 협력에 참여하기 위해 수행하는 로직.
  - 인스턴스를 만들고 메서드를 호출하는 것을 의미.
- 역할.
  - 객체들이 협력 안에서 수행하는 책임들이 모여 객체가 수행하는 것들.
  - 객체가 수행하는 일들을 의미.
- 메시지 전송.
  - 객체 사이의 협력을 위해 사용할 수 있는 유일한 커뮤니케이션 수단.
- 자유로운 객체.
  - 객체 스스로 본인의 상태를 결정한다. (중요!!)
  - 객체를 자율적으로 만드는 가장 기본적인 방법은 내부 구현을 캡슐화하는 것이다.

### 협력이 설계를 위한 문맥을 결정한다.
- 문맥 context.
  - 상태는 객체가 행동하는 데 필요한 정보에 의해 결정된다.
  - 행동은 협력 안에서 객체가 처리할 메시지로 결정된다.
  - 결과적으로 객체가 참여하는 협력이 객체를 구성하는 행동과 상태 모두를 결정한다.
  - 협력을 객체를 설계하는 데 필요한 일종의 문맥을 제공한다.

----------------------------------------------------------------------------------------------

> ## 책임.

### 책임이란 무엇인가 ?
- 책임.
  - 협력에 참여하기 위해 객체가 수행하는 행동.
  - 객체에 의해 정의되는 응집도 있는 행위의 집합.
  - '무엇을 알고 있는가'와 '무엇을 할 수 있는가'로 구분된다.
  - 하는 것.
    - 객체를 생성하거나 계산을 수행하는 등의 스스로 하는 것.
    - 다른 객체의 행동을 시작시키는 것.
    - 다른 객체의 활동을 제어하고 조절하는 것.
  - 아는 것.
    - 사적인 정보에 관해 아는 것.
    - 관련된 객체에 관해 아는 것.
    - 자신이 유도하거나 계산할 수 있는 것에 관해 아는 것.
- 책임의 특징.
  - 책임은 객체가 수행할 수 있는 행동을 종합적이고 간략하게 서술하기 때문에 메시지보다 추상적이고 개념적으로도 더 크다.
  - 단순한 책임이라고 생각했던 것이 여러 개의 메시지로 분할되기도 한다.
  - 객체는 자신이 맡은 책임을 수행하는 데 필요한 정보를 알고 있을 책임이 있다.
  - 객체는 자신이 할 수 없는 작업을 도와줄 객체를 알고 있을 책임이 있다.
  - 객체에게 얼마나 적절한 책임을 할당하느냐가 설계의 전체적임 품질을 결정한다.

### 책임 할당.
- 책임 할당을 위한 정보 전문가 패턴 Information Expert Pattern.
  - 자율적인 객체를 만드는 가장 기본적인 방법이다.
  - 책임을 수행하는 데 필요한 정보를 가장 잘 알고 있는 전문가에게 그 책임을 할당하는 방법이다.

### 책임 주도 설계.
- 책임 주도 설계 RDD Responsibility-Driven Design.
  - 책임을 찾고 책임을 수행할 적절한 객체를 찾아 책임을 할당하는 방식으로 협력을 설계하는 방법을 의미한다.
- 책임 주도 설계 설계 방식.
  1. 시스템이 사용자에게 제공해야 하는 기능인 시스템 책임을 파악한다.
  2. 시스템 책임을 더 작은 책임으로 분할한다.
  3. 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.
  4. 객체가 책임을 수행하는 도중 다른 객체의 도움이 필요한 경우 이를 책임질 적절한 객체 또는 역할을 찾는다.
  5. 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 된다.
- 정리.
  - 협력이 책임을 이끌어내고 책임이 협력에 참여할 객체를 결정한다.
  - 책임에 집중하는 것이 중요한 이유는 유연하고 견고한 객체지향 시스템을 위해 가장 중요한 재료가 책임이기 때문이다.

### 메시지가 객체를 결정한다.
- 객체에게 책임을 할당하는 데 필요한 메시지를 먼저 식별하고 메시지를 처리할 객체를 나중에 선택했다는 것이 중요하다.
- 메시지가 객체를 선택하게 해야 하는 두 가지 중요한 이유.
  1. 객체가 최소한의 인터페이스를 가질 수 있게 된다.
     - 필요한 메시지가 식별될 때까지 객체의 퍼블릭 인터페이스에 어떤 것도 추가하지 않기 때문에.
  2. 객체는 충분히 추상적인 인터페이스를 가질 수 있게 된다.
     - 메시지는 외부의 객체가 요청하는 무언가를 의미하기 때문에 무엇을 수행할지에 초점을 맞추는 인터페이스를 얻을 수 있다. 

### 행동이 상태를 결정한다.
- 객체의 행동은 객체가 협력에 참여할 수 있는 유일한 방법이다.
- 데이터 주도 설계 Data-Driven Design.
  - 객체의 내부 구현에 초점을 맞춘 설계 방법.

### 정리.
- 객체가 가질 수 있는 상태는 행동을 결정하고 나서야 비로소 결정할 수 있다.
- 협력이 객체의 행동을 결정하고 행동이 상태를 결정한다.

----------------------------------------------------------------------------------------------

> ## 역할.

### 역할과 협력.
- 역할.
  - 객체가 어떤 특정한 협력 안에서 수행하는 책임의 집합을 의미한다.
  - 협력을 모델링할 때는 특정한 객체가 아니라 역할에게 책임을 할당한다고 생각하는 게 좋다.

### 유연하고 재사용 가능한 협력.
- 역할이 중요한 이유는 역할을 통해 유연하고 재사용 가능한 협력을 얻을 수 있기 때문이다.
- 여러 개의 역할에 대한 대표자를 둠으로써 역할을 하나로 통합할 수 있다.
- 대표자는 추상클래스와 인터페이스를 사용한다고 생각하면 된다.

### 객체 대 역할.
- 역할.
  - 협력에 참여하는 후보가 여러개인 경우.
- 객체.
  - 협력에 참여하는 후보가 한 개인 경우.
  - 협력에 적합한 책임을 수행하는 대상이 한 종류라면 간단하게 객체로 간주한다.
- 설계 초반.
  - 다양한 객체들이 협력에 참여한다는 것이 확실하다면 역할로 시작하라.
  - 정확한 결정을 내리기 어려운 상황이라면 구체적인 객체로 시작하라.

### 역할과 추상화.
- 추상화의 장점.
  1. 세부 사항에 억눌리지 않고도 상위 수준의 정책을 쉽고 간단하게 표현할 수 있다.
  2. 설계가 좀 더 유연해진다.
- 역할이 중요한 이유.
  - 동일한 협력을 수행하는 객체들을 추상화할 수 있기 때문.

### 배우와 배역.
- 배우와 객체는 비슷한 점이 많다.
- 배우가 여러 연극에 참여하면서 여러 배역을 연기할 수 있는 것처럼 객체 역시 여러 협력에 참여하여 역할을 수행할 수 있다.
- 동일한 객체라도 객체가 참여하는 협력에 따라 객체의 얼굴은 계속해서 바뀌게 된다.

----------------------------------------------------------------------------------------------

> ## CRC 카드.

### CRC Candidate Responsibility Collaborator.
- CRC.
  - 하나의 CRC 카드는 협력에 참여하는 하나의 후보를 표현한다.
  - 좌측 하단에는 목적을 좀 더 세분화해서 무엇을 알고 무엇을 해야 하는지에 대한 책임을 차례대로 적는다.
  - 카드의 우측에는 책임을 수행하면서 함께 협력할 협력자를 나열한다.
  - 워드 커닝험과 켄트 벡이 객체지향을 모르는 초보자와 절차적인 설계에 익숙한 사람을 가르치기 위해 고안한 기법이다.














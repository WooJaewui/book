
# 람다표현식.

--------------------------------------------------------------------------------------------------------------

> ## 람다란 무엇인가 ?

### 람다 표현식.
- 메서드로 전달할 수 있는 익명 함수를 단순화한 것이라고 할 수 있다.
- 이름은 없지만, 파라미터 리스트, 바디, 반환 형식, 발생할 수 있는 예외 리스트는 가질 수 있다.

### 람다의 특징.
1. 익명.
   - 보통의 메서드와 달리 이름이 없으므로 익명이라 표현한다.
   - 구현해야 할 코드에 대한 걱정거리가 줄어든다.
2. 함수.
   - 람다는 메서드처럼 특정 클래스에 종속되지 않으므로 함수라고 부른다.
   - 메서드처럼 파라미터 리스트, 바디, 반환 형식, 가능한 예외 리스트를 포함한다.
3. 전달.
   - 람다 표현식을 메서드 인수로 전달하거나 변수로 저장할 수 있다.
4. 간결성.
   - 익명 클래스처럼 많은 자질구레한 코드를 구현할 필요가 없다.

### 람다 표현식 기본 형식.
    // 기본 형식.
    (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
- 파라미터 리스트 : 사과 2개. (a1, a2)\
- 화살표 : 람다의 파라미터 리스트와 바디를 구분한다.
- 람다 바디 : 람다의 반환값에 해당하는 표현식이다.

### 람다 표현식 예시 코드.
    // 예시1.
    (String s) -> s.length();

    // 예시2.
    (Apple a) -> a.getWeight() > 150;
    
    // 예시3.
    (int x, int y) -> { 
            System.out.println( "Result: ");
            System.out.println(x+y);
    }

    // 예시4.
    () -> 42;

    // 예시5
    (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
- 람다식은 return을 생략할 수 있다.
- 여러행 문장을 포함할 수 있다.
- 표현식은 { }을 생략하고, 구문은 { }안에 작성한다.

--------------------------------------------------------------------------------------------------------------

> ## 어디에, 어떻게 람다는 사용할까 ?

### 함수형 인터페이스.
- 하나의 추상 메서드를 지정하는 인터페이스이다.
- 여러 디폴트 메서드는 포함할 수 있다.
- 람다 표현식으로 추상 메서드 구현을 직접 전달할 수 있다. (전체 표현식을 함수형 인터페이스의 인스턴스로 취급)

### 시그니처.
- 메서드 명과, 파라미터 순서, 파라미터 타입, 파라미터 개수를 의미한다.

### 함수 디스크립터 function descriptor.
- 람다 표현식의 시그니처를 서술하는 메서드.
- 파라미터 순서, 파라미터 타입, 파라미터 개수, 반환 타입을 작성하는 것을 의미한다.

### 람다 사용 정리.
    // 리턴값 O 블럭 X
    (파라미터) -> 리턴값;

    // 리턴값 X 블럭 X
    (파라미터) -> 실행할 코드 1줄;
    
    // 리턴값 O 블럭 O
    (파라미터) -> { 
                싦행할 코드;
                return 리턴값; 
    }

    // 리턴값 X 블럭 O
    (파라미터) -> { 
                실행할 코드 2줄 이상;
                ...
    }

### @FunctionalInterface.
- 함수형 인터페이스임을 가리키는 어노테이션이다.
- 실제로 함수형 인터페이스가 아닌 경우 컴파일러가 에러를 발생시킨다.

--------------------------------------------------------------------------------------------------------------

> ## 람다활용 : 실행 어라운드 패턴.

### 실행 어라운드 패턴 execute around pattern.
1. 자원을 연다.
2. 원하는 실행을 한다.
3. 자원을 닫는다.

--------------------------------------------------------------------------------------------------------------

> ## 함수형 인터페이스 사용.

### 함수형 인터페이스.
- 함수형 인터페이스는 오직 하나의 추상 메서드를 지정한다.
- 추상 메서드는 람다 표현식의 시그니처를 묘사한다.
- 함수형 인터페이스의 추상 메서드 시그니처를 '함수 디스크립터' 라고 한다.
- 자바에서는 java.util.function 패키지에 공통의 함수 디스크립터를 기술하는 함수형 인터페이스의 집합을 포함하다.

### Predicate.
      @FunctionalInterface
      public interface Predicate<T> {
         boolean test(T t);
      }
- 'test'라는 추상 메서드를 정의하며 제네릭 형식 T의 객체를 인수로 받아 불리언을 반환한다.

### Consumer.
      @FunctionalInterface.
      public interface Consumer<T> {
         void accept(T t);
      }
- 제네릭 T 객체를 받아서 void를 반환하는 'accept' 추상 메서드를 정의한다.

### Function.
      @FunctionalInterface.
      public interface Function<T,R> {
         R apply(T t);
      }
- 제네릭 형식 T를 인수로 받아서 R을 반환하는 추상 메서드 'apply' 를 정의한다.


### Supplier.
      @FunctionalInterface.
      public interface Supplier {
         T get();
      }
- 입력 파라미터는 없고, 리턴값으로 T를 반환하는 'get' 메서드.

### Operator.
      @FunctionalInterface.
      pbulic interface UnaryOperator {
         T apply(T t);
      }
- 입력 파라미터와 리턴값이 모두 T 타입인 'apply' 메서드.

### 오토 박싱.
- 기본형을 참조형으로 참조형에서 기본형으로 자동으로 변환해주는 기능.
- 박싱된 값은 메모리를 더 소비한다.

### 제네릭 특징.
- 제네릭은 참조형 타입만 사용할 수 있다.

### 특화 함수.
- 자바 8에서는 오토박싱 동작을 피할 수 있도록 특별한 함수형 인터페이스를 제공한다. 
- IntPredicate, LongPredicate, DoublePredicate 등 이름 앞에 형식명이 붙는다.

### 람다형 사용 예제.
      // 불리언 사용.
      (List<String> list) -> list.isEmpty();                               Predicate<List<String>>
      
      // 객체 생성.
      () -> new Apple(10);                                                 Supplier<Apple>
      
      // 객체에서 소비.
      (Apple a) -> System.out.println(a.getWeight);                        Consumer<Apple>

      // 객체에서 선택/추출.
      (String s) -> s.length();                                            Fcuntion<String>

      // 두 값 조합.
      (int a, int b) -> a*b ;                                              IntBinaryOperator

      // 두 객체 비교.
      (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight));     BiFunction<Apple,Apple,Integer>

### 예외, 람다, 함수형 인터페이스의 관계.
- 함수형 인터페이스는 확인된 예외를 던지는 동작을 허용하지 않는다.
- 예외를 던지는 람다 표현식을 만들려면 확인된 예외를 선언하는 함수형 인터페이스를 직접 정의하거나 람다를 try/catch 해야 한다.
- 직접 함수를 만들 수 없는 경우 람다의 실행코드 부분에 try/catch 를 작성해야 한다.

--------------------------------------------------------------------------------------------------------------

> ## 형식 검사, 형식 추론, 제약.

### 형식 검사.
- 람다가 사용되는 컨텍스트(context)를 이용해서 람다의 형식을 추론할 수 있다.
- 대상 형식.
  - 컨텍스트에서 기대되는 람다 표현식의 형식.

### 형식 확인 과정.
      // 예시 코드.
      List<Apple> heavierThan150g = filter(inventory, (Apple apple) -> apple.getWeight() > 150);
1. filter 메서드의 선언을 확인한다.
2. filter 메서드는 두 번째 파라미터로 Predicate<Apple> 형식(대상 형식)을 기대한다.
3. Predicate<Apple>은 test 라는 한 개의 추상 메서드를 정의하는 함수형 인터페이스다.
4. test 메서드는 Apple 을 받아 boolean 을 받환하는 함수 디스크립터를 묘사한다.
5. filter 메서드로 전달된 인수는 이와 같은 요구사항을 만족해야 한다.

### 대상 형식.
- 람다로 인해 생성되는 인스턴스 타입.

### 다이아몬드 연산자.
      List<String> list = new ArrayList<>();
- "<>"연산자를 사용하면 컨텍스트에 따른 제네릭 형식을 추론할 수 있다.

### void 호환 규칙.
- 람다의 바디에 일반 표현식이 있으면 void를 반환하는 함수 디스크립터와 호환된다.

### 형식 추론.
- 자바 컴파이럴는 람다 표현식이 사용된 컨텍스트를 이용해서 람다 표현식과 관련된 함수형 인터페이스를 추론한다.
- 대상 형식을 이용해서 함수 디스크립터를 알 수 있으므로 컴파일러는 람다의 시그니처도 추론할 수 있다.
- 결과적으로 컴파일러는 람다 표현식의 파라미터 형식에 접근할 수 있으므로 람다 문법에서 이를 생략할 수 있다.

### 형식 추론의 장단점.
- 파라미터를 생략하지 않는 람다 표현식에은 코드 가독성 향상 좋다.
- 파라미터를 생략한 경우 코드 가독성은 떨어지지만, 코드를 짧게 작성할 수 있다.

### 람다 캡처링 capturing lambda.
      int portNumber = 1337;
      Runnable r = () -> System.out.println(portNumber);
- 람다가 호출된 블락안에 있는 지역변수를 람다 안에서 사용하는 것을 의미한다.
- 람다에서는 인스턴스 변수, 지역 변수 모두 사용할 수 있다.
- 지역 변수는 final 변수만 사용할 수 있다.
- https://steady-coding.tistory.com/306

### InnerClass 참고.
- https://blog.naver.com/poteto7/70116947368
- https://cafe.naver.com/javachobostudy.cafe?iframe_url=/ArticleRead.nhn%3Farticleid=18955&

### 클로저.
- 함수의 비지역 변수를 자유롭게 참조할 수 있는 함수의 인스턴스를 가리킨다.
- 클로저는 다른 함수의 인수로 전달할 수 있다.
- 클로저는 클로저 외부에 정의된 변수의 값에 접근하고, 값을 바꿀 수 있다.

--------------------------------------------------------------------------------------------------------------

> ## 메서드 참조.

### 메서드 참조.
      (Apple apple) -> apple.getWeigh()               Apple::getWeight
      () -> Thread.currentThread().dumpStack()        Thread.currentThread()::dumpStack
      (str, i) -> str.substring(i)                    String::substring
      (String s) -> System.out.println(s)             System.out::println
      (String s) -> this.isValidName(s)               this::isValidName
- 하나의 메서드를 참조하는 람다를 편리하는 표현할 수 있는 문법이다.
- 람다 형식 대신에 명시적으로 메서드명을 참조함으로써 가독성을 높일 수 있다.
- 메서드 참조는 컨텍스트에 형식과 일치해야 한다.

### 메서드 참조 활용.
- 헬프 메서드에서 많이 사용된다. (다른 메서드에서 활용하기 위해 만든 메서드)

### 메서드 참조의 종류.
1. 정적 메서드 참조.
   - Integer::parseInt
2. 다양한 형식의 인스턴스 메서드 참조.
   - String::length
   - 람다에 파라미터의 값을 호출하는 메서드에 사용하는 경우.
3. 기존 객체의 인스턴스 메서드 참조. (참조변수 사용)
   - transaction::getValue
   - 람다 외부에 변수를 사용하는 경우.

### 생성자 참조.
      // 기본 형식.
      클래스이름::new

      // 예시 코드1.
      Supplier<Apple> c1 = Apple::new;

      // 예시 코드2.
      BiFunction<Color, Integer, Apple> bf = Apple::new;
      Apple apple = bf.apply(GREEN, 10);
- new 키워드를 이용해서 기본 생성자의 참조를 만들 수 있다.
- 인스턴스화하지 않고도 생성자에 접근할 수 있는 기능을 다양한 상황에 응용할 수 있다.

### 생성자 팁.
- 생성자에 필요한 인수가 많은 경우 직접 함수형 인터페이스를 만들어서 사용해야 한다.

--------------------------------------------------------------------------------------------------------------

> ## 람다, 메서드 참조 활용하기.

### 코드로 실습.
- 람다와 메서드 참조를 통해 코드량을 획기적으로 줄일 수 있다.

--------------------------------------------------------------------------------------------------------------

> ## 람다 표현식을 조합할 수 있는 유용한 메서드.

### 다양한 유틸리티 메서드.
- 자바8 API의 몇몇 함수형 인터페이스에는 다양한 유틸리티 메서드를 포함한다.
- 이런 메서드들은 함수형 인터페이스에 default 메서드들로 정의되어 있다.
- 디폴트 메서드의 자세한 내용은 9장에서 설명한다.

### Comparator 조합.
      // 순차 정렬.
      Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
      
      // 역정렬.
      inventory.sort(comparaing(Apple::getWeight).reversed());
- Comparator 에는 reverse 라는 디폴트 메서드를 제공한다.

### Comparator 연결.
      // 예시 코드.
      inventory.sort(comparing(Apple::getWeight)
                  .reversed
                  .thenComparing(Apple::getCountry));
- 두 사과의 무게가 같은 경우 새로운 조건을 추가할 수 있다.

### Predicate 조합.
      // 예시 코드.
      Predicate<Apple> test = redApple.and(apple -> aplle.getWeight >150)
                           .or(apple -> GREEN.equals(a.getColor());
- true, false를 반환하는 조건식을 여러개 적용할 수 있다.
- negate(역), or, and 디폴트 메서드를 가진다.

### Function 조합.
      // 예시 코드.
      Function<Integer, Integer> f = x -> x + 1;
      Function<Integer, Integer> g = x -> x * 2;
      Function<Integer, Integer> h = f.andThen(g);
      int result = h.apply(1);
- andThen()은 g(f(x))를 의미하고, compose()는 f(g(x))를 의미한다.

--------------------------------------------------------------------------------------------------------------

> ## 비슷한 수학적 개념.























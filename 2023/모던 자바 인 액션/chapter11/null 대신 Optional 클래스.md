
# null 대신 Optional 클래스.

-------------------------------------------------------------------------------------------------------------------------------

> ## 값이 없는 상황을 어떻게 처리할까?

### null 때문에 발생하는 문제.
1. 에러의 근원이다.
   - NullPointerException은 자바에서 가장 흔히 발생하는 에러다.
2. 코드를 어지럽힌다.
   - 때로는 중첩된 null 확인 코드를 추가해야 하므로 null 때문에 코드 가독성이 떨어진다.
3. 아무 의미가 없다.
   - null은 아무 의미도 표현하지 않는다.
   - 특히, 정적 형식 언어에서 값이 없음을 표현하는 방법으로는 적절하지 않다.
4. 자바 철학에 위배된다.
   - 자바는 개발자로부터 모든 포인터를 숨겼다.
   - 하지만 예외가 있는데 그것이 바로 null 포인터다.
5. 형식 시스템에 구멍을 만든다.
   - null은 무형식이며 정보를 포함하고 있지 않으므로 모든 참조 형식에 null을 할당할 수 있다.
   - 이런 식으로 null이 할당되기 시작하면서 시스템의 다른 부분으로 null이 퍼졌을 때 애초에 null이 어떤 의미로 사용되었는지 알 수 없다.


### 다른 언어는 null 대신 무얼 사용하나?
    def carInsuranceName = person?.car?.insurance?.name
- 그리비 같은 언어에서는 안전 내비게이션 연산자(safe navigation operation) '?.'을 도입해서 null 문제를 해결했다.

-------------------------------------------------------------------------------------------------------------------------------

> ## Optional 클래스 소개.

### Optional.
- 자바8은 하스켈과 스칼라의 영향을 받아서 java.util.Optional<T>라는 새로운 클래스를 제공한다.
- Optional은 선택형값을 캡슐화하는 클래스다.


### Optional 적용.
- Optional<T>를 사용하면 모델의 의미 semantic이 더 명확해졌음을 확인할 수 있다. 
- Optional을 사용하면 null일 수도 혹은 아닐 수도 있음을 나타낸다.
- Optional이 아닌 일반 타입은 null일 수 없는 값을 나타낸다.

-------------------------------------------------------------------------------------------------------------------------------

> ## Optional 적용 패턴.

### 빈 Optional.
      Optional<Car> optCar = Optional.empty();
- 정적 팩터리 메서드 Optional.empty()로 빈 Optional 객체를 얻을 수 있다.


### null이 아닌 값으로 Optional 만들기.
      Optional<Car> optCar = Optional.of(Car);
- 정적 팩터리 메서드 Optional.of()로 null이 아닌 값을 포함하는 Optional을 만들 수 있다.
- car가 null이라면 즉시 NullPointerException이 발생한다.


### null값으로 Optional 만들기.
      Optional<Car> optCar = Optional.ofNullable(car);
- 정적 팩터리 메서드 Optional.ofNullable로 null값을 저장할 수 있는 Optional을 만들 수 있다.
- car가 null인 경우 빈 Optional 객체가 반환된다.


### Optional map 연산.
      Optional<Insurance> optInsurance = Optional.ofNullable(insurnace);
      Optional<String> name = optInsurance.map(Insurance::getName);
- Optional의 map() 메서드는 스트림의 map()메서드와 개념적으로 비슷하다.
- Optional 객체는 최대 요소의 개수가 1개 이하인 데이터 컬렉션으로 생각할 수 있다.
- Optional이 비어있으면 아무 일도 일어나지 않는다.


### Optional flatMap.
      // 오류 발생 코드.
      Optional<Person> optPerson = Optional.of(person);
      Optional<String> name = optPerson.map(Person::getCar)
                                       .map(Car::getInsurance)
                                       .map(Insurance::getName);

      // 정상 코드.
      Optional<person> optPerson = Optional.of(person);
      Optional<String> name = optPerson.flatMap(Person::getCar)
                                       .flatMap(Car::getInsurance)
                                       .flatMap(Insurance:getName);
- flatMap()을 사용하면 n차원의 Optional을 하나의 Optional로 바꿔준다. 


### orElse() 메서드.
      Optional<Person> optPerson = Optional.of(person);
      String name = optPerson.flatMap(Person::getCar)
                                 .flatMap(Car::getInsurance)
                                 .map(Insurance::getName)
                                 .orElse("Unknown");


### 도메인 모델에 Optional을 사용했을 때 데이터를 직렬화할 수 없는 이유.
- Optional 클래스는 필드 형식으로 사용할 것을 가정하지 않았으므로 Serializable 인터페이스를 구현하지 않는다.
- 자바 언어 아키텍트인 브라이언 고츠는 Optional의 용도가 선택형 반환값을 지원하는 것이라고 명확하게 못 박았다.
- 직렬화 모델이 필요하면 Optional로 값을 반환받을 수 있는 메서드를 추가하는 방식을 권장한다.


### Optional 스트림 조작.
      List<Person> personList = new ArrayList<>();
      personList.stream()
               .map(Person::getCar)
               .map(optCar -> optCar.flatMap(Car::gerInsurance))
               .map(optIns -> optIns.map(Insurance::gerName))
               .flatMap(Optional::stream)
               .collect(toSet());
- Optional을 포함하는 스트림을 쉽게 처리할 수 있도록 Optional에 stream() 메서드를 추가했다.
- Optional 스트림을 값을 가진 스트림으로 변환할 때 이 기능을 유용하게 활용할 수 있다.


### Optional의 다양한 메서드.
- get()
  - 값을 읽는 가장 간단한 메서드.
  - 가장 안전하지 않은 메서드.
  - 값이 있으면 해당 값을 반환하고, 값이 없으면 NoSuchElementException을 발생시킨다.
- orElse(T other)
  - Optional에 값이 없는 경우 기본값을 제공.
- orElseGet(Supplier<? extends T> other)
  - orElse() 메서드에 대응하는 게으른 버전의 메서드다.
  - Optional에 값이 없는 경우 Supplier가 실행된다.
  - 디폴트 메서드를 만드는 데 시간이 걸리거나 Optional이 비어있을 떄만 기본값을 생성하고 싶은 경우 사용한다.
- orElseThrow(Supplier<? extends X> exceptionSupplier)
  - Optional에 값이 없는 경우 Supplier 예외를 발생시킨다.
- ifPresent(Consumer<? super T> consumer)
  - 값이 존재할 때 인수로 넘겨준 동작을 실행할 수 있따.
  - 값이 없으면 아무 일도 일어나지 않는다.
- ifPresentOrElse(Cunsumer<? super T> action, Runnable emptyAction)
  - 값이 존재하면 action이 동작한다.
  - 값이 존재하지 않으면 emptyAction이 동작한다.


### 필터로 특정값 거르기.
    Optional<Insurance> optInsurance = ...;
    optInsurance.filter(insurance -> "CambridgeInsurance.equals(insurance.getName()))
                    .if(Present(x-> System.out.println("ok"));
- Optional의 filter() 메서드는 프레디케이트를 인수로 받는다.
- 객체가 값을 가지며 프레디케이트와 일치하면 그 값을 반환하고, 그렇지 않으면 빈 Optional 객체를 반환한다.

-------------------------------------------------------------------------------------------------------------------------------

> ## Optional을 사용한 실용 예제.

### 잠재적으로 null이 될 수 있는 대상을 Optional로 감싸기.
    // 기존 코드.
    Object value = map.get("key");

    // Optional 사용 코드.
    Optional<Object> value = Optional.ofNullable(map.get("key"))
    value.get().orElse(기본값);


### 예외와 Optional 클래스.
    try{
        return Optional.of(Integer.parseInt(s));
    } catch(NumberFormatException e) {
        return Optional.empty();
    }
- 정수를 변환할 수 없는 문자열을 받은 경우 빈 Optional을 반환하도록 할 수 있다.
- try/catch문을 사용하지 않아도 된다.


### 기본형 Optional을 사용하지 말아야 하는 이유.
- 스트림처럼 OptionalInt, OptionalLong, OptionalDouble 등의 기본형 클래스를 제공한다.
- Optional의 최대 요소 수가 한 개 이기 때문에 기본형 특화 클래스로 성능을 개선할 수 없다.
- 기본형 Optional은 다른 Optional과 혼용할 수 없다.


### 정리.
- 역사적으로 프로그래밍 언어에서는 null 참조로 값이 없는 상황을 표현햅왔다.
- 자바 8에서는 값이 있거나 없음을 표현할 수 있는 클래스 java.util.Optional<T>를 제공한다.
- 팩터리 메서드 empty(), of(), ofNullable 등을 이용해서 Optional 객체를 만들 수 있다.
- Optional 클래스는 스트림과 비슷한 연산을 수행하는 map(), flatMap(), filter() 등의 메서드를 제공한다.
- Optional로 값이 없는 상황을 적절하게 처리하도록 강제할 수 있다.
- Optional을 활용하면 더 좋은 API를 설계할 수 있다.



















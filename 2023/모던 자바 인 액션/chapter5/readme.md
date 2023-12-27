
# 스트림 활용.

--------------------------------------------------------------------------------------------------------------------------------

> ## 필터링.

### 프레디케이트로 필터링. (filter)
    List<Dish> test = menu.stream()
                        .filter( Dish::isVegetarian)
                        .collect(toList());
- filter 메서드는 Predicate<T>를 인수로 받아서 일치하는 모든 요소를 포함하는 스트림을 반환한다.

### 고유 요소 필터링. (distinct)
    List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
    number.stream()
            .filter( i-> i%2 == 0)
            .distinct()
            .forEach(System.out::println);
- distinct 메서드는 고유 요소로 일워진 스트림을 반환한다.
- 고유 여부는 스트림에서 만든 객체의 hashCode, equals로 결정된다.

--------------------------------------------------------------------------------------------------------------------------------

> ## 스트림 슬라이싱.

### 스트림 요소를 선택하거나 스킵하는 방법.
1. 프레디케이트를 이용한 방법.
2. 스트림의 처음 몇 개의 요소를 무시하는 방법.
3. 특정 크기로 스트림을 줄이는 방법.
4. 기타 등등.

### 프레디케이트를 이용한 슬라이싱. (takeWhile)
    List<Dish slicedMenu = specialMenu.stream()
                        .takeWhile( idsh -> dish.getCalories() < 320 )
                        .collect(toList());
- filter 연산을 사용하면 전체 스트림을 반복하면서 Predicate를 적용한다.
- 프레디케이트가 처음으로 true가 되는 지점까지 요소를 버린다.
- true가 되면 그 지점에서 작업을 중단하고 남은 모든 요소를 반환한다.

### dropwhile 활용.
    List<Dish> slicedMenu = specialMenu.stream()
                        .dropWhile(dish -> dish.getCalories() <320)
                        .collect(toList());
- takeWhile과 정반대의 작업을 수행한다.
- 프레디케이트가 처음으로 false가 되는 지점까지 요소를 버린다.
- false가 되면 그 지점에서 작업을 중단하고 남은 모든 요소를 반환한다.
- dropWhile은 무한한 남은 요소를 가진 무한 스트림에서도 동작한다.

### 스트림 축소. (limit)
    List<Dish dishes = menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .limit(3)
                        .collect(toList());
- 스트림 순서대로 요소 n개를 반환할 수 있다.

### 요소 건너띄기. (skip)
    List<Dish> dished = menu.stream()
                        .skip(2)
                        .collect(toList());
- 처음 n개 요소를 제외한 스트림을 반환하는 skip(n) 메서드를 지원한다.
- n개 이하의 요소를 포함하는 스트림에 skip(n)을 호출하면 빈 스트림이 반환된다.
- limit(n)과 skip(n)은 서로 상호 보완적인 연산을 수행한다.

--------------------------------------------------------------------------------------------------------------------------------

> ## 매핑.

### 스트림의 각 요소에 함수 적용하기. (map)
    List<String> dishNames = menu.stream()
                            .map(Dish::getName)
                            .collect(toList());
- 스트림은 함수를 인수로 받는 map 메서드를 지원한다.
- 인수로 제공된 함수는 각 요소에 적용되며 함수를 적용한 결과가 새로운 요소로 매핑된다.

### java.util.Arrays 클래스.
- 배열을 다루기 위한 다양한 메소드가 포함되어 있다.
- Arrays 클래스의 모든 메서드는 static method이다.
- stream(T[] array) : 배열을 매개변수로 받아 Stream<T>를 반환하는 메서드. 

### 스트림 평면화. (flatMap)
    List<String> char = Arrays.stream(str)
                    .map(word -> word.split("")
                    .flatMap(Arrays::stream)
                    .distinct()
                    .collect(toList());
- flatMap 메서드는 스트림의 각 값을 다른 스트림으로 ㅂ만든 다음에 모든 스트림을 하나의 스트림으로 연결하는 기능을 수행한다.

--------------------------------------------------------------------------------------------------------------------------------

> ## 검색과 매칭.

### 프레디케이트가 적어도 한 요소와 일치하는지 확인. (anyMatch)
    if(menu.stream().anyMatch(Dish::isVegetarian) {
        ...
    }
- 프레디케이트가 주어진 슽트림에서 적어도 한 요소와 일치하는지 확인할 때 anyMatch 메서드를 이용한다.
- 쇼트서킷 기법을 사용한다.

### 프레디케이트가 모든 요소와 일치하는지 검사. (allMatch)
    boolean isHealthy = menu.stream().allmatch( dish -> dish.getCalories() < 1000 );
- 스트림의 모든 요소가 주어진 프레디케이트와 일치하는지 검사한다.
- 쇼트서킷 기법을 사용한다.

### 프레디케이트가 모든 요소와 일치하지 않는지 검사. (noneMatch)
    boolean isHealthy = menu.stream().noneMatch( d -> d.getCalories() >= 1000 );
- 스트림의 모든 요소가 주어진 프레디케이트와 일치하지 않는지 검사한다.
- 쇼트서킷 기법을 사용한다.

### 쇼트서킷 평가.
- 표현식에서 하나라도 거짓이라는 결과가나오면 나머지 표현식의 결과와 상관없이 전체 결과가 결정되는 경우 나머지 표현식을 수행하지 않는 방법.
- 무한한 요소를 가진 스트림을 유한한 크기로 줄일 수 있는 유용한 연산이다.

### 요소 검색. (findAny)
    Optional<Dish dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
- 내부적으로 단일 과정으로 실행할 수 있도록 최적화한다.
- 쇼트서킷을 이용해서 결과를 찾는 즉시 실행을 종료한다.

### Optional 클래스.
- 값의 존재나 부재 여부를 표현하는 컨테이너 클래스.
- null을 반환할 수 있는 상황에 사용해서 null인 경우 어떠한 조치를 취할 수 있도록 만들 수 있다.
- isPresent() : Optional이 값을 포함하면 true를 반환하고, 값을 포함하지 않으면 false를 반환한다.
- ifPresent(Consumer<T> t) : 값이 있으면 주어진 블록을 실행한다.
- get() : 값이 존재하면 값을 반환하고, 값이 없으면 NoSuchElementException을 발생시킨다.
- orElse(T other) : 값이 있으면 값을 반환하고, 값이 없으면 기본값(other)을 반환한다.

### 첫 번째 요소 찾기. (findFirst)
    Optional<Integer> test = numbers.stream()
                        .map(n -> n*n)
                        .filter(n -> n%3 == 0)
                        .findFirst();
- 논리적인 아이템 순서가 정해져 있는 경우 첫 번째 요소를 찾을 때 사용한다.

### findFirst와 findAny는 언제 사용하나.
- 병렬 실행에서는 첫 번째 요소를 찾기 어렵다. 요소의 반환 순서가 상관없다면 병렬 스트림에서는 findAny를 사용한다.

--------------------------------------------------------------------------------------------------------------------------------

> ## 리듀싱.

### 리듀싱 연산.
- 모든 스트림 요소를 처리해서 값으로 도출하는 연산.
- 함수형 프로그래밍 언어 용어로는 이 과정이 마치 종이를 작은 조각이 될 때까지 반복해서 접는 것과 비슷하다는 의미로 '폴드'라고 부른다.

### 요소의 합. (reduce)
    int sum = numbes.stream().reduce(0, (a,b) -> a+b);
- reduce()의 인자로 '초기값'과 '계산식(BinaryOperation)'을 받는다.
- 초기값을 받지 않도록 오버로드된 reduce는 Optional 객체를 반환한다.

### 최대값과 최솟값. (reduce 활용)
    Optional<Integer> max = numbers.stream().reduce(Integer::max);
    Optional<Integer> min = numbers.stream().reduce(Integer::min);
- 모든 요소를 사용해서 max/min 값과 새로운 요소를 비교한다.

### reduce 메서드의 장점과 병렬화.
- reduce를 이용하면 내부 반복이 추상화되면서 내부 구현에서 병렬로 reduce를 실행할 수 있게 된다.
- 일반적인 반복 합계에서는 sum 변수를 공유해야 하므로 쉽게 병렬화하기 어렵다.

### 스트림 연산 : 상태 없음과 상태 있음.
- 상태 없음 stateless operation.
  - map/filter 등은 입력 스트림에서 각 요소를 받아 0 또는 결과를 출력 스트림으로 내보낸다.
  - 사용자가 제공한 람다나 메서드 참조가 내부적인 가변 상태를 갖지 않는다는 가정하에 보통 상태가 없는 내부 상태를 갖지 않는 연산이다.
- 내부 상태의 크기 한정 bounded.
  - reduce/sum/max 같은 연산은 결과를 누적할 내부 상태가 필요하다.
  - 스트림에서 처리하는 요소 수와 관계없이 내부 상태의 크기가 한정되어 있는 경우를 의미한다.
- 내부 상태를 갖는 연산 stateful operation.
  - sorted/distinct 같은 연산은 요소를 정렬하거나 중복을 제거하려면 과거의 이력을 알고 있어야 한다.
  - 예를 들어 어떤 요소를 출력 스트림으로 추가하려면 모든 요소가 버퍼에 추가되어 있어야 한다.
  - 연산을 수행하는 데 필요한 저장소 크기가 정해져 있지 않기 때문에 데이터 스트림의 크기가 크거나 무한이라면 문제가 생길 수 있다.

--------------------------------------------------------------------------------------------------------------------------------

> ## 숫자형 스트림.

### 기본형 특화 스트림 primitive stream specialization.
- 스트림 API 숫자 스트림을 효율적으로 처리할 수 있도록 기본형 특화 스트림을 제공한다.
- 기본형을 그냥 사용할 경우 박싱/언박싱하는 비용이 발생한다.

### 숫자 스트림으로 매핑 - 특화 스트림.
    int calories = menu.stream()
            .mapToInt(Dish::getCalories)
            .sum();
- 일반 스트림을 기본형 타입을 사용하는 특화 스트림으로 변형한다. 
- mapToInt, mapToDouble, mapToLong 세 가지 메서드를 가장 많이 사용한다.
- 이들 메서드는 map과 정확히 같은 기능을 수행하지만 Stream<T> 대신 특화된 스트림을 반환한다. (IntStream, DoubleStream, LongStream)
- 특화 스트림에서 제공하는 sum() 메서드는 스트림 내부의 요소의 합을 구할 수 있다. (스트림이 비어있으면 0을 반환한다)
- max, min, average 등 다양한 유틸리티 메서드도 지원한다.

### 객체 스트림으로 복원하기 - boxed()
    IntStream intStream = menu.stream.mapToInt(Dish::getCalories);
    Stream<Integer> stream = intStream.boxed();
- boxed() 메서드를 사용하여 특화된 스트림을 일반 스트림으로 변환하는 방법.
- IntStream은 IntUnaryOperator를 인수로 받기 때문에 int를 인수로 받아서 int를 반환하는 연산밖에 할 수 없다.
- 이러한 문제점을 해결하기 위해 일반 스트림으로 변환하는 방법이 제공된다.

### OptionalInt - Optional 특화 스트림.
    OptionalInt maxCalories = menu.stream()
                  .mapToInt(Dish::getCalories)
                  .max();
    // 1이면 값이 없음을 나타냄.
    maxCalories.orElse(1);            
- Optional 스트림은 특화된 스트림 형태인 OptionalInt, OptionalDouble, OptionalLong을 제공한다.

### 숫자 범위 - rangeClosed().
    IntStream evenNumbers = IntStream.rageClosed(1, 100)
                    .filter(n -> n%2 == 0);
    System.out.printlng(evenNumbers.count);
- range()와 rangeClosed()는 시작값과, 종료값을 인수를 받는 메서드이다.
- range()는 시작값과 종료값이 결과에 포함되지 않는다.
- rangeClosed()는 시작값과 종료값이 결과에 포함된다는 뜻이다.

### 숫자 스트림 활용 - 피타고라스 수.
    Int[] numbers = {3,4,5};

--------------------------------------------------------------------------------------------------------------------------------

> ## 스트림 만들기.

### 값으로 스트림 만들기 - of()
    // 값으로 스트림 만들기.
    Stream<String> stream = Stream.of("Modern", "Java", "in " , "Action");
    stream.map(String::toUpperCase)
            .forEach(System.out::println);

    // 스트림 비우기.
    Stream<String> emptyStream = Stream.empty();

### null이 될 수 있는 객체로 스트림 만들기 - ofNullable()
    // ofNullable()이 없었을 때.
    Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(value);

    // ofNullable() 사용방법 -> 프로퍼티 중에 home이 없으면 null을 반환.
    Stream<String> values = Stream.of(System.getProperty("home"));

### 배열로 스트림 만들기.
    int[] numbers = { 2,3,5,7,..., 13 };
    int sum = Arrays.stream(numbers).sum();

### 파일로 스트림 만들기.
    long uniqueWords = 0;
    try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
      uniqueWorks = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                        .distinct()
                        .count();
    } catch (IOException e) {
      ...
    }
- Files.lines로 파일의 각 행 요소를 반환하는 스트림을 얻을 수 있다.

### 함수로 무한 스트림 만들기 - iterate
    // iterate 메서드.
    Stream.iterate(0, n -> n + 2)
          .limit(10)
          .forEach(System.out::println);

    // interate Predicate<T> 활용.
    IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);
- 스트림 API는 함수에서 스트림을 만들 수 있는 두 정적 메서드 iterate()와 generate()를 제공한다.
- 두 메서드를 통해 무한 스트림 infinite stream, 크기가 고정되지 않은 스트림을 만들 수 있다.
- 보통 limit()와 함께 사용해서 무한한 값을 연산하지 않도록 사용한다.
- iterate() 메서드는 초깃값과 UnaryOperator<T>를 인수를 받아서 새로운 값을 끊임없이 생산할 수 있다.
- iterate() 메서드는 두 번째 인수로 프레디케이트를 받아 언제까지 작업을 수행할 것인지의 기준으로 사용할 수 있다.
- 무한 스트림을 종료하기 위해서는 filter()는 불가능하고, takeWhile()을 사용해야 한다.

### 언바운드 스트림 unbounded stream.
- 기존 결과에 의존해서 순차적으로 연산을 수행한다.
- iterate()는 요청할 때마다 값을 생산할 수 있으며 끝이 없으므로 무한 스트림을 만드는데, 이러한 스트림을 언바운드 스트림이라고 한다.

### 함수로 무한 스트림 만들기 - generate.
    Stream.generate(Math::random)
            .limit(5)
            .forEach(System.out::println);

    Stream.generate(() -> 1);

- generate()도 요구할 때 값을 계산하는 무한 스트림을 만들 수 있다.
- generate()는 생상된 각 값을 연속적으로 계산하지 않는다.
- generate()는 Supplier<T>를 인수로 받아서 새로운 값을 생산한다.

### 불변 상태 immutable.
- 기존의 상태의 값을 바꾸지 않는 것을 의미한다.
- 멀티 쓰레드 환경에서는 불변 상태 기법을 고수해야 한다. (7장에서 자세히 다룸)

--------------------------------------------------------------------------------------------------------------------------------

> ## 마치며.

### 정리.
- 스트림 API를 이용하면 복잡한 데이터 처리 질의를 표현할 수 있다.
- filter(), distinct(), takeWhile(), dropWhile(), skip(),, limit() 메서드로 스트림을 필터링하거나 자를 수 있다.
- 소스가 정렬되어 있다는 사실을 알고 있을 때 takeWhile(), dropWhile() 메서드를 효과적으로 사용할 수 있다.
- map, flatMap 메서드로 스트림의 요소를 추출하거나 변환할 수 있다.
- findFirst, findAny 메서드로 스트림의 요소를 검색할 수 있다.
- allMatch, noneMatch, anyMatch 메서드를 이용해서 주어진 프레디케이트와 일치하는 요소를 스트림에서 검색할 수 있다.
- 이들 메서드는 쇼트서킷 short-circuit, 즉 결과를 찾는 즉시 반환하며, 전체 스트림을 처리하지는 않는다.
- reduce 메서드로 스트림의 모든 요소를 반복 조합하며 값을 도출할 수 있다.
- filter(), map() 등은 상태를 저장하지 않는 상태 없는 연산 stateless operation이다.
- reduce 같은 연산은 값을 계산하는 데 필요한 상태를 저장한다.
- sorted, distinct 등의 메서드는 새로운 스트림을 반환하기에 앞서 스트림의 모든 요소를 버퍼에 저장해야 한다. (상태 있는 연산 stateful operation)
- IntStream, DoubleStream, LongStream은 기본형 특화 스트림이다.
- 컬렉션뿐 아니라 값, 배열, 파일, iterate와 generate 같은 메서드로도 스트림을 만들 수 있다.
- 무한한 개수의 요소를 가진 스트림을 무한 스트림이라고 한다.

























# 컬렉션 API 개선.

-----------------------------------------------------------------------------------------------------------------------------------

> ## 컬렉션 팩터리.

### UnsupportedOperationException 예시 코드.
    List<String> list = Arrays.asList("Raphael", "Olivia");
    list.add("Thibaut");                                        // 예외 발생.
- Arrays.asList() 팩터리 메서드를 이용하면 코드를 간단하게 줄일 수 있지만, 고정 크기의 리스트를 만들어서 예외가 발생한다.

### UnsupportedOperationException 예외 발생.
- 고정된 크기의 배열을 생성한 후, 추가 작업을 하는 경우에 발생하는 예외이다.

### 컬렉션 팩터리 메서드.
- List.of(), Arrays.asList(), Set.of() 등을 의미한다.
- null 요소를 넣으면 NullPointerException이 발생한다.
- 해당 컬렉션에 add() 메서드를 사용하는 경우 UnsupportedOperationException이 발생한다.

### 컬렉션 팩터리 장점.
- 데이터 처리 형식을 설정하거나 데이터를 변환할 필요가 없다면 사용하기 간편한 팩터리 메서드를 이용할 것을 권장한다.
- 팩터리 메서드 구현이 더 단순하고 목적을 달성하는데 충분하기 때문이다.

-----------------------------------------------------------------------------------------------------------------------------------

> ## 집합 팩터리.

### 집합 팩터리 예시.
    Set<String> friends = Set.of("Raphael", "hi");
    System.out.println(friends);
- 중복된 요소를 제공해 집합을 만들려고 하면 IllegalArgumentException이 발생한다.
- 집합은 오직 고유의 요소만ㄴ 포함할 수 있다는 원칙을 상기시킨다.

-----------------------------------------------------------------------------------------------------------------------------------

> ## 맵 팩토리.

### 맵 팩터리 예시.
    // 1번 방법.
    Map<String, Integer> ageOfFriends = Map.of("hi", 30, "Olivaia", 25);

    // 2번 방법.
    Map<String, Integer> ageOfFriends = Map.ofEntries(Map.entry("Raphael", 30), Map.entry("Olivia", 25));
- 맵을 만드는 것은 집합, 리스트에 비해 조금 복잡한데 맵을 만들려면 키와 값이 있어야 하기 때문이다.
- 열 개 이하의 키와 값 쌍을 가진 작은 맵을 만들 때는 이 메서드가 유용하다.
- 그 이상의 맵에서는 Map.Entry<K,V> 객체를 인수로 받으며 가변 인수로 구현된 Map.ofEntries 팩터리 메서드를 이용하는 것이 좋다.

-----------------------------------------------------------------------------------------------------------------------------------

> ## 리스트와 집합 처리.

### 자바 8에 List, Set 추가된 메서드.
- removeIf()
  - 프레디케이트를 만족하는 요소를 제거한다.
  - List, Set을 구현하거나 그 구현을 상속받은 모든 클래스에서 사용 가능.
- replaceAll().
  - 리스트에서 이용할 수 있는 기능으로 UnaryOperator 함수를 이용해 요소를 바꾼다.
- sort().
  - List 인터페이스에서 제공하는 기능으로 리스트를 정렬한다.

### removeIf 메서드 필요 이유.
    for(Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext(); ) {
        Transaction transaction = iterator.next();
        if(Character.isDigit(transaction.getReferenceCode().charAt(0))) {
            transactions.remove(transaction);
        }
    }
- Iterator 객체, next(), hasNext()를 이용해 소스를 질의한다.
- Collection 객체 자체, remove()를 호출해 요소를 제거한다.
- 결과적으로 반복자의 상태는 컬렉션의 상태와 서로 동기화되지 않는다.
- Iterator 객체를 명시적으로 사용하고 그 객체의 remove() 메서드를 호출함으로 이 문제를 해결할 수 있다.

### removeIf 메서드.
    // 동시성 문제 해결 코드.
    for(Iterator<Transaction> iterator = tansactions.iterator(); iterator.hasNext(); ) {
        Transaction transaction = iterator.next();
        if(Character.isDigit(transaction.getReferenceCode().charAt(0))) {
            iterator.remove();
        }
    }
    
    // removeIf 메서드 사용 코드.
    transactions.removeIf( transaction -> Charater.isDigit(transaction.getReferenceCode().charAt(0)));

### replaceAll 메서드 필요 이유.
    referenceCodes.stream()
            .map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
            .collect(Collectors.toList())
            .forEach(System.out::println);
- 이 코드는 새 문자열 컬렉션을 만든다.
- 우리가 원하는 것은 기존 컬렉션을 바꾸는 것이다.
- ListIterator 객체를 이용해 기존 컬렉션을 바꿀 수 있다.

### replaceAll 메서드.
    // 새로운 컬렉션 만들지 않도록 변경.
    for(ListIterator<String> iterator = referenceCodes.listIterator(); iterator.hasNext();) {
        String code = iterator.next();
        iterator.set(Charater.toUpperCase(code.charAt(0)) + code.substring(1)); 
    }

    // replaceAll 메서드 사용.
    referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));
- 기존 컬렉션을 바꾸는 방법.

### 주의사항.
- 컬렉션 객체를 Iterator 객체와 혼용하면 반복과 컬렉션 변경이 동시에 이루어지면서 쉽게 문제를 일으킨다.

-----------------------------------------------------------------------------------------------------------------------------------

> ## 맵 처리.

### 개요.
- 자바 8에서 Map 인터페이스에 몇 가지 디폴트 메서드를 추가했다.
- 디폴트 메서드는 13장에서 자세히 다룬다.
- 여기서는 디폴트 메서드가 기본적인 구현을 인터페이스에 젝오하는 기능 정도로 생각해두자.

### forEach 메서드.
    for(Map.Entry<String,Integer> entry : ageOfFriends.entrySet()) {
        String friends = entry.getKey();
        Integer age = entry.getValue();
        System.out.println( friend + age );
    }
- 맵에서 키와 값을 반복하면서 확인하는 작업은 잘 알려진 귀찮은 작업 중 하나다.
- BiConsumer(키와 값)을 인수로 받는 forEach() 메서드를 통해 쉽게 처리할 수 있다.

### 정렬 메서드.
    // Entry.comparingByKey / Entry.comparingByValue()
    Map<String, String> favouriteMovies = Map.ofEntries( entry( "hi", "hi"), entry( "hello", "hello"));
    favouriteMovies.entrySet().stream()
                        .sorted(Entry.comparingByKey())
                        .forEachOrdered(System.out::println);
- Comparing 역할을 수행한다.

### forEach(), forEachOrdered().
- forEach() : 병렬 스트림에서 순서 보장이 안됨.
- forEachOrdered() : 병렬 스트림에서 순서 보장이 된다.

### HashMap 성능.
- 자바 8에서 HashMap의 내부 구조를 바꿔 성능을 개선했다.
  - 기존 맵의 항목은 키로 생성한 해시코드로 접근할 수 있는 버켓을 저장했다.
    - 많은 키가 같은 해시코드를 반환하는 상황이 되면 O(n)의 시간이 걸리는 LinkedList로 버킷을 반환해야 하므로 성능이 저하된다.
  - 최근에는 버켓이 너무 커질 경우 O(log(N))의 시간이 소요되는 정렬된 트리를 이용해 동적으로 치환해 충돌이 일어나는 요소 반환 성능을 개선.
  - 하지만 키가 String, Number 클래스 같은 Comparable 형태여야만 정렬된 트리가 지원된다.

### getOrDefault 메서드.
    Map<String, String> favouriteMovies = Map.orEnties( Map.entry("hi", "hi"), Map.entry("hello", "hello"));
    favouriteMovies.getOrDefault("Kim", "Matrix");
- getOrDefault() 메서드의 첫 번째 인수로 키를, 두 번째 인수로 기본값을 받는다.
- 인수로 받은 키 값이 맵에 존재하지 않으면 두 번재 인자로 받은 기본 값을 반환한다.
- 키가 존재하더라도 값이 널인 상황에서는 널을 반환한다.

### 계산 패턴.
    Map<String, byte[]> dataToHash = new HashMap<>();
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    lines.forEach(line -> dataToHash.computeIfAbsent(line, this::calculateDigest));

    private byte[] calculateDigest(String key) {
        return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
    }
- computeIfAbsent : 제공된 키에 해당하는 값이 없으면, 키를 이용해 새 값을 계산하고 맵에 추가한다.
- computeIfPresent : 제공된 키가 존재하면 새 값을 계산하고 맵에 추가한다.
- compute : 제공된 키로 새 값을 계산하고 맵에 저장한다.

### 삭제 패턴.
    // 기존 방식.
    String key = "hi";
    String value = hello";
    if(favouriteMovies.containkey(key) && Objects.equals(favouriteMovies.get(key), value) {
      favoriteMovies.remove(key);
      return true;
    } else {
      return false;
    }

    // remove() 메서드를 사용하는 방식.
    favouriteMovies.remove(key, value);

### 교체 패턴.
    Map<String, String> map = new HashMap<>();
    map.put("hi", "hi");
    map.replaceAll((str1, str2) -> str1 + str2.toUpperCase());
- replaceAll().
  - BiFunction을 적용한 결과로 각 항목의 값을 교체한다.
  - List replaceAll()과 비슷한 동작을 수행한다.
- replace.
  - 키가 존재하면 맵의 값을 바꾼다.

### 합침.
    Map<String, String> family = Map.ofEntires(Map.entry("Teo", "hi"), Map.enrty("Cris", "James"));
    Map<String, String> friends = Map.ofEntires(Map.entry("hwa", "hello"), Map.entry("Jae", "good"));
    Map<String, String> all = new HashMap<>(family);
    all.putAll(friends);
- 중복된 키가 없다면 위 코드는 잘 동작한다.
- 값을 좀 더 유연하게 합쳐야 한다면 새로운 merge 메서드를 이용할 수 있다.

### 합침 merge() 사용.
    Map<String, String> family = Map.ofEntires(Map.entry("Teo", "hi"), Map.enrty("Cris", "James"));
    Map<String, String> friends = Map.ofEntires(Map.entry("hwa", "hello"), Map.entry("Jae", "good"));
    Map<String, String> all = new HashMap<>(family);
    friends.forEach((str1, str2) -> all.merge(str1, str2, (movie1, movie2) -> movie1 + " & " + movie2));
- merge().
  - 매개변수1 : 합치려는 Map의 key값.
  - 매개변수2 : 합치려는 Map의 value값.
  - 매개변수3 : 키가 중복될 경우 실행할 함수, (값1, 값2) -> 두 값에 대한 연산 수행.

### merge() 메서드 활용.
    moviesToCount.merge("영화이름", 1L, (key, count) -> count + 1L);
- 매개변수1 : 키 값.
- 매개변수2 : moviesToCount Map에 매개변수1의 키 값이 없는 경우 키와 같이 쌍으로 들어갈 value 값.
- 매개변수3 : 키 값이 중복되는 경우 수행될 함수형 인터페이스.

-----------------------------------------------------------------------------------------------------------------------------------

> ## 개선된 ConcurrentHashMap.

### 개요.
- ConcurrentHashMap 클래스는 동시성 친화적이며 최신 기술을 반영한 HashMap 버전이다.
- 내부 자료구조의 특정 부분만 잠궈 동시 추가, 갱신 작업을 허용한다.
- 동기화된 Hashtable 버전에 비해 읽기 쓰기 연산 성능이 월등하다.
- 참고로, 표준 HashMap은 비동기로 동작함.

### ConcurrentHashMap의 새로운 연산.
- forEach : 각 (키, 값) 쌍에 주어진 액션을 수행.
- reduce : 모든 (키, 값) 쌍을 제공된 리듀스 함수를 이용해 결과로 합침.
- search : 널이 아닌 값을 반환할 때까지 각 (키, 값) 쌍에 함수를 적용.

### 연산의 형태.
- 키, 값으로 연산 (forEach, reduce, search)
- 키로 연산 (forEachKey, reduceKeys, searchKeys)
- 값으로 연산 (forEachValue, reduceValue, searchValue)
- Map.Entry 객체로 연산 (forEachEntry, reduceEntries, searchEntries)

### parallelismThreshold
- 병렬로 작업을 실행하는 데 필요한 요소 수. (병렬 처리의 기준값)
- 500으로 지정한 경우, 요소의 수가 500이하이면 같은 쓰레드에서 처리.

### mappingCount().
- concurrentHashMap에서 size() 대신 사용되는 메서드이다.
- int보다 더 많은 매핑을 포함할 수 있으므로 size() 대신 long을 반환하는 mappingCount()를 사용한다.
- 반환된 값은 추정치이기 때문에, 동시 삽입 또는 제거가 있는 경우 실제 개수가 다를 수 있다.

### KeySetView.
- ConcurrentHashMap을 KeySetView로 반환하는 keySet() 메서드를 제공한다.
- 맵을 바꾸면 집합도 바뀌고 반대로 집합을 바꾸면 맵도 영향을 받는다.




















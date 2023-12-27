
# 새로운 날짜와 시간 API.

-------------------------------------------------------------------------------------------------------------------------------

> ## 개요.

### java.util.Date.
- 오류가 있다.
- 가변 클래스다.
- 자바 1.0에서는 Date 클래스 하나로 날짜와 시간 관련 기능을 제공했다.
- Date 클래스는 특정 시점을 날짜가 아닌 밀리초 단위로 표현한다.
- 1900년을 기준으로 하는 오프셋, 0에서 시작하는 달 인덱스 등 모호한 설계로 유용성이 떨어졌다.
- Date는 JVM 기본시간대인 중앙 유럽 시간 CET(Central European Time)을 사용한다.


### java.util.Calendar.
- 오류가 존재한다.
- 달의 인덱스를 0부터 시작했다.
- 가변 클래스다.


### DateFormat.
- 일부 기능이 Date 클래스에서만 동작했다.
- 쓰레드에 안전하지 않다.


### Joda-Time.
- 부실한 날짜와 시간 라이브러리 때문에 많은 개발자가 Joda-Time같은 서브파티 라이브러리를 사용했다.
- 자바 8에서 Joda-Time의 많은 기능을 java.time 패키지로 추가했다.

-------------------------------------------------------------------------------------------------------------------------------

> ## LocalDate, LocalTime, Instant, Duration, Period 클래스.

### LocalDate
    // 객체 생성 방법.
    LocalDate date = LocalDate.of(2017,9,21);
    LocalDate date2 = LocalDate.now();
    LocalDate date3 = LocalDate.parse("2017-09-21");

    // 사용 방법.
    int year = date.getYear();
    Month month = date.getMonth();
    int day = date.getDaytOfMonth();
    DayOfWeek dow = date.getDayOfWeek();
    int len = date.lengthOfMonth();
    boolean leap = date.isLeapYear();
- LocalDate 인스턴스는 시간을 제외한 날짜를 표현하는 불변객체다.
- LocalDate 객체는 어떤 시간대 정보도 포함하지 않는다.


### LocalTime.
    // 객체 생성 방법.
    LocalTime time = LocalTime.of(13,45,20);
    LocalTime time2 = LocalTime.now();
    LocalTime tim3 = LocalTime.parse("13:45:20");

    int hour = time.getHour();
    int minute = time.getMinute();
    int second = time.getSecond();
- LocalTime 인스턴스는 날짜를 제외한 시간을 표현하는 불변객체다.
- LocalDate와 사용방법이 같다.


### TemporalField, ChronoField.
    int year = date.get(ChronoField.YEAR);
    int month = date.get(ChronoField.MONTH_OF_YEAR);
    int day = date.get(ChronoField.DAY_OF_MONTH);
- TemporalField.
  - 시간 관련 객체에서 어떤 필드의 값에 접근할지 정의하는 인터페이스다.
- ChronoField.
  - TemporalField 인터페이스를 정의하는 열거자이다.


### LocalDateTime : 날짜와 시간 조합.
    // LocalDateTime 생성하기.
    LocalDateTime dt1 = LocalDateTime.of(2017, month.SEPTEMBER, 21, 13, 45, 20);
    LocalDateTime dt2 = LocalDateTime.of(date, time);
    LocalDateTime dt3 = date.atTime(13,45,20);
    LocalDateTime dt4 = date.atTime(time);
    LocalDateTime dt5 = stime.atDate(date);

    // LocalDate, LocalTime 추출.
    LocalDate date1 = dt1.toLocalDate();
    LocalTime time1 = dt1.toLocalTime();


### Instant 클래스 : 기계의 날짜와 시간.
    Instant.ofEpochSecond(3);
    Instant.ofEpochSecond(3,0);
    Instant.ofEpochSecond(2, 1_000_000_000);
    int day = Instant.now().get(Chronofield.DAY_OF_MONTH);
- 기계의 관점에서는 연속된 시간에서 특정 ㅈ3ㅣ점을 하나의 큰 수로 표현하는 것이 가장 자연스러운 시간 표현 방법이다.
- Instant 클래스에서는 기계적인 관점에서 시간을 표현한다.
- 1970년 1월 1일 0시 0분 0초 UTC(유닉스 에포크 시간 unix epoch time)을 기준으로 특정 지점까지의 시간을 초로 표현한다.
- Instant 클래스는 나노초의 정밀도를 제공한다.


### Duration.
    Duration d1 = Duration.between(time1, time2);
    Duration d2 = Duration.between(dateTime1, dateTime2);
    Duration d3 = Duration.between(instant1, instant2);
- Temporal 인터페이스를 구현한 클래스는 특정 시간을 모델링하는 객체의 값을 어떻게 읽고 조작할지 정의한다. 
- Duration 클래스의 정적 팩터리 메서드 between으로 두 시간 객체 사이의 지속시간을 만들 수 있다. (Temporal 인터페이스를 구현한 시간)
- Duration 클래스는 초와 나노초로 시간 단위를 표현하므로 LocalDate를 전달할 수 없다.
- 불변 클래스다.

### Period.
    Period thenDays = Perod.between(date1, date);
- 년/월/일로 날짜를 표현하는 두 시간의 비교는 Period 클래스를 사용한다.
- 다른 특징은 Duration과 같다.
- 불변 클래스다.


### Duration/Period 공통 메서드.
- 정적 메서드.
  - between : 두 시간 사이의 간격을 생성함.
  - from : 시간 단위로 간격을 생성함.
  - of : 주어진 구성 용소에서 간격 인스턴스를 생성함.
  - parse : 문자열을 파싱해서 간격 인스턴스를 생성함.
- 인스턴스 메서드.
  - addTo : 현재값의 복사본을 생성한 다음 지정된 Temporal 객체에 추가함.
  - get : 현재 간격 정보값을 읽음.
  - isNegative : 간격이 음수인지 확인함.
  - isZero : 간격이 0인지 확인함.
  - minus : 현재값에서 주어진 시간을 뺀 복사본을 생성함.
  - multipliedBy : 현재값에 주어진 값을 곱한 복사본을 생성함.
  - negated : 주어진 값의 부호를 반전한 복사본을 생성함.
  - plus : 현재값에 주어진 시간을 더한 복사본을 생성함.
  - subtractFrom : 지정된 Temporal 객체에서 간격을 뺌.

-------------------------------------------------------------------------------------------------------------------------------

> ## 날짜 조정, 파싱, 포매팅.

### withAttribute 메서드.
    LocalDate date1 = LocalDate.of(2017,9,21);
    LocalDate date2 = date1.widthYear(2011);
    LocalDate date3 = date2.withDayOfMonth(25);
    LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 2);
- widthAttribute() 메서드는 Temporal 인터페이스에 정의되어 있다.
- Temporal 인터페이스는 LocalDate, LocalTime, LocalDateTime, Instant처럼 특정 시간을 정의한다.
- with() 메서드를 사용하면 Temporal 객체의 필드값을 수정할 수 있다.
- Temporal 객체가 지정된 필드를 지원하지 않으면 UnsupportedTemporalTypeException이 발생한다.


### Temporal 인터페이스 메서드.
- 정적 메서드.
  - from : 주어진 Temporal 객체를 이용해서 클래스의 인스턴스를 생성함.
  - now : 시스템 시계로 Temporal 객체를 생성함.
  - of : 주어진 구성 요소에서 Temporal 객체의 인스턴스를 생성함.
  - parse : 문자열을 파싱해서 Temporal 객체를 생성함.
- 인스턴스 메서드.
  - atOffset : 시간대 오프셋과 Temporal 객체를 합침.
  - atZone : 시간대 오프셋과 Temporal 객체를 합침.
  - format : 지정된 포매터를 이용해서 Temporal 객체를 문자열로 변환함. (Instant는 지원하지 않음)
  - get : Temporal 객체의 상태를 읽음.
  - minus : 특정 시간을 뺀 Temporal 객체의 복사본을 생성함.
  - plus : 특정 시간을 더한 Temporal 객체의 복사본을 생성함.
  - with : 일부 상태를 바꾼 Temporal 객체의 복사본을 생성함.


### TemporalAdjusters 클래스.
    LocalDate date1 = LocalDate.of(2014,3,18);
    LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
    LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
- TemporalAdjusters 클래스는 with() 메서드에 좀 더 다양한 동작을 수행할 수 있도록 하는 기능을 제공한다.


### TemporalAdjusters 팩터리 메서드.
- dayOfWeekInMonth : 서수 요일에 해당하는 날짜를 반환. (음수를 사용하면 월의 끝에서 거꾸로 계산)
- firstDayOfMonth : 현재 달의 첫 번째 날짜를 반환.
- firstDayOfNextMonth : 다음 달의 첫 번째 날짜를 반환.
- firstDayOfNextYear : 내년의 첫 번째 날짜를 반환.
- firstInMonth : 현재 달의 첫 번째 요일에 해당하는 날짜를 반환.
- lastDayOfMonth : 현재 달의 마지막 날짜를 반환.
- lastDayOfNextMonth : 다음 달의 마지막 날짜를 반환.
- lastDayOfNextYear : 내년의 마지막 날짜를 반환.
- lastInMonth : 현재 달의 마지막 요일에 해당하는 날짜를 반환.
- previous : 현재 달에서 현재 날짜 이후로 지정한 요일이 처음으로 나타나는 날짜를 반환.
- nextOrSame : 현재 날짜 이후로 지정한 요일이 처음/이전으로 나타나는 날짜를 반환.
- previousOrSame : TemporalAdjuster를 반환.


### TemporalAdjuster 인터페이스.
- TemporalAdjusters에 구현되지 않은 기능을 사용해야 하는 경우 TemporalAdjuster 인터페이스를 구현해서 커스텀 할 수 있다.
- TemporalAdjuster 인터페이스는 함수형 인터페이스다.


### java.time.format.
- 날짜와 시간 관련 작업에서 포매팅과 파싱은 서로 떨어질 수 없는 관계다.
- java.time.format은 포매팅과 파싱 전용 패키지이다.
- 이 패키지에서 가장 중요한 클래스는 DateTimeFormatter다.


### DateTimeFormatter.
    // 포매팅
    LocalDate date = LocalDate.of(2014,3,18);
    String str1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);    // 20140318
    String str2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);    // 2014-03-18

    // 파싱
    LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
    LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

    // 패턴 만들기.
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date1 = LocalDate.of(2014,3,18);
    String formattedDate = date1.format(formatter);

    // DateTimeFor
- java.util.DateFormat 클래스와 달리 모든 DateTimeFormatter 클래스는 쓰레드에서 안전하게 사용할 수 있는 클래스다.


### DateTimeFormatterBuilder 클래스.
- 복잡적인 포매터를 정의해서 좀 더 세부적으로 포매터를 제어할 수 있다.
- 대소문자를 구분하는 파싱, 관대한 규칙을 적용하는 파싱, 패딩, 포매터의 선택사항 등을 활용할 수 있다.

-------------------------------------------------------------------------------------------------------------------------------

> ## 다양한 시간대와 캘린더 활용 방법.

### 개요.
- java.time.ZoneId 클래스를 통해 시간대를 간단하게 처리할 수 있다.
- ZoneId는 불변 클래스이다.


### ZoneRules 클래스.
- ZoneRules 클래스에는 40개 정도의 시간대가 있다.
- ZoneID의 getRules() 메서드를 이용해서 해당 시간대의 규정을 획득할 수 있다.


### ZoneId 클래스.
    ZoneId romeZOne = ZOneId.of("Europe/Rome");
    ZoneId zoneId = TimeZone.getDefault().toZoneId();


### ZoneDateTime 클래스.
    // 사용 방법.
    LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
    ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
    ZonedDateTime zdt2 = dateTime.atZone(romeZone);
- LocalDate + LocalTime + ZoneId가 ZoneDateTime 클래스이다.


### ZoneOffset 클래스.
    ZonedOffset newYorkOffset = ZoneOffset.of("-05:00");
- ZonedId를 상속받았다.


### OffsetDateTime 클래스.
    LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
    OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(date, newYorkOffset);
- OffsetDateTime 클래스는 오프셋으로 날짜와 시간을 표현하는 시간을 만드는 방법이다.


### 4가지 캘랜더.
- ThaiBuddhistDate, MinguoDate, JapaneseDate, HijrahDate.
- 위 4개의 클래스와 LocalDate 클래스는 ChronoLocalDate 인터페이스를 구현한다.
- ChronoLocalDate는 임의의 연대기에서 특정 날짜를 표현할 수 있는 기능을 제공하는 인터페이스다.


### JapaneseDate 클래스.
    LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
    JapaneseDate japanesDate = JapaneseDate.from(date);


### ChronoLocalDate.
- 날짜와 시간 API의 설계자는 ChronoLocalDate보다 LocalDate을 사용하기를 권고한다.
- 입출력을 지역화하는 상황을 제외하고는 모든 데이터 저장, 조작, 비즈니스 규칙 해석 등의 작업에서 LocalDate를 사용해야 한다.


### 이슬람력.
- 자바 8에서 추가된 캘린더 중 HijrahDat가 가장 복잡한데, 변형이 있기 때문이다.
- Hijrah 캘린더 시스템은 태음월에 기초한다.
- withVariant() 메서드를 통해 원하는 변형 방법을 선택할 수 있다.


### 정리.
- Date, Calendar 클래스는 결함이 존재했다.
- 새로운 날짜와 시간 API에서 날짜와 시간 객체는 모두 불변이다.
- 새로운 API는 각각 사람과 기계가 편리하게 날짜와 시간 정보를 관리할 수 있도록 두 가지 표현 방식을 제공한다.
- 날짜와 시간 객체를 절대적인 방법과 상대적인 방벙으로 처리할 수 있으며 기존 인스턴스를 변환하지 않도록 처리 결과로 새로운 인스턴스가 생성된다.
- TemporalAdjuster를 이용하면 단순히 값을 바꾸는 것 이상의 복잡한 동작을 수행할 수 있으며 자신만의 커스텀 날짜 변환 기능을 정의할 수 있다.
- 패턴을 이용하거나 프로그램으로 포매터를 만들 수 있으며 포매터는 스레드 안정성을 보장한다.
- 특정 지역/장소에 상대적인 시간대 또는 UTC/GMT 기준의 오프셋을 이용해서 시간대를 정의할 수 있다.
- ISO-8601 표준 시스템을 준수하지 않는 캘린더 시스템도 사용할 수 있다.




















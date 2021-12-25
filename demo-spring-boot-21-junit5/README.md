## JUnit5
- 스프링 부트 2.1에서 JUnit 5 사용하는 방법은 참고만... 실제로는 스프링 부트 2.2+ 버전을 사용할 것!
- JUnit 5, Jupiter 의존성 추가

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <scope>test</scope>
</dependency>
```

- JUnit 4와 JUnit 5의 차이
    * 모든 API의 패키지가 org.junit.jupiter 아래 들어있다.
    * Runner와 Rule을 사용하던 확장 방식이 Extension 모델로 통일 되었다.
    * 람다식을 지원한다.
    * 더 자세한 건 [JUnit 5](https://junit.org/junit5/docs/current/user-guide/) 레퍼런스 참고!

## DataSize
- org.springframework.util.unit.DataSize
  * 스프링 부트가 아니라 스프링 프레임워크가 5.1부터 지원하는 타입으로, 데이터 사이즈 MB, GB 등을 표현하는데 사용할 수 있는 타입니다.
  * 지원하는 타입: B, KB, MB, GB, TB
- 그럼 스프링 부트는 무엇을 지원하느냐? 컨버터를 지원한다.
  * StringToDataSizeConverter
  * NumberToDataSizeConverter
- 그래서? application.properties에서 데이터 사이즈를 손쉽게 바인딩 받을 수 있다.
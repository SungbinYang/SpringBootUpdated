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
## 스프링 부트 2.3 변경 내역 소개
- https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes
- 출시일: 2020년 5월
- 주요 변경 내역
    * 자바 14 지원
    * 의존성과 프로퍼티 변경
    * 효율적인 컨테이너 이미지 생성 방법 제공
    * Liveness와 Readiness
    * Graceful Shutdown 지원
    * Actuator, configprops 엔드포인트

## 의존성 및 프로퍼티 변경
- 의존성 변경
  * Spring-Boot-Starter-Web에서 Spring-Boot-Starter-Validation 모듈을 가져오지 않도록 변경 됨.
  * [Spring Data Neumann](https://spring.io/blog/2020/05/12/spring-data-neumann-goes-ga)
    * 코틀린 코루틴 지원
    * MongoDB, Cassandra, Couchbase SDK, QueryDSL, Elasticsearch 버전 업데이트
    * Spring Data R2DBC 추가
  * [Jackson 2.11](https://github.com/FasterXML/jackson/wiki/Jackson-Release-2.11)
    * Date와 Calendar 기본 포맷 중에 timzone 표현하는 방법이 표준에 맞도록 [변경](https://github.com/FasterXML/jackson-databind/issues/2643) 됨.
    * 필드 이름 없이 Array 만들지 못하도록 변경 됨.
  * [Spring Security 5.3](https://spring.io/blog/2020/03/05/spring-security-5-3-goes-ga)
    * [문서 개선](https://docs.spring.io/spring-security/site/docs/5.3.0.RELEASE/reference/html5/#servlet-architecture)
    * OAuth 2.0 클라이언트와 리소스 서버 관련 기능 개선
  * [JUnit Jupiter 5.6](https://junit.org/junit5/docs/current/release-notes/index.html#release-notes-5.6.0)
  * [Mockito 3.3](https://javadoc.io/static/org.mockito/mockito-core/3.3.3/org/mockito/Mockito.html)
- 프로퍼티 변경
  * Period 지원
    * PeriodToStringConverter
    * StringToPeriodConverter
  * spring.data.jpa.repositories.bootstrap-mode 기본으로 deferred 모드.
  * https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3.0-Configuration-Changelog
- Spring-Boot-Starter-Validation 추가

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>
  ```

- 업그레이드 반드시 프로퍼티 마이그레이터로 변경해야 하는 프로퍼티를 확인하세요.

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-properties-migrator</artifactId>
      <scope>runtime</scope>
  </dependency>
  ```
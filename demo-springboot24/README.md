## 스프링 부트 2.4 변경 내역 소개
- https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.4-Release-Notes
- 주요 변경 내역
    * 스프링 5.3
    * 자바 15 지원
    * 의존성과 프로퍼티 변경
    * 설정 파일 처리 방식에 많은 변경

## 의존성과 프로퍼티 변경
- 의존성 변경
  * [스프링 프레임워크 5.3](https://spring.io/blog/2020/06/25/first-spring-framework-5-3-milestone-released)
    * LTS 버전으로 5.3.x가 계속 이어질 예정. 5.4는 없다.
    * 즉, 스프링 5의 테마 (코틀린, 리액티브, Funcationl, 자바 8+)를 완성하는 버전
    * GraalVM (JVM 보다 더 빠르고 유지관리하기 쉬운 VM) 을 위한 개선
    * R2DBC를 지원하는 spring-r2dbc 모듈 제공
    * queryForStream 제공
    * [스프링 플랫폼 2020 발표 영상](https://www.youtube.com/watch?v=u0qrHua7s6M)
  * [스프링 데이터 2020.0](https://spring.io/blog/2020/06/25/first-milestone-of-spring-data-2020-0-available)
    * 버저닝을 캘린더 기반으로 바꿈. (코드명은 여전히 수학자 이름을 따지만)
    * RxJava 3 지원
  * [스프링 배치 4.3](https://spring.io/blog/2020/06/26/spring-batch-4-3-0-m1-is-released-now)
    * 성능 향상
- 프로퍼티 변경
  * spring.profiles
    * 해당 설정 파일이 어떤 프로파일용인지 설정하는 값
    * 좀 더 직관적으로 spring.config.activate.on-profile 라는 이름으로 변경
  * https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.4.0-M3-Configuration-Changelog
- 업그레이드 반드시 프로퍼티 마이그레이터로 변경해야 하는 프로퍼티를 확인하세요.

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-properties-migrator</artifactId>
      <scope>runtime</scope>
  </dependency>
  ```

## 설정 파일 처리 방식 변경
- 기존 application.properteis와 application.yaml의 문제들
  * 문제 1. application.properties는 여러 문서를 표현할 수 없다.
  * 문제 2. spring.profiles (설정을 적용할 프로파일) 이름이 모호하다.
  * 문제 3. 설정을 읽어들이는 순서가 복잡하다.
- 문제 1 해결. 스프링 부트 2.4부터는 application.properties 도 파일 하나에 여러 문서를 표현할 수 있다.
  * // application.properties
  
  ```properties
  my.message=스프링 부트 2.1
  #---
  my.message=스프링 부트 2.2
  #---
  my.message=스프링 부트 2.3
  ```

  * '#---' 를 사용해서 문서를 구분한다.
  * 아직 IDEA가 제대로 이해하지 못할 수 있다.
  * 아래 있는 문서가 위에 있는 문서의 값을 덮어쓴다.

- 문제 2 해결. spring.profiles 대신 보다 직관적인 spring.config.activate.on-profile 를 사용한다.
  * spring.config.activate.on-profile: 현재 설정을 적용할 프로파일
  * spring.profiles.active 사용할 프로파일
  * spring.profiles.include 추가로 사용할 프로파일
- 문제 3 해결. 특정 프로파일을 사용하거나 추가하는 설정과 현재 설정을 적용할 프로파일을 같이 사용할 수 없다.
- 참고
  * https://spring.io/blog/2020/08/14/config-file-processing-in-spring-boot-2-4
  * https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-Config-Data-Migration-Guide
  * https://docs.spring.io/spring-boot/docs/2.4.0-SNAPSHOT/reference/htmlsingle/#boot-features-external-config-files

## 설정 파일 추가
- 설정 파일 추가
  * spring.config.import
  * spring.config.active.on-profile과 같이 사용할 수 있다. (프로파일을 추가하는 것은 안되지만, 설정 파일을 추가하는 것은 허용)
  * 추가하는 설정 파일을 제일 아래 있는 문서로 취급한다. 즉, 기존의 다른 설정을 덮어쓴다.
- application.properties

```properties
spring.config.activate.on-profile=local
spring.config.import=classpath:local.properties
my.message=스프링 부트 2.4
```

- local.properties

```properties
my.message=스프링 부트 2.4.3
```

- 이 경우에 local.properties를 제일 아래 있는 설정으로 취급하여 application.properties 설정을 덮어쓴다.  